package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.IdGenerator;
import com.airtribe.meditrack.util.Validator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for managing patients.
 * Demonstrates CRUD, search overloading, and cloning.
 */
public class PatientService {
    private final DataStore<Patient> patientStore;
    private final IdGenerator idGenerator;

    public PatientService(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
        this.patientStore = new DataStore<>(idGenerator);
    }

    public String addPatient(Patient patient) {
        Validator.validateName(patient.getName());
        Validator.validateAge(patient.getAge());
        Validator.validateContactNumber(patient.getContactNumber());
        String id = idGenerator.generateId("PAT");
        patient.setId(id);
        patientStore.addWithId(id, patient);
        return id;
    }

    public Patient getPatient(String id) {
        return patientStore.get(id);
    }

    public List<Patient> getAllPatients() {
        return patientStore.getAll();
    }

    public boolean updatePatient(String id, Patient updated) {
        if (patientStore.get(id) == null) {
            return false;
        }
        Validator.validateName(updated.getName());
        Validator.validateAge(updated.getAge());
        Validator.validateContactNumber(updated.getContactNumber());
        updated.setId(id);
        return patientStore.update(id, updated);
    }

    public boolean deletePatient(String id) {
        return patientStore.delete(id);
    }

    // Search overloads
    public List<Patient> searchPatient(String id) {
        Patient p = patientStore.get(id);
        return p != null ? List.of(p) : List.of();
    }

    public List<Patient> searchPatientByName(String name) {
        return patientStore.search(p -> p.getName().toLowerCase().contains(name.toLowerCase()));
    }

    public List<Patient> searchPatientByAge(int age) {
        return patientStore.search(p -> p.getAge() == age);
    }

    public List<Patient> searchPatientByBloodGroup(String bloodGroup) {
        return patientStore.search(p -> p.getBloodGroup().equalsIgnoreCase(bloodGroup));
    }

    // Cloning demonstration
    public Patient clonePatient(String id) {
        Patient original = patientStore.get(id);
        if (original == null) {
            return null;
        }
        return original.deepCopy();
    }

    public Patient shallowClonePatient(String id) {
        Patient original = patientStore.get(id);
        if (original == null) {
            return null;
        }
        return original.shallowCopy();
    }

    // Statistics
    public long countPatients() {
        return patientStore.size();
    }

    public double averageAge() {
        List<Patient> patients = patientStore.getAll();
        if (patients.isEmpty()) return 0.0;
        return patients.stream().mapToInt(Patient::getAge).average().orElse(0.0);
    }

    public List<Patient> getPatientsWithAllergies() {
        return patientStore.getAll().stream()
                .filter(p -> !p.getAllergies().isEmpty())
                .collect(Collectors.toList());
    }
}