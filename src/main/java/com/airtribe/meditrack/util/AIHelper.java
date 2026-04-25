package com.airtribe.meditrack.util;

import com.airtribe.meditrack.entity.Doctor;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Simple rule‑based AI for doctor recommendations and appointment suggestions.
 * Demonstrates streams, lambdas, and basic decision logic.
 */
public final class AIHelper {
    private AIHelper() {}

    /**
     * Recommend doctors based on symptom keywords.
     */
    public static List<Doctor> recommendDoctors(List<Doctor> doctors, String symptom) {
        String lowerSymptom = symptom.toLowerCase();
        // Simple mapping of symptoms to specializations
        String recommendedSpecialization = mapSymptomToSpecialization(lowerSymptom);

        return doctors.stream()
                .filter(d -> d.getSpecialization().equalsIgnoreCase(recommendedSpecialization))
                .sorted((d1, d2) -> Integer.compare(d2.getYearsOfExperience(), d1.getYearsOfExperience()))
                .collect(Collectors.toList());
    }

    private static String mapSymptomToSpecialization(String symptom) {
        if (symptom.contains("chest") || symptom.contains("heart")) {
            return "Cardiology";
        } else if (symptom.contains("skin") || symptom.contains("rash")) {
            return "Dermatology";
        } else if (symptom.contains("headache") || symptom.contains("nerve")) {
            return "Neurology";
        } else if (symptom.contains("child") || symptom.contains("pediatric")) {
            return "Pediatrics";
        } else if (symptom.contains("bone") || symptom.contains("joint")) {
            return "Orthopedics";
        } else {
            return "General";
        }
    }

    /**
     * Suggest appointment slots (simple mock).
     */
    public static List<String> suggestAppointmentSlots(int count) {
        return java.util.stream.IntStream.range(0, count)
                .mapToObj(i -> {
                    java.time.LocalDateTime now = java.time.LocalDateTime.now();
                    java.time.LocalDateTime slot = now.plusDays(i + 1).withHour(9).withMinute(0);
                    return DateUtil.formatDateTime(slot);
                })
                .collect(Collectors.toList());
    }

    /**
     * Compute average consultation fee for a list of doctors.
     */
    public static double averageFee(List<Doctor> doctors) {
        return doctors.stream()
                .mapToDouble(Doctor::getConsultationFee)
                .average()
                .orElse(0.0);
    }

    /**
     * Find the most experienced doctor.
     */
    public static Doctor findMostExperienced(List<Doctor> doctors) {
        return doctors.stream()
                .max(java.util.Comparator.comparingInt(Doctor::getYearsOfExperience))
                .orElse(null);
    }
}