# MediTrack - Setup Instructions

## System Requirements
- Java Development Kit (JDK) 8 or higher
- Any IDE (IntelliJ IDEA, Eclipse, VS Code) or command line
- At least 2GB RAM
- 500MB disk space

## Installation Steps

### 1. Clone or Download the Project
```bash
git clone <repository-url>
cd MediTrack
```

### 2. Verify Java Installation
```bash
java -version
```
Expected output: `java version "1.8.0_xxx"` or higher

### 3. Compile the Project
Navigate to the project root directory and run:
```bash
javac -d out -sourcepath src/main/java src/main/java/com/airtribe/meditrack/Main.java
```

Alternatively, use the provided compile script (if available):
```bash
./compile.sh  # Linux/Mac
compile.bat   # Windows
```

### 4. Run the Application
```bash
java -cp out com.airtribe.meditrack.Main
```

### 5. Run Tests
To execute the test runner:
```bash
java -cp out com.airtribe.meditrack.test.TestRunner
```

## Project Structure
```
MediTrack/
├── src/main/java/com/airtribe/meditrack/
│   ├── Main.java                    # Entry point with menu-driven UI
│   ├── constants/                   # Application constants
│   ├── entity/                      # Core entities (Person, Doctor, Patient, etc.)
│   ├── service/                     # Business logic services
│   ├── util/                        # Utility classes
│   ├── exception/                   # Custom exceptions
│   ├── interfaces/                  # Interfaces (Searchable, Payable)
│   └── test/                        # Test runner
├── data/                            # CSV data files (auto-created)
├── docs/                            # Documentation
└── README.md                        # Project overview
```

## Data Persistence
The application automatically creates CSV files in the `data/` directory:
- `data/patients.csv` - Patient records
- `data/doctors.csv` - Doctor records  
- `data/appointments.csv` - Appointment records
- `data/bills.csv` - Bill records

## Troubleshooting

### Common Issues

1. **"package does not exist" errors**
   - Ensure you're compiling from the project root directory
   - Use `-sourcepath` flag as shown above
   - Check that all Java files are in the correct package directories

2. **CSV file permissions**
   - If you see file access errors, ensure the `data/` directory is writable
   - On Windows, run as administrator if needed

3. **Java version mismatch**
   - The project uses Java 8 features (LocalDateTime, streams, lambdas)
   - Update to JDK 8+ if you have an older version

4. **Out of memory errors**
   - Increase heap size: `java -Xmx512m -cp out com.airtribe.meditrack.Main`

## Quick Start Example

1. Compile and run the application
2. From the main menu, select "1. Manage Doctors"
3. Add a few doctors with different specializations
4. Add patients
5. Schedule appointments
6. Explore the "Demonstrate OOP Concepts" and "Demonstrate Advanced Features" menus

## IDE Setup (IntelliJ/Eclipse)

### IntelliJ IDEA
1. File → Open → Select the MediTrack folder
2. Mark `src/main/java` as Sources Root
3. Build → Build Project
4. Run → Edit Configurations → Add Application
5. Main class: `com.airtribe.meditrack.Main`
6. Click Run

### Eclipse
1. File → Import → Existing Projects into Workspace
2. Select the MediTrack folder
3. Right-click project → Build Path → Configure Build Path
4. Ensure Java version is 1.8 or higher
5. Run → Run As → Java Application

## Dependencies
This project has no external dependencies - it uses pure Java SE libraries only.

## Support
For issues or questions, refer to the Design_Decisions.md document or contact the development team.