package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.AppointmentStatus;
import com.airtribe.meditrack.exception.AppointmentNotFoundException;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.IdGenerator;
import com.airtribe.meditrack.util.DateUtil;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for managing appointments.
 * Demonstrates CRUD, status transitions, and search.
 */
public class AppointmentService {
    private final DataStore<Appointment> appointmentStore;
    private final IdGenerator idGenerator;

    public AppointmentService(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
        this.appointmentStore = new DataStore<>(idGenerator);
    }

    public String createAppointment(String patientId, String doctorId,
                                    LocalDateTime appointmentTime, String notes) {
        String id = idGenerator.generateId("APT");
        Appointment appointment = new Appointment(id, patientId, doctorId,
                appointmentTime, AppointmentStatus.PENDING, notes);
        appointmentStore.addWithId(id, appointment);
        return id;
    }

    public Appointment getAppointment(String id) {
        Appointment appt = appointmentStore.get(id);
        if (appt == null) {
            throw new AppointmentNotFoundException("Appointment with ID " + id + " not found");
        }
        return appt;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentStore.getAll();
    }

    public boolean updateAppointment(String id, Appointment updated) {
        if (appointmentStore.get(id) == null) {
            return false;
        }
        updated.setId(id);
        return appointmentStore.update(id, updated);
    }

    public boolean deleteAppointment(String id) {
        return appointmentStore.delete(id);
    }

    // Status transitions
    public boolean confirmAppointment(String id) {
        Appointment appt = appointmentStore.get(id);
        if (appt == null) return false;
        appt.setStatus(AppointmentStatus.CONFIRMED);
        return appointmentStore.update(id, appt);
    }

    public boolean cancelAppointment(String id) {
        Appointment appt = appointmentStore.get(id);
        if (appt == null) return false;
        appt.setStatus(AppointmentStatus.CANCELLED);
        return appointmentStore.update(id, appt);
    }

    public boolean completeAppointment(String id) {
        Appointment appt = appointmentStore.get(id);
        if (appt == null) return false;
        appt.setStatus(AppointmentStatus.COMPLETED);
        return appointmentStore.update(id, appt);
    }

    // Search methods
    public List<Appointment> searchByPatientId(String patientId) {
        return appointmentStore.search(a -> a.getPatientId().equals(patientId));
    }

    public List<Appointment> searchByDoctorId(String doctorId) {
        return appointmentStore.search(a -> a.getDoctorId().equals(doctorId));
    }

    public List<Appointment> searchByStatus(AppointmentStatus status) {
        return appointmentStore.search(a -> a.getStatus() == status);
    }

    public List<Appointment> searchUpcoming() {
        LocalDateTime now = LocalDateTime.now();
        return appointmentStore.getAll().stream()
                .filter(a -> a.getAppointmentTime().isAfter(now))
                .collect(Collectors.toList());
    }

    // Statistics
    public long countAppointments() {
        return appointmentStore.size();
    }

    public long countByStatus(AppointmentStatus status) {
        return appointmentStore.getAll().stream()
                .filter(a -> a.getStatus() == status)
                .count();
    }

    // Cloning demonstration
    public Appointment cloneAppointment(String id) {
        Appointment original = appointmentStore.get(id);
        if (original == null) return null;
        return original.deepCopy();
    }
}