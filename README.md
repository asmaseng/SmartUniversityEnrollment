# Smart University Enrollment System

## Assignment #4 — Facade Design Pattern

## Project Description

Smart University Enrollment System is a Java application that simplifies the process of enrolling students in university courses.

The project demonstrates the Facade Design Pattern by providing a single interface to coordinate multiple subsystem classes.

## Project Structure

- `Main.java` — Client that interacts only with the Facade.
- `EnrollmentFacade.java` — Coordinates the enrollment process.
- `StudentService.java` — Validates student information.
- `CourseService.java` — Manages courses and available seats.
- `PrerequisiteChecker.java` — Checks course prerequisites.
- `ScheduleChecker.java` — Detects schedule conflicts.
- `EnrollmentService.java` — Manages enrollment records.

## How It Works

The client uses a simple method:

`enrollmentFacade.enrollStudent("S001", "CS201");`

The Facade coordinates the following operations:

1. Validate the student.
2. Validate the course.
3. Check duplicate enrollment.
4. Verify prerequisites.
5. Check schedule conflicts.
6. Reserve an available seat.
7. Save the enrollment.
8. Update the student's schedule.

## Clean Code Principles

1. **Single Responsibility Principle:** Each subsystem has a specific responsibility.
2. **Meaningful Names:** Classes and methods use clear, descriptive names.
3. **Encapsulation:** Internal data is protected using private fields.
4. **Simplified Interface:** The Facade hides subsystem complexity from the client.
5. **Error Handling:** The application validates enrollment conditions and handles failures.


## Design Pattern Benefits

The Facade Pattern reduces coupling between the client and subsystem classes, simplifies complex operations, and improves code maintainability.