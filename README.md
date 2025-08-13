# School Management Adapter

A Java implementation of the **Adapter Design Pattern** for integrating diverse school management systems into a unified application. This project demonstrates how to seamlessly connect different school systems (attendance, grading, and library management) through adapter classes that translate incompatible interfaces.

## 📋 Overview

The School Management Adapter provides a unified interface for managing various school systems that have different APIs and methods. Instead of modifying existing systems or creating complex integration logic, the project uses adapter classes to translate between the target interface (`SchoolManagementApp`) and the adaptee systems (`AttendanceSystem`, `GradingSystem`, `LibrarySystem`).

## 🏗️ Architecture

This project implements the **Adapter Design Pattern** with the following components:

- **Target Interface**: `SchoolManagementApp` - Defines the common interface for all integrated systems
- **Adaptee Classes**: Legacy systems with incompatible interfaces (`AttendanceSystem`, `GradingSystem`, `LibrarySystem`)
- **Adapter Classes**: Bridge classes that translate between target and adaptee interfaces
- **Main Application**: Interactive console application demonstrating the adapter pattern

### Design Pattern Benefits

- **Compatibility**: Enables integration of systems with incompatible interfaces
- **Maintainability**: Existing systems remain unchanged while providing unified access
- **Extensibility**: Easy to add new systems by creating new adapters
- **Single Responsibility**: Each adapter handles translation for one specific system

## 📊 UML Class Diagram

```
┌─────────────────────┐    ┌─────────────────────┐    ┌─────────────────────┐
│ SchoolManagementApp │    │ AttendanceSystem    │    │ GradingSystem       │
│ (Target Interface)  │    │ (Adaptee)           │    │ (Adaptee)           │
├─────────────────────┤    ├─────────────────────┤    ├─────────────────────┤
│ + integrateSystem() │    │ + markAttendance()  │    │ + recordGrades()    │
└─────────────────────┘    └─────────────────────┘    └─────────────────────┘
           ▲                           ▲                         ▲
           │                           │                         │
           │ implements                │ uses                    │ uses
           │                           │                         │
┌─────────────────────┐    ┌─────────────────────┐    ┌─────────────────────┐
│AttendanceSystemAdap.│    │GradingSystemAdapter │    │LibrarySystemAdapter │
│    (Adapter)        │    │    (Adapter)        │    │    (Adapter)        │
├─────────────────────┤    ├─────────────────────┤    ├─────────────────────┤
│ - attendanceSystem  │    │ - gradingSystem     │    │ - librarySystem     │
│ + integrateSystem() │    │ + integrateSystem() │    │ + integrateSystem() │
└─────────────────────┘    └─────────────────────┘    └─────────────────────┘
           ▲                           ▲                         ▲
           │                           │                         │
           └───────────────────────────┼─────────────────────────┘
                                       │
                                       │ uses
                                       ▼
                            ┌─────────────────────┐
                            │       Main          │
                            │  (Client/Driver)    │
                            ├─────────────────────┤
                            │ + main()            │
                            └─────────────────────┘
```
The following diagram illustrates:
- The architecture of the School Management Adapter
- Relationships between the core components:
  - The `SchoolManagementApp` interface
  - Legacy systems: `AttendanceSystem`, `GradingSystem`, `LibrarySystem`
  - Adapter classes: `AttendanceSystemAdapter`, `GradingSystemAdapter`, `LibrarySystemAdapter`
  - The main application class
- How the Adapter design pattern is applied in this project

## 🚀 Features

- **Unified Interface**: Single `integrateSystem()` method for all school systems
- **Legacy System Integration**: Seamlessly integrates existing systems without modification
- **Interactive Console**: User-friendly menu-driven interface
- **Type-Safe Operations**: Strong typing for each system adapter
- **Extensible Design**: Easy to add new school systems with new adapters
- **Clean Architecture**: Well-structured, maintainable code following SOLID principles

## 📁 Project Structure

```
school-management-adapter/
├── src/
│   ├── SchoolManagementApp.java        # Target interface
│   ├── AttendanceSystem.java           # Attendance system (Adaptee)
│   ├── AttendanceSystemAdapter.java    # Attendance system adapter
│   ├── GradingSystem.java              # Grading system (Adaptee)
│   ├── GradingSystemAdapter.java       # Grading system adapter
│   ├── LibrarySystem.java              # Library system (Adaptee)
│   ├── LibrarySystemAdapter.java       # Library system adapter
│   └── Main.java                       # Main application driver
└── README.md                           # Project documentation
```

## 🛠️ Installation & Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.) or command line

### Getting Started

1. **Clone or download** the project files
2. **Navigate** to the project directory
3. **Compile** the Java files:
   ```bash
   javac src/*.java
   ```
4. **Run** the application:
   ```bash
   java -cp src Main
   ```

## 📖 Usage

### Interactive Console Application

The main application provides an interactive menu system:

```bash
WELCOME TO UNIFIED SCHOOL MANAGEMENT APPLICATION!

Please select a system:
1. Attendance System
2. Grading System
3. Library System
4. Exit

Enter your choice: 1
```

### Programmatic Usage

You can also use the adapters programmatically:

```java
// Create the legacy systems
AttendanceSystem attendanceSystem = new AttendanceSystem();
GradingSystem gradingSystem = new GradingSystem();
LibrarySystem librarySystem = new LibrarySystem();

// Create adapters for each system
SchoolManagementApp attendanceAdapter = new AttendanceSystemAdapter(attendanceSystem);
SchoolManagementApp gradingAdapter = new GradingSystemAdapter(gradingSystem);
SchoolManagementApp libraryAdapter = new LibrarySystemAdapter(librarySystem);

// Use unified interface
String attendanceResult = attendanceAdapter.integrateSystem();
String gradingResult = gradingAdapter.integrateSystem();
String libraryResult = libraryAdapter.integrateSystem();
```

### Expected Output

When you run the application and select different systems, you'll see:

```
WELCOME TO UNIFIED SCHOOL MANAGEMENT APPLICATION!

Please select a system:
1. Attendance System
2. Grading System
3. Library System
4. Exit

Enter your choice: 1

Attendance has been marked!

Please select a system:
1. Attendance System
2. Grading System
3. Library System
4. Exit

Enter your choice: 2

Grades have been recorded!

Please select a system:
1. Attendance System
2. Grading System
3. Library System
4. Exit

Enter your choice: 3

Books have been managed!
```

## 🔧 Extending the Project

### Adding New School Systems

To add a new school system (e.g., `TransportationSystem`):

1. **Create** the legacy system class:
   ```java
   public class TransportationSystem {
       public String manageTransport() {
           return "\nTransport has been managed!\n";
       }
   }
   ```

2. **Create** the adapter class:
   ```java
   public class TransportationSystemAdapter implements SchoolManagementApp {
       private final TransportationSystem transportationSystem;
   
       public TransportationSystemAdapter(TransportationSystem transportationSystem) {
           this.transportationSystem = transportationSystem;
       }
   
       @Override
       public String integrateSystem() {
           return transportationSystem.manageTransport();
       }
   }
   ```

3. **Update** the main application to include the new system

## 🎯 Design Patterns Used

### Adapter Pattern
- **Purpose**: Convert the interface of a class into another interface that clients expect
- **Benefits**: Enables incompatible interfaces to work together
- **Implementation**: Each adapter class implements `SchoolManagementApp` and delegates to the specific legacy system

### Key Components:
- **Target**: `SchoolManagementApp` interface
- **Adaptee**: Legacy systems (`AttendanceSystem`, `GradingSystem`, `LibrarySystem`)
- **Adapter**: Bridge classes that translate between target and adaptee
- **Client**: `Main` class that uses the unified interface

## 🔍 Code Examples

### Target Interface
```java
public interface SchoolManagementApp {
    String integrateSystem();
}
```

### Legacy System (Adaptee)
```java
public class AttendanceSystem {
    public String markAttendance() {
        return "\nAttendance has been marked!\n";
    }
}
```

### Adapter Implementation
```java
public class AttendanceSystemAdapter implements SchoolManagementApp {
    private final AttendanceSystem attendanceSystem;

    public AttendanceSystemAdapter(AttendanceSystem attendanceSystem) {
        this.attendanceSystem = attendanceSystem;
    }

    @Override
    public String integrateSystem() {
        return attendanceSystem.markAttendance();
    }
}
```

## 🤝 Contributing

Feel free to contribute to this project by:
- Adding new school management systems
- Improving the user interface
- Adding error handling and validation
- Creating unit tests
- Enhancing documentation

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

**Note**: This implementation demonstrates the Adapter design pattern, which is particularly useful when integrating legacy systems, third-party libraries, or systems with incompatible interfaces. The Adapter pattern allows you to work with existing code without modifying it, making it ideal for enterprise applications that need to integrate multiple systems.
