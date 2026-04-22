# Employee Self Service Portal (ESSP)

## 📖 Overview
The **Employee Self Service Portal (ESSP)** is a robust, desktop-based Java application designed to streamline HR operations. Built with a strict adherence to **Object-Oriented Analysis and Design (OOAD)** principles, this project demonstrates enterprise-level software architecture by cleanly decoupling the user interface from business logic and database layers.

## ✨ Key Features
* **Secure Authentication:** Login system validating credentials against a backend database.
* **Employee Dashboard:** Centralized hub for intuitive employee navigation.
* **Profile Management:** Dynamic retrieval of employee employment, department, and salary details.
* **Leave Application System:** Seamless leave request submission using Data Transfer Objects (DTOs) to securely transport data to the backend subsystem.
* **Document Management:** Secure file selection and metadata tracking for employee records.

## 🏗️ Architecture & Design
This project strictly follows an **N-Tier Layered Architecture** to ensure maintainability and scalability:
* `ui` (Presentation Layer): Built using Java Swing, handling only user interactions.
* `service` (Business Logic Layer): Processes rules and coordinates between the UI and Data layers.
* `repository` (Data Access Layer): Abstracted interfaces managing SQLite database transactions.
* `dto` (Data Transfer Objects): Carries data safely between subsystems without exposing internal database entities.

### 🧩 Design Patterns Implemented
1. **Facade Pattern:** Simplifies UI interactions with complex backend subsystems (`ESSPFacade`).
2. **Factory Pattern:** Centralizes and encapsulates the creation of complex objects (`ServiceFactory`, `RepositoryFactory`).
3. **Singleton Pattern:** Ensures a single, memory-efficient instance of core services like Authentication.
4. **Data Transfer Object (DTO) Pattern:** Encapsulates multiple data attributes (e.g., `LeaveRequestDTO`) into a single object for network and layer transit.

### 📏 SOLID & GRASP Principles
* **Single Responsibility Principle (SRP):** UI classes strictly handle rendering; Service classes handle logic.
* **Dependency Inversion Principle (DIP):** High-level services depend on abstract interfaces (e.g., `ILeaveRepository`), protecting the app from database crashes or swaps.
* **Liskov Substitution Principle (LSP):** Mock repositories (`MockLeaveRepositoryImpl`) seamlessly replace real database classes to allow parallel UI development.
* **Information Expert (GRASP):** Logic is assigned to the class with the most information (e.g., `EmployeeServiceImpl` handles profile data fetching).
* **Low Coupling / High Cohesion (GRASP):** Interfaces ensure that UI code remains untouched even if the underlying database technology changes from SQLite to MySQL.

## 💻 Technology Stack
* **Language:** Java (JDK 8+)
* **GUI Framework:** Java Swing
* **Database:** SQLite
* **ORM/Connectivity:** Hibernate / JDBC
* **Environment:** Visual Studio Code

## 🚀 How to Run the Application

**1. Navigate to the Source Directory:**
Open your terminal and navigate to the `src` folder:
```cmd
cd path/to/ESSP_Project/src
```

**2. Compile the Code:**
Create a list of the core source files and compile them, linking the external JAR library:
```cmd
dir /s /B ui\*.java service\impl\*.java repository\interfaces\*.java dto\*.java > sources.txt
javac -cp ".;..\lib\*" @sources.txt
```

**3. Launch the Application:**
Run the main entry point:
```cmd
java -cp ".;..\lib\*" ui.LoginFrame
```

## 🧪 Test Credentials
* **Username:** `alice@company.com`
* **Password:** `password123`

---
*Developed as a comprehensive OOAD project demonstrating advanced software engineering architectures and design patterns.*
