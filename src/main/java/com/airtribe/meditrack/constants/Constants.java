package com.airtribe.meditrack.constants;

/**
 * Application-wide constants.
 */
public final class Constants {
    private Constants() {}

    // Tax rate for billing (e.g., 8.5%)
    public static final double TAX_RATE = 8.5;

    // File paths for persistence
    public static final String PATIENTS_CSV = "data/patients.csv";
    public static final String DOCTORS_CSV = "data/doctors.csv";
    public static final String APPOINTMENTS_CSV = "data/appointments.csv";
    public static final String BILLS_CSV = "data/bills.csv";

    // Appointment statuses (also defined as enum)
    public static final String STATUS_CONFIRMED = "CONFIRMED";
    public static final String STATUS_CANCELLED = "CANCELLED";
    public static final String STATUS_PENDING = "PENDING";

    // Specializations
    public static final String[] SPECIALIZATIONS = {
        "Cardiology", "Dermatology", "Neurology", "Pediatrics", "Orthopedics", "General"
    };

    // Validation limits
    public static final int MIN_AGE = 0;
    public static final int MAX_AGE = 120;
    public static final double MIN_FEE = 0.0;
    public static final double MAX_FEE = 10000.0;
}