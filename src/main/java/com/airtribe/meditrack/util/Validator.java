package com.airtribe.meditrack.util;

import com.airtribe.meditrack.constants.Constants;
import com.airtribe.meditrack.exception.InvalidDataException;

/**
 * Centralized validation utility.
 * Demonstrates static methods and exception handling.
 */
public final class Validator {
    private Validator() {}

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidDataException("Name cannot be null or empty");
        }
        if (name.length() > 100) {
            throw new InvalidDataException("Name too long (max 100 characters)");
        }
    }

    public static void validateAge(int age) {
        if (age < Constants.MIN_AGE || age > Constants.MAX_AGE) {
            throw new InvalidDataException("Age must be between " + Constants.MIN_AGE + " and " + Constants.MAX_AGE);
        }
    }

    public static void validateContactNumber(String contact) {
        if (contact == null || !contact.matches("\\d{10}")) {
            throw new InvalidDataException("Contact number must be exactly 10 digits");
        }
    }

    public static void validateFee(double fee) {
        if (fee < Constants.MIN_FEE || fee > Constants.MAX_FEE) {
            throw new InvalidDataException("Fee must be between " + Constants.MIN_FEE + " and " + Constants.MAX_FEE);
        }
    }

    public static void validateId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new InvalidDataException("ID cannot be null or empty");
        }
    }

    public static void validateSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new InvalidDataException("Specialization cannot be empty");
        }
        // Could check against allowed list
    }
}