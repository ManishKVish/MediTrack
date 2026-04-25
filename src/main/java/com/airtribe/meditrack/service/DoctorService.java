package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.IdGenerator;
import com.airtribe.meditrack.util.Validator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for managing doctors.
 * Demonstrates CRUD, search with overloading, and use of DataStore.
 */
public class DoctorService {
    private final DataStore<Doctor> doctorStore;
    private final IdGenerator idGenerator;

    public DoctorService(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
        this.doctorStore = new DataStore<>(idGenerator);
    }

    // CRUD operations
    public String addDoctor(Doctor doctor) {
        Validator.validateName(doctor.getName());
        Validator.validateAge(doctor.getAge());
        Validator.validateContactNumber(doctor.getContactNumber());
        Validator.validateSpecialization(doctor.getSpecialization());
        Validator.validateFee(doctor.getConsultationFee());
        String id = idGenerator.generateId("DOC");
        doctor.setId(id);
        doctorStore.addWithId(id, doctor);
        return id;
    }

    public Doctor getDoctor(String id) {
        return doctorStore.get(id);
    }

    public List<Doctor> getAllDoctors() {
        return doctorStore.getAll();
    }

    public boolean updateDoctor(String id, Doctor updated) {
        if (doctorStore.get(id) == null) {
            return false;
        }
        Validator.validateName(updated.getName());
        Validator.validateAge(updated.getAge());
        Validator.validateContactNumber(updated.getContactNumber());
        Validator.validateSpecialization(updated.getSpecialization());
        Validator.validateFee(updated.getConsultationFee());
        updated.setId(id);
        return doctorStore.update(id, updated);
    }

    public boolean deleteDoctor(String id) {
        return doctorStore.delete(id);
    }

    // Search methods (overloading)
    public List<Doctor> searchDoctor(String id) {
        Doctor doc = doctorStore.get(id);
        return doc != null ? List.of(doc) : List.of();
    }

    public List<Doctor> searchDoctorByName(String name) {
        return doctorStore.search(d -> d.getName().toLowerCase().contains(name.toLowerCase()));
    }

    public List<Doctor> searchDoctorBySpecialization(String specialization) {
        return doctorStore.search(d -> d.getSpecialization().equalsIgnoreCase(specialization));
    }

    public List<Doctor> searchDoctorByExperience(int minYears) {
        return doctorStore.search(d -> d.getYearsOfExperience() >= minYears);
    }

    // Additional business logic
    public double calculateAverageFee() {
        List<Doctor> doctors = doctorStore.getAll();
        if (doctors.isEmpty()) return 0.0;
        double sum = doctors.stream().mapToDouble(Doctor::getConsultationFee).sum();
        return sum / doctors.size();
    }

    public List<Doctor> getDoctorsSortedByExperience(boolean ascending) {
        return doctorStore.getAll().stream()
                .sorted((d1, d2) -> ascending ?
                        Integer.compare(d1.getYearsOfExperience(), d2.getYearsOfExperience()) :
                        Integer.compare(d2.getYearsOfExperience(), d1.getYearsOfExperience()))
                .collect(Collectors.toList());
    }

    public int getDoctorCount() {
        return doctorStore.size();
    }
}