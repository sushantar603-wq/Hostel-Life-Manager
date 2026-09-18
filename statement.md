# Project Statement

## Project Title

**Hostel Life Manager**

## 1. Problem Statement

Hostel students have to manage several aspects of their daily life while balancing academic responsibilities. Common activities such as tracking expenses, monitoring mess meals, remembering assignment deadlines, managing personal tasks, and maintaining a laundry schedule are often handled separately.

Managing these activities without a centralized system can lead to forgotten deadlines, poor expense tracking, missed tasks, and difficulty understanding daily habits.

The **Hostel Life Manager** project addresses this problem by providing a single Java-based command-line application that combines multiple daily hostel management activities into one system.

The application allows users to record, update, view, and manage their information while storing the data locally for future use.

---

## 2. Project Objectives

The main objectives of the project are:

1. To develop a simple system for managing common hostel-life activities.
2. To provide an expense tracking facility for monitoring daily spending.
3. To provide a meal tracking facility for recording eaten and skipped meals.
4. To manage academic assignments and their deadlines.
5. To provide a daily task management system.
6. To provide a laundry reminder based on the last recorded laundry date.
7. To generate a combined summary of important hostel activities.
8. To demonstrate Java programming and Object-Oriented Programming concepts in a practical application.
9. To provide persistent local data storage using text files.
10. To implement input validation and basic error handling.

---

## 3. Project Scope

The project focuses on small-scale personal management for hostel students.

### Included in the Scope

* Expense management.
* Meal/mess tracking.
* Assignment management.
* Daily task management.
* Laundry reminder.
* Weekly summary.
* CRUD operations where applicable.
* Local file-based data persistence.
* Input validation.
* Basic exception handling.
* Command-line interaction.

### Outside the Current Scope

The following features are not included in the current version:

* Online database synchronization.
* Multiple-user accounts.
* Cloud storage.
* Mobile application.
* Graphical user interface.
* Automatic notifications through SMS or email.
* Online hostel administration.

These features may be considered as future enhancements.

---

## 4. Target Users

The primary target users are:

### Hostel Students

Students living in hostels who need to manage their personal expenses, meals, assignments, daily tasks, and laundry schedules.

### College Students

The application can also be used by students living away from home who want a simple system for organizing everyday responsibilities.

---

## 5. High-Level Features

### 5.1 Expense Management

Users can:

* Add an expense.
* View expenses.
* Update expenses.
* Delete expenses.
* Calculate total spending.
* Identify the highest spending category.
* Calculate spending on small expenses.

### 5.2 Meal Management

Users can:

* Record breakfast, lunch, and dinner status.
* Mark meals as eaten or skipped.
* View today's meal record.
* View meal statistics.

### 5.3 Assignment Management

Users can:

* Add assignments.
* Store subject and assignment title.
* Set deadlines.
* View pending and completed assignments.
* Identify overdue assignments.
* Identify assignments due today.
* Mark assignments as completed.
* Delete assignments.

### 5.4 Daily Task Management

Users can:

* Add personal tasks.
* View tasks.
* Mark tasks as completed.
* Delete tasks.
* Track pending tasks.

### 5.5 Laundry Reminder

Users can:

* Record the date of laundry.
* View the last laundry date.
* Calculate when laundry is due.
* Identify overdue laundry.

### 5.6 Weekly Summary

The system combines information from different modules and displays:

* Meals eaten.
* Meals skipped.
* Total spending.
* Highest spending category.
* Pending assignments.
* Next assignment deadline.
* Pending tasks.
* Laundry status.

---

## 6. Technical Approach

The application is implemented using core Java programming concepts.

The system uses separate classes for different responsibilities. Manager classes handle the operations of individual modules, while model classes represent stored data.

Local text files are used for persistent storage. The `FileManager` class provides common file-reading and file-writing operations.

Input validation is handled through the `ValidationUtils` class.

The application follows a modular structure:

```text
User
  │
  ▼
Main.java
  │
  ├── ExpenseManager
  ├── MealTracker
  ├── AssignmentManager
  ├── TaskManager
  └── LaundryManager
           │
           ▼
      FileManager
           │
           ▼
      Text Data Files
```

---

## 7. Expected Outcome

The expected outcome is a functional Java command-line application that allows a hostel student to manage multiple daily activities from one system.

The completed application should:

* Accept and validate user input.
* Perform the required management operations.
* Store information persistently.
* Retrieve previously stored information.
* Provide useful summaries.
* Handle common input and file-related errors.
* Demonstrate practical use of Java and Object-Oriented Programming concepts.

---

## 8. Academic Relevance

This project demonstrates the practical application of programming concepts studied in Java, including:

* Classes and objects.
* Encapsulation.
* Constructors.
* Methods.
* ArrayList.
* Loops.
* Conditional statements.
* Switch-case.
* File handling.
* Exception handling.
* Date and time operations.
* Modular programming.
* Input validation.

The project also demonstrates basic software engineering practices such as modular design, documentation, testing, version control, and structured project organization.

---

## 9. Project Deliverables

The project repository contains:

* Java source code.
* Data storage files.
* Project documentation.
* README with setup and execution instructions.
* Project statement.
* Testing resources.
* Design diagrams.
* Screenshots/results.

The project is designed to be executable from the command line without requiring any graphical setup or external database.
