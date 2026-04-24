package com.airtribe.meditrack.util;

import com.airtribe.meditrack.entity.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility for reading/writing entities to CSV files.
 * Demonstrates file I/O, try-with-resources, and CSV parsing.
 */
public final class CSVUtil {
    private CSVUtil() {}

    // Patient CSV format: id,name,age,contact,bloodGroup,allergies,primaryDoctorId
    public static void savePatients(List<Patient> patients, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("id,name,age,contact,bloodGroup,allergies,primaryDoctorId\n");
            for (Patient p : patients) {
                String allergies = String.join(";", p.getAllergies());
                writer.write(String.format("%s,%s,%d,%s,%s,%s,%s\n",
                        p.getId(), p.getName(), p.getAge(), p.getContactNumber(),
                        p.getBloodGroup(), allergies, p.getPrimaryDoctorId()));
            }
        }
    }

    public static List<Patient> loadPatients(String filePath) throws IOException {
        List<Patient> patients = new ArrayList<>();
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            return patients;
        }
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine(); // header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length < 7) continue;
                String id = parts[0];
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String contact = parts[3];
                String bloodGroup = parts[4];
                List<String> allergies = new ArrayList<>();
                if (!parts[5].isEmpty()) {
                    for (String a : parts[5].split(";")) {
                        allergies.add(a);
                    }
                }
                String primaryDoctorId = parts[6];
                patients.add(new Patient(id, name, age, contact, bloodGroup, allergies, primaryDoctorId));
            }
        }
        return patients;
    }

    // Doctor CSV format: id,name,age,contact,specialization,fee,yearsOfExperience
    public static void saveDoctors(List<Doctor> doctors, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("id,name,age,contact,specialization,fee,yearsOfExperience\n");
            for (Doctor d : doctors) {
                writer.write(String.format("%s,%s,%d,%s,%s,%.2f,%d\n",
                        d.getId(), d.getName(), d.getAge(), d.getContactNumber(),
                        d.getSpecialization(), d.getConsultationFee(), d.getYearsOfExperience()));
            }
        }
    }

    public static List<Doctor> loadDoctors(String filePath) throws IOException {
        List<Doctor> doctors = new ArrayList<>();
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            return doctors;
        }
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length < 7) continue;
                String id = parts[0];
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String contact = parts[3];
                String specialization = parts[4];
                double fee = Double.parseDouble(parts[5]);
                int years = Integer.parseInt(parts[6]);
                doctors.add(new Doctor(id, name, age, contact, specialization, fee, years));
            }
        }
        return doctors;
    }

    // Appointment CSV format: id,patientId,doctorId,appointmentTime,status,notes
    public static void saveAppointments(List<Appointment> appointments, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("id,patientId,doctorId,appointmentTime,status,notes\n");
            for (Appointment a : appointments) {
                writer.write(String.format("%s,%s,%s,%s,%s,%s\n",
                        a.getId(), a.getPatientId(), a.getDoctorId(),
                        DateUtil.formatDateTime(a.getAppointmentTime()),
                        a.getStatus().name(), a.getNotes()));
            }
        }
    }

    public static List<Appointment> loadAppointments(String filePath) throws IOException {
        List<Appointment> appointments = new ArrayList<>();
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            return appointments;
        }
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length < 6) continue;
                String id = parts[0];
                String patientId = parts[1];
                String doctorId = parts[2];
                LocalDateTime time = DateUtil.parseDateTime(parts[3]);
                AppointmentStatus status = AppointmentStatus.valueOf(parts[4]);
                String notes = parts[5];
                appointments.add(new Appointment(id, patientId, doctorId, time, status, notes));
            }
        }
        return appointments;
    }

    // Generic method for any list of strings
    public static void writeLines(List<String> lines, String filePath) throws IOException {
        Files.write(Paths.get(filePath), lines);
    }

    public static List<String> readLines(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}