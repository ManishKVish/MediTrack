# MediTrack — Clinic & Appointment Management System

![Java](https://img.shields.io/badge/Java-8%2B-blue)
![License](https://img.shields.io/badge/License-MIT-green)
![Status](https://img.shields.io/badge/Status-Complete-brightgreen)

A comprehensive Java application demonstrating Object-Oriented Programming (OOP) principles and advanced Java features through a practical clinic management system.

## 📋 Overview

MediTrack is a console-based clinic management system that allows users to:
- Manage doctor and patient records
- Schedule and track appointments
- Generate medical bills
- Demonstrate core and advanced OOP concepts
- Persist data using CSV files

## 🎯 Learning Objectives

This project serves as an educational tool covering:

### Core OOP Concepts
- **Encapsulation**: Private fields with public getters/setters
- **Inheritance**: Abstract `Person` class extended by `Doctor` and `Patient`
- **Polymorphism**: Method overloading, interface implementation
- **Abstraction**: Abstract classes and interfaces

### Advanced Java Features
- **Cloning**: Deep vs shallow copy implementation
- **Immutability**: `BillSummary` as immutable class
- **Enums**: `AppointmentStatus` with methods
- **Static Initialization**: Static blocks and fields
- **Generics**: `DataStore<T>` reusable storage
- **Exception Handling**: Custom exceptions
- **Java 8+ Features**: Streams, lambdas, LocalDateTime

## 🏗️ Project Structure

```
MediTrack/
├── src/main/java/com/airtribe/meditrack/
│   ├── Main.java                    # Entry point with menu-driven UI
│   ├── constants/                   # Application constants
│   ├── entity/                      # Core domain entities
│   │   ├── Person.java              # Abstract base class
│   │   ├── Doctor.java              # Doctor entity
│   │   ├── Patient.java             # Patient entity (Cloneable)
│   │   ├── Appointment.java         # Appointment entity
│   │   ├── AppointmentStatus.java   # Enum for status
│   │   ├── Bill.java                # Bill entity
│   │   └── BillSummary.java         # Immutable bill summary
│   ├── service/                     # Business logic
│   │   ├── DoctorService.java       # Doctor CRUD operations
│   │   ├── PatientService.java      # Patient CRUD & cloning
│   │   └── AppointmentService.java  # Appointment management
│   ├── util/                        # Utility classes
│   │   ├── Validator.java           # Centralized validation
│   │   ├── DateUtil.java            # Date/time utilities
│   │   ├── IdGenerator.java         # Singleton ID generator
│   │   ├── DataStore.java           # Generic in-memory storage
│   │   ├── CSVUtil.java             # CSV file I/O
│   │   └── AIHelper.java            # Rule-based recommendations
│   ├── exception/                   # Custom exceptions
│   │   ├── InvalidDataException.java
│   │   └── AppointmentNotFoundException.java
│   ├── interfaces/                  # Interfaces
│   │   ├── Searchable.java          # Searchable entities
│   │   └── Payable.java             # Payable entities
│   └── test/                        # Test suite
│       └── TestRunner.java          # Manual test runner
├── data/                            # CSV data storage (auto-created)
├── docs/                            # Documentation
│   ├── Setup_Instructions.md        # Installation guide
│   ├── JVM_Report.md               # JVM analysis
│   └── Design_Decisions.md         # Architectural decisions
└── README.md                       # This file
```

## 🚀 Quick Start

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line or IDE (IntelliJ, Eclipse, VS Code)

### Compilation & Execution

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd MediTrack
   ```

2. **Compile the project**
   ```bash
   javac -d out -sourcepath src/main/java src/main/java/com/airtribe/meditrack/Main.java
   ```

3. **Run the application**
   ```bash
   java -cp out com.airtribe.meditrack.Main
   ```

4. **Run tests**
   ```bash
   java -cp out com.airtribe.meditrack.test.TestRunner
   ```

### IDE Setup
- **IntelliJ**: Open project, mark `src/main/java` as Sources Root
- **Eclipse**: Import as existing Java project
- **VS Code**: Open folder, install Java extensions

## 📖 Features

### 1. Doctor Management
- Add, view, search, and delete doctors
- Search by name, specialization, or keyword
- Validation of consultation fees and experience

### 2. Patient Management
- Add, view, and delete patients
- Demonstrate cloning (deep vs shallow)
- Medical history tracking

### 3. Appointment Management
- Schedule appointments between doctors and patients
- Update appointment status (PENDING, CONFIRMED, COMPLETED, CANCELLED)
- Cancel appointments

### 4. Billing System
- Generate medical bills with tax calculation
- Create immutable bill summaries
- Apply discounts via Payable interface

### 5. Data Persistence
- Automatic CSV file creation
- Load/save doctors, patients, appointments
- Data survives application restarts

### 6. Advanced Features
- **AI Recommendations**: Rule-based doctor matching using streams
- **Search Interface**: Unified search across entities
- **Validation Utility**: Centralized input validation
- **Date Utilities**: Modern Java Time API usage

## 🧪 OOP Concepts Demonstrated

| Concept | Implementation Example |
|---------|------------------------|
| **Encapsulation** | Private fields with validation in setters |
| **Inheritance** | `Person` → `Doctor` and `Patient` |
| **Polymorphism** | `Searchable` interface, method overloading |
| **Abstraction** | Abstract `Person` class |
| **Cloning** | `Patient.cloneDeep()` vs `cloneShallow()` |
| **Immutability** | `BillSummary` with final fields |
| **Singleton** | `IdGenerator` with eager/lazy initialization |
| **Generics** | `DataStore<T>` reusable storage |
| **Enums** | `AppointmentStatus` with descriptions |
| **Static** | Static blocks in `Person` class |

## 📊 Grading Breakdown (Educational Context)

| Category | Weight | Description |
|----------|--------|-------------|
| **Core OOP** | 30% | Encapsulation, inheritance, polymorphism, abstraction |
| **Advanced OOP** | 25% | Cloning, immutability, enums, static initialization |
| **Collections & Generics** | 15% | DataStore, streams, comparators |
| **Exception Handling** | 10% | Custom exceptions, validation |
| **File I/O** | 10% | CSV persistence |
| **Documentation** | 10% | README, design decisions, setup instructions |

## 🔧 Technical Details

### Design Patterns
- **Singleton**: `IdGenerator`
- **Factory**: Service classes creating entities
- **Strategy**: `Searchable` interface implementations
- **Template Method**: `Person` abstract class
- **Observer**: Potential for appointment notifications

### Java Version Compatibility
- **Minimum**: Java SE 8 (1.8.0)
- **Recommended**: Java SE 11+
- **Tested On**: Java 8, 11, 17

### Memory Management
- Efficient object lifecycle
- Generic `DataStore` with HashMap
- CSV streaming for large datasets
- Automatic garbage collection

## 📚 Documentation

Detailed documentation is available in the `docs/` directory:

1. **[Setup_Instructions.md](docs/Setup_Instructions.md)** - Installation and configuration
2. **[JVM_Report.md](docs/JVM_Report.md)** - JVM analysis and optimization
3. **[Design_Decisions.md](docs/Design_Decisions.md)** - Architectural choices and rationale

## 🧪 Testing

The project includes a comprehensive test runner:
```bash
java -cp out com.airtribe.meditrack.test.TestRunner
```

Tests cover:
- Entity creation and validation
- Service operations (CRUD)
- Cloning functionality
- CSV persistence
- AI recommendations
- Interface implementations

## 🔄 Future Enhancements

Potential improvements include:
1. **Database Integration**: Replace CSV with SQLite/MySQL
2. **Web Interface**: REST API with Spring Boot
3. **Multi-threading**: Concurrent access to services
4. **Graphical UI**: JavaFX or Swing interface
5. **Reporting**: Advanced analytics and reports
6. **Authentication**: User login and role-based access

## 👥 Team Collaboration

This project demonstrates Git-based collaboration with:
- Clear package structure for parallel development
- Separation of concerns for independent work
- Comprehensive documentation for onboarding
- Test suite for regression testing

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🙏 Acknowledgments

- Java Platform, Standard Edition
- Object-Oriented Programming principles
- Educational institutions for curriculum guidance
- Open source community for best practices

## 📞 Support

For issues or questions:
1. Check the documentation in `docs/`
2. Review the test runner for functionality examples
3. Examine the source code for implementation details

---

**MediTrack** - A practical demonstration of Java OOP excellence. Perfect for educational purposes, portfolio projects, and understanding real-world application of software engineering principles.