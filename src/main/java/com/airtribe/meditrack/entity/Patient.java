package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.util.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 * Patient entity extending Person.
 * Demonstrates cloning (deep vs shallow), immutability via BillSummary.
 */
public class Patient extends Person implements Cloneable {
    private String bloodGroup;
    private List<String> allergies; // mutable list
    private String primaryDoctorId;

    public Patient(String id, String name, int age, String contactNumber,
                   String bloodGroup, List<String> allergies, String primaryDoctorId) {
        super(id, name, age, contactNumber);
        this.setBloodGroup(bloodGroup);
        this.allergies = allergies != null ? new ArrayList<>(allergies) : new ArrayList<>();
        this.primaryDoctorId = primaryDoctorId;
    }

    // Copy constructor for deep cloning
    public Patient(Patient other) {
        super(other);
        this.bloodGroup = other.bloodGroup;
        this.allergies = new ArrayList<>(other.allergies); // deep copy of list
        this.primaryDoctorId = other.primaryDoctorId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        if (bloodGroup == null || !bloodGroup.matches("(A|B|AB|O)[+-]")) {
            throw new IllegalArgumentException("Invalid blood group format");
        }
        this.bloodGroup = bloodGroup;
    }

    public List<String> getAllergies() {
        return new ArrayList<>(allergies); // defensive copy
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies != null ? new ArrayList<>(allergies) : new ArrayList<>();
    }

    public void addAllergy(String allergy) {
        if (allergy != null && !allergy.trim().isEmpty()) {
            this.allergies.add(allergy);
        }
    }

    public String getPrimaryDoctorId() {
        return primaryDoctorId;
    }

    public void setPrimaryDoctorId(String primaryDoctorId) {
        this.primaryDoctorId = primaryDoctorId;
    }

    @Override
    public Patient clone() {
        try {
            Patient cloned = (Patient) super.clone();
            // Need to deep copy mutable fields
            cloned.allergies = new ArrayList<>(this.allergies);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported", e);
        }
    }

    // Deep copy method
    public Patient deepCopy() {
        return new Patient(this);
    }

    // Shallow copy method (same as clone() but we can implement differently)
    public Patient shallowCopy() {
        Patient copy = new Patient(getId(), getName(), getAge(), getContactNumber(),
                bloodGroup, allergies, primaryDoctorId);
        // Note: allergies list is shared (shallow)
        copy.allergies = this.allergies;
        return copy;
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", contactNumber='" + getContactNumber() + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", allergies=" + allergies +
                ", primaryDoctorId='" + primaryDoctorId + '\'' +
                '}';
    }
}