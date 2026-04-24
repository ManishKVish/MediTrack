package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.util.Validator;

/**
 * Doctor entity extending Person.
 * Demonstrates inheritance, encapsulation, and specialization.
 */
public class Doctor extends Person {
    private String specialization;
    private double consultationFee;
    private int yearsOfExperience;

    public Doctor(String id, String name, int age, String contactNumber,
                  String specialization, double consultationFee, int yearsOfExperience) {
        super(id, name, age, contactNumber);
        this.setSpecialization(specialization);
        this.setConsultationFee(consultationFee);
        this.setYearsOfExperience(yearsOfExperience);
    }

    // Copy constructor for cloning
    public Doctor(Doctor other) {
        super(other);
        this.specialization = other.specialization;
        this.consultationFee = other.consultationFee;
        this.yearsOfExperience = other.yearsOfExperience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        Validator.validateSpecialization(specialization);
        this.specialization = specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        Validator.validateFee(consultationFee);
        this.consultationFee = consultationFee;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Years of experience cannot be negative");
        }
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", contactNumber='" + getContactNumber() + '\'' +
                ", specialization='" + specialization + '\'' +
                ", consultationFee=" + consultationFee +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}