# HOTELIDAY - Hotel Management System

> **Academic Software Engineering Project | University of Patras - Department of Computer Engineering & Informatics | 2022-2023**

HOTELIDAY is a desktop **hotel management system** developed as part of the Software Technology course. The project was designed as an end-to-end software engineering exercise: from requirements analysis and project planning to object-oriented design, database integration, implementation, and final demonstration.

The system brings together **guest reservations, room management, staff operations, internal communication, announcements, orders, and basic financial/staff administration** in a single JavaFX application backed by MySQL.

## Demo

**Watch the project demonstration:**  
[▶️ YouTube - HOTELIDAY Demo](https://www.youtube.com/watch?v=-Bi-KYsa3y0&ab_channel=OdysseasZachos)

## Project at a Glance

| Area | Details |
|---|---|
| Application type | Desktop hotel management system |
| Primary language | Java |
| UI | JavaFX + FXML |
| Database | MySQL |
| Database connectivity | JDBC / MySQL Connector/J |
| Build | Maven |
| Modeling & documentation | Visual Paradigm, Lucid, draw.io |
| Team process | Kanban with weekly meetings |
| Scope | Requirements → design → implementation → demonstration |

## Key Functionality

### Customer-facing
- Search for available rooms using room type, capacity, and stay dates.
- Select optional hotel services such as meals, pool access, and tennis court access.
- Display room pricing and create reservations.
- Submit hotel feedback/rating through the application flow.

### Administration
- Role-based login for **customers, employees, and administrators**.
- Monitor room availability and current room status.
- View employee information and update salary records.
- Assign employee leave.
- Create material orders.
- Review operational information and reservations associated with rooms.
- Publish announcements to staff.
- Exchange messages with employees.

### Employee operations
- View assigned employee-facing menus.
- Check room-related information and report room status.
- Read announcements.
- Send and receive internal messages.

## Software Engineering Approach

A major strength of this project is that it was not treated as "just a coding assignment". The team followed a structured software engineering workflow and produced a complete set of project artifacts.

The repository includes final versions of:

- **Project plan** - task breakdown, dependencies, Gantt/PERT scheduling, resource allocation and cost estimation.
- **Risk assessment** - risks such as third-party integrations, scalability, legislation changes, language support, and market competition.
- **Use-case model** - system actors, use cases, main flows and alternative flows.
- **Robustness diagrams** - analysis connecting requirements and system responsibilities.
- **Sequence diagrams** - interaction-level design for selected use cases.
- **Domain model** - evolution of the domain classes through the analysis/design phases.
- **Class diagram** - final object-oriented structure aligned with the implementation.
- **Project code documentation** - implementation overview, class responsibilities, installation notes and technology stack.
- **Team plan** - Kanban workflow, milestones, tooling and effort allocation.

This progression was especially useful for keeping the analysis/design artifacts connected to the implementation rather than designing the system in isolation.

## High-Level Design

The final implementation is organized around a JavaFX desktop UI with FXML-based views and Java controllers.

```text
+---------------------------+
|        JavaFX UI          |
|       FXML + Views        |
+-------------+-------------+
              |
              v
+---------------------------+
|     Java Controllers      |
| Admin / Employee /        |
| Customer / Messaging /    |
| Reservation / Orders      |
+-------------+-------------+
              |
              | JDBC
              v
+---------------------------+
|       MySQL Database      |
| Customers / Employees /   |
| Rooms / Reservations /    |
| Payments / Messages /     |
| Announcements / Finance   |
+---------------------------+
```

The database schema includes entities for customers, administrators, employees, rooms, reservations, payments, messages, announcements, salaries, operating costs, feedback and orders.

## Technology Stack

- **Java 20** - application implementation
- **JavaFX 20** - desktop graphical interface
- **FXML** - UI/view definitions
- **JDBC** - application-to-database connectivity
- **MySQL** - relational data persistence
- **MySQL Workbench** - database development
- **Maven** - project build/dependency management
- **Visual Paradigm** - domain/class modeling and project diagrams
- **Lucid** - use-case / analysis diagrams
- **draw.io** - supporting project diagrams

## Repository Structure

```text
.
├── Final Code/
│   └── SQL/
│       ├── UPDATED CREATE TABLES.sql
│       ├── UPDATED INSERTS.sql
│       ├── Message_Stored_Procedures.sql
│       └── Software_Technology/
│           ├── pom.xml
│           ├── lib/
│           └── src/
│
├── Final Version Documentation/
│   ├── Project-description-v1.0.pdf
│   ├── Project-Plan-v1.0.pdf
│   ├── Risk-assessment-v1.0.pdf
│   ├── Team-plan-v1.0.pdf
│   ├── Use Cases-v1.0.pdf
│   ├── Robustness-Diagrams-v1.0.pdf
│   ├── Sequence-diagrams-v1.0.pdf
│   ├── Domain-model-v1.0.pdf
│   ├── Class-diagram-v1.0.pdf
│   └── Project-code-v1.0.pdf
│
├── Software_Technology/        # Additional project working copy
├── garbage/                    # Intermediate / collaboration material
├── Official Company Logo.png
└── README.md
```

For a clean review of the final implementation, start with:

**`Final Code/SQL/Software_Technology`**

## Getting Started

### 1. Prerequisites

Install:

- **JDK 20**
- **IntelliJ IDEA** (or another Java IDE)
- **MySQL Server**
- **MySQL Workbench** (recommended)
- **JavaFX 20**

The repository also contains the MySQL Connector/J library under:

```text
Final Code/SQL/Software_Technology/lib/
```

### 2. Clone the repository

```bash
git clone https://github.com/vpanagiotou531/Software-Technology-2022-23.git
cd Software-Technology-2022-23
```

### 3. Initialize the database

Open the SQL scripts in MySQL Workbench and run them in this order:

```text
Final Code/SQL/UPDATED CREATE TABLES.sql
Final Code/SQL/UPDATED INSERTS.sql
```

The scripts create the `HOTELIDAY_DB` schema and populate it with sample customers, administrators, employees, rooms, products and reservations.

### 4. Configure the database connection

The supplied academic version contains database connection settings directly in the Java source code.

Before running the application, update the connection settings to match your local MySQL environment, especially:

- database host / port
- database name
- username
- password

For a production-quality version, these values should be moved to environment variables or an external configuration file rather than stored in source code.

### 5. Open and run the project

Open:

```text
Final Code/SQL/Software_Technology/pom.xml
```

Import the project as a Maven project and run the JavaFX application through the configured main class:

```text
com.example.software_technology.HotelMain
```

## Documentation

The final technical documentation is available in:

**[`Final Version Documentation`](./Final%20Version%20Documentation/)**

Useful starting points:

- [Project Description](./Final%20Version%20Documentation/Project-description-v1.0.pdf)
- [Project Plan](./Final%20Version%20Documentation/Project-Plan-v1.0.pdf)
- [Risk Assessment](./Final%20Version%20Documentation/Risk-assessment-v1.0.pdf)
- [Use Cases](./Final%20Version%20Documentation/Use%20Cases-v1.0.pdf)
- [Domain Model](./Final%20Version%20Documentation/Domain-model-v1.0.pdf)
- [Class Diagram](./Final%20Version%20Documentation/Class-diagram-v1.0.pdf)
- [Project Code](./Final%20Version%20Documentation/Project-code-v1.0.pdf)

## Engineering Highlights

From a software engineering perspective, this project demonstrates experience with:

- Translating a real-world business scenario into functional requirements.
- Designing role-based workflows for different types of users.
- Modeling a non-trivial relational domain with interconnected entities.
- Moving from use cases to robustness and sequence diagrams and finally to code.
- Building a Java desktop application with a persistent MySQL backend.
- Using JDBC `PreparedStatement`-based database access.
- Managing navigation between multiple JavaFX scenes.
- Planning work through milestones, dependencies and a Kanban process.
- Identifying project risks and defining mitigation strategies.
- Maintaining a final documentation set alongside the implementation.

## Current Scope & Possible Next Steps

The project was developed as an academic system and intentionally focuses on a subset of the broader HOTELIDAY concept.

Natural next steps for a production-oriented version would be:

- Add automated unit and integration testing.
- Add CI/CD and code-quality checks.
- Move secrets and database configuration outside the source code.
- Improve validation and error handling around external/database failures.
- Introduce a clearer service/repository separation between UI controllers and persistence logic.
- Add stronger authentication and password hashing.
- Expand reporting, analytics and multilingual support.

## Team

Developed by a **4-member team** as part of the Software Technology course at the University of Patras.

Team organization, workload allocation and process are documented in the [Team Plan](./Final%20Version%20Documentation/Team-plan-v1.0.pdf).

## License

See [`LICENSE`](./LICENSE).

---
