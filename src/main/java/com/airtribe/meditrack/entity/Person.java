package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.util.Validator;

/**
 * Base class representing a person in the system.
 * Demonstrates encapsulation, inheritance, and validation.
 */
public abstract class Person {
    private String id;
    private String name;
    private int age;
    private String contactNumber;

    // Static counter for generating IDs (demonstrates static variable)
    private static int personCount = 0;

    // Static block for initialization (demonstrates static block)
    static {
        System.out.println("Person class loaded. Initializing static resources.");
        // Could load configuration etc.
    }

    public Person(String id, String name, int age, String contactNumber) {
        this.id = id;
        this.setName(name);
        this.setAge(age);
        this.setContactNumber(contactNumber);
        personCount++;
    }

    // Copy constructor for cloning
    protected Person(Person other) {
        this.id = other.id;
        this.name = other.name;
        this.age = other.age;
        this.contactNumber = other.contactNumber;
        // Note: we don't increment personCount because this is a copy of existing person
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        Validator.validateAge(age);
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        Validator.validateContactNumber(contactNumber);
        this.contactNumber = contactNumber;
    }

    public static int getPersonCount() {
        return personCount;
    }

    // Abstract method demonstrating abstraction
    public abstract String getRole();

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}