package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.util.DateUtil;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Appointment entity linking Patient and Doctor.
 * Demonstrates cloning, enum usage, and date handling.
 */
public class Appointment implements Cloneable {
    private String id;
    private String patientId;
    private String doctorId;
    private LocalDateTime appointmentTime;
    private AppointmentStatus status;
    private String notes;

    public Appointment(String id, String patientId, String doctorId,
                       LocalDateTime appointmentTime, AppointmentStatus status, String notes) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.notes = notes;
    }

    // Copy constructor for deep cloning
    public Appointment(Appointment other) {
        this.id = other.id;
        this.patientId = other.patientId;
        this.doctorId = other.doctorId;
        this.appointmentTime = other.appointmentTime; // LocalDateTime is immutable
        this.status = other.status;
        this.notes = other.notes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public Appointment clone() {
        try {
            return (Appointment) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported", e);
        }
    }

    // Deep copy method
    public Appointment deepCopy() {
        return new Appointment(this);
    }

    // Shallow copy method
    public Appointment shallowCopy() {
        return this.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", appointmentTime=" + DateUtil.formatDateTime(appointmentTime) +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                '}';
    }
}