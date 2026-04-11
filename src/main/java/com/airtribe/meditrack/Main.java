package com.airtribe.meditrack;

/**
 * Main entry point for MediTrack Clinic Management System.
 * This project demonstrates comprehensive OOP concepts including:
 * - Encapsulation, Inheritance, Polymorphism, Abstraction
 * - Cloning, Immutability, Enums, Static initialization
 * - Generics, Collections, Exception handling
 * - File I/O, Design Patterns, Java 8+ features
 * 
 * The complete project includes:
 * - Entity classes (Person, Doctor, Patient, Appointment, Bill, BillSummary)
 * - Service classes (DoctorService, PatientService, AppointmentService)
 * - Utility classes (Validator, DateUtil, CSVUtil, IdGenerator, DataStore, AIHelper)
 * - Exception classes (InvalidDataException, AppointmentNotFoundException)
 * - Interfaces (Searchable, Payable)
 * - Test runner (TestRunner)
 * - Comprehensive documentation
 * 
 * To run the demonstration:
 * 1. Compile: javac -d out -sourcepath src/main/java src/main/java/com/airtribe/meditrack/Main.java
 * 2. Run: java -cp out com.airtribe.meditrack.Main
 * 3. Run tests: java -cp out com.airtribe.meditrack.test.TestRunner
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("   MediTrack - Clinic Management System");
        System.out.println("=============================================");
        System.out.println();
        System.out.println("A comprehensive Java OOP demonstration project");
        System.out.println();
        System.out.println("Project Structure:");
        System.out.println("├── src/main/java/com/airtribe/meditrack/");
        System.out.println("│   ├── constants/     - Application constants");
        System.out.println("│   ├── entity/        - Core domain entities");
        System.out.println("│   ├── service/       - Business logic services");
        System.out.println("│   ├── util/          - Utility classes");
        System.out.println("│   ├── exception/     - Custom exceptions");
        System.out.println("│   ├── interfaces/    - Searchable, Payable interfaces");
        System.out.println("│   └── test/          - Test runner");
        System.out.println("├── docs/              - Documentation");
        System.out.println("└── data/              - CSV data storage");
        System.out.println();
        System.out.println("OOP Concepts Demonstrated:");
        System.out.println("✓ Encapsulation - Private fields with validation");
        System.out.println("✓ Inheritance   - Person → Doctor, Patient");
        System.out.println("✓ Polymorphism  - Method overloading, interfaces");
        System.out.println("✓ Abstraction   - Abstract classes, interfaces");
        System.out.println("✓ Cloning       - Deep vs shallow copy");
        System.out.println("✓ Immutability  - BillSummary with final fields");
        System.out.println("✓ Enums         - AppointmentStatus enum");
        System.out.println("✓ Static        - Static blocks and fields");
        System.out.println("✓ Generics      - DataStore<T> reusable storage");
        System.out.println("✓ Exceptions    - Custom exception hierarchy");
        System.out.println("✓ File I/O      - CSV persistence");
        System.out.println("✓ Design Patterns - Singleton, Factory, Strategy");
        System.out.println("✓ Java 8+       - Streams, lambdas, LocalDateTime");
        System.out.println();
        System.out.println("To explore the code:");
        System.out.println("1. Review entity classes for OOP implementation");
        System.out.println("2. Check service classes for business logic");
        System.out.println("3. Examine util classes for reusable utilities");
        System.out.println("4. Run TestRunner for functionality demonstration");
        System.out.println();
        System.out.println("Documentation:");
        System.out.println("- docs/Setup_Instructions.md - Installation guide");
        System.out.println("- docs/JVM_Report.md        - JVM analysis");
        System.out.println("- docs/Design_Decisions.md  - Architectural decisions");
        System.out.println("- README.md                 - Project overview");
        System.out.println();
        System.out.println("=============================================");
        System.out.println("Project successfully loaded. Exiting.");
        System.out.println("=============================================");
    }
}