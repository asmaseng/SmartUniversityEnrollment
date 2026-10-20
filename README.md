# Smart University Enrollment System

## Project Description

This project is a simple university course enrollment system developed in Java using the **Facade Design Pattern**.

The system allows students to enroll in courses and cancel their enrollment.

## Design Pattern

**Facade Pattern (Structural Design Pattern)**

The `EnrollmentFacade` class provides a simple interface to multiple subsystems.

The `Main` class communicates only with `EnrollmentFacade`.

## Project Structure

```text
src/
├── Main.java
├── EnrollmentFacade.java
├── StudentService.java
├── CourseService.java
├── PrerequisiteChecker.java
├── ScheduleChecker.java
└── EnrollmentService.java
```

## Classes

- **StudentService** — checks if a student exists.
- **CourseService** — checks courses and manages available seats.
- **PrerequisiteChecker** — checks course prerequisites.
- **ScheduleChecker** — checks schedule restrictions.
- **EnrollmentService** — manages enrollment status.
- **EnrollmentFacade** — coordinates all subsystems.
- **Main** — runs the application through the Facade.

## Features

- Student validation
- Course validation
- Prerequisite checking
- Schedule checking
- Seat availability checking
- Course enrollment
- Enrollment cancellation

## Clean Code Principles

1. **Single Responsibility Principle** — each class has one main responsibility.
2. **Meaningful Names** — classes and methods have descriptive names.
3. **Encapsulation** — internal fields are private.
4. **Small Methods** — methods perform simple tasks.
5. **DRY (Don't Repeat Yourself)** — common enrollment steps are coordinated by the Facade.

