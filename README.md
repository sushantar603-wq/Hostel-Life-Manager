# Hostel Life Manager

A Java-based command-line application designed to help hostel students manage common aspects of their daily hostel life, including expenses, meals, assignments, daily tasks, and laundry reminders.

## 1. Project Overview

Hostel students often have to manage multiple daily responsibilities such as tracking expenses, remembering assignments, monitoring meals, completing personal tasks, and managing laundry schedules.

**Hostel Life Manager** provides a single command-line application that combines these activities into one simple system.

The application uses Java's core programming concepts such as classes and objects, ArrayList, methods, loops, conditional statements, switch-case, file handling, exception handling, and date/time operations.

The project uses local text files for data persistence, so no database or external software is required.

---

## 2. Problem Statement

Hostel students frequently manage their expenses, academic deadlines, meals, personal tasks, and laundry separately. This can make it difficult to keep track of daily activities and important deadlines.

The objective of this project is to develop a lightweight Java-based system that provides multiple hostel-life management functions through a single command-line interface.

---

## 3. Objectives

* Track daily hostel-related expenses.
* Record and monitor mess/meal consumption.
* Manage assignments and academic deadlines.
* Maintain a list of daily tasks.
* Provide a laundry reminder based on the last laundry date.
* Generate a combined weekly summary.
* Store data locally so that information remains available after restarting the application.
* Provide input validation and basic error handling.

---

## 4. Major Features

### 4.1 Expense Tracker

The Expense Tracker allows users to:

* Add expenses.
* View all expenses.
* Update existing expenses.
* Delete expenses.
* Calculate total spending.
* Identify the highest spending category.
* Calculate the total amount spent on small expenses below ₹100.

### 4.2 Mess Tracker

The Mess Tracker allows users to:

* Record whether breakfast, lunch, and dinner were eaten or skipped.
* View today's meal record.
* Calculate total meals eaten.
* Calculate total meals skipped.

### 4.3 Assignment Tracker

The Assignment Tracker allows users to:

* Add assignments.
* Store subject, title, and deadline.
* View assignments.
* Identify overdue assignments.
* Identify assignments due today.
* Show remaining days for upcoming deadlines.
* Mark assignments as completed.
* Delete assignments.

### 4.4 Daily Task Manager

The Daily Task Manager allows users to:

* Add personal tasks.
* View tasks.
* Mark tasks as completed.
* Delete tasks.
* Track the number of pending tasks.

### 4.5 Laundry Reminder

The Laundry Reminder allows users to:

* Record the date of the latest laundry.
* Calculate the number of days since the previous laundry.
* Display the next laundry reminder.
* Identify whether laundry is due or overdue.

### 4.6 Weekly Summary

The Weekly Summary combines information from different modules and displays:

* Total meals eaten.
* Total meals skipped.
* Total money spent.
* Highest spending category.
* Number of pending assignments.
* Next assignment deadline.
* Number of pending tasks.
* Laundry status.

---

## 5. Technologies and Tools

* **Programming Language:** Java
* **Interface:** Command Line Interface (CLI)
* **Data Storage:** Local `.txt` files
* **IDE/Editor:** Visual Studio Code
* **Version Control:** Git/GitHub
* **Java Concepts:** OOP, classes, objects, ArrayList, methods, loops, conditions, switch-case, file handling, exception handling, and LocalDate.

No external Java libraries or frameworks are required.

---

## 6. System Architecture

The application follows a simple layered structure:

```text
                 ┌─────────────────────┐
                 │       Main.java     │
                 │   User Interface    │
                 └──────────┬──────────┘
                            │
          ┌─────────────────┼─────────────────┐
          │                 │                 │
          ▼                 ▼                 ▼
 ┌────────────────┐ ┌────────────────┐ ┌────────────────┐
 │ ExpenseManager │ │  MealTracker   │ │ AssignmentMgr  │
 └────────────────┘ └────────────────┘ └────────────────┘
          │                 │                 │
          └─────────────────┼─────────────────┘
                            │
          ┌─────────────────┴─────────────────┐
          │                                   │
          ▼                                   ▼
 ┌────────────────┐                 ┌────────────────────┐
 │  TaskManager   │                 │  LaundryManager    │
 └────────────────┘                 └────────────────────┘
          │                                   │
          └─────────────────┬─────────────────┘
                            ▼
                   ┌────────────────┐
                   │  FileManager   │
                   └───────┬────────┘
                           │
                           ▼
                    Local Text Files
```

---

## 7. Project Structure

```text
Hostel-Life-Manager/
│
├── src/
│   ├── Main.java
│   ├── Expense.java
│   ├── ExpenseManager.java
│   ├── Meal.java
│   ├── MealTracker.java
│   ├── Assignment.java
│   ├── AssignmentManager.java
│   ├── Task.java
│   ├── TaskManager.java
│   ├── LaundryManager.java
│   ├── FileManager.java
│   └── ValidationUtils.java
│
├── data/
│   ├── expenses.txt
│   ├── meals.txt
│   ├── assignments.txt
│   ├── tasks.txt
│   └── laundry.txt
│
├── tests/
│
├── diagrams/
│
├── screenshots/
│
├── README.md
│
└── statement.md
```

---

# 8. Requirements

Before running the project, install:

### Java

Java JDK 8 or later is required.

Check the installed Java version:

```powershell
java -version
```

Check the Java compiler:

```powershell
javac -version
```

The project was developed and tested using Java on Windows.

---

# 9. Installation and Setup

## Step 1: Download the Project

Download or clone this repository from GitHub.

If using Git:

```powershell
git clone <repository-url>
```

Then enter the project directory:

```powershell
cd Hostel-Life-Manager
```

Alternatively, download the repository as a ZIP file and extract it.

---

## Step 2: Open the Project Folder

Open the extracted `Hostel-Life-Manager` folder in Visual Studio Code or another Java-compatible editor.

The terminal should be opened at the project root:

```text
Hostel-Life-Manager
```

---

# 10. Compile the Project

From the project root directory, run:

```powershell
javac src\*.java
```

If compilation is successful, no error message will be displayed.

---

# 11. Run the Application

After successful compilation, run:

```powershell
java -cp src Main
```

The main menu will appear:

```text
╔══════════════════════════════════════╗
║          HOSTEL LIFE MANAGER         ║
╠══════════════════════════════════════╣
║ 1. Expense Tracker                   ║
║ 2. Mess Tracker                      ║
║ 3. Assignment Tracker                ║
║ 4. Daily Task Manager                ║
║ 5. Laundry Reminder                  ║
║ 6. Weekly Summary                    ║
║ 7. Exit                              ║
╚══════════════════════════════════════╝
```

Enter the number corresponding to the required module.

---

# 12. Data Storage

The application uses local text files for persistent storage.

| File              | Purpose                        |
| ----------------- | ------------------------------ |
| `expenses.txt`    | Stores expense records         |
| `meals.txt`       | Stores meal records            |
| `assignments.txt` | Stores assignment records      |
| `tasks.txt`       | Stores daily tasks             |
| `laundry.txt`     | Stores the latest laundry date |

The application automatically reads existing records when it starts and saves changes to the corresponding files.

No external database is required.

---

# 13. Input Validation and Error Handling

The project includes a `ValidationUtils` class for handling user input.

The application validates:

* Positive expense amounts.
* Integer inputs.
* Empty input fields.
* Date format.
* Meal status values.
* Invalid menu selections.

The program also handles invalid or corrupted records while loading data from files.

Example:

```text
Enter amount (₹): abc
Please enter a valid number.
```

The user is then allowed to enter the value again instead of terminating the application.

---

# 14. Non-Functional Requirements

### Usability

The application provides a simple menu-driven command-line interface that allows users to navigate between modules.

### Reliability

Data is stored in local files so that records remain available after the application is closed and restarted.

### Maintainability

Different responsibilities are divided into separate classes such as `ExpenseManager`, `MealTracker`, `AssignmentManager`, and `TaskManager`.

### Performance

The application uses lightweight local text files and Java collections, making it suitable for small-scale hostel management without requiring a database server.

### Error Handling

Invalid user input and file-reading problems are handled using validation and exception handling.

---

# 15. Testing

The application can be tested using the following scenarios:

| Test Case                    | Expected Result                        |
| ---------------------------- | -------------------------------------- |
| Add valid expense            | Expense is saved successfully          |
| Enter invalid expense amount | Validation message is displayed        |
| View expenses                | All stored expenses are displayed      |
| Update expense               | Selected expense is modified           |
| Delete expense               | Selected expense is removed            |
| Record meals                 | Today's meal record is saved           |
| Add assignment               | Assignment is added with deadline      |
| Enter invalid date           | Date validation message is displayed   |
| Mark assignment complete     | Assignment status changes to Completed |
| Add task                     | Task is added successfully             |
| Complete task                | Task status changes to Completed       |
| Record laundry               | Current laundry date is saved          |
| Check laundry status         | Remaining/overdue days are displayed   |
| Restart application          | Previously saved data is loaded        |
| Select invalid menu option   | Error message is displayed             |

---

# 16. Design Decisions

### Why Java?

Java was selected because the project is intended to demonstrate core Java programming and Object-Oriented Programming concepts.

### Why Command Line Interface?

A CLI keeps the project lightweight and focuses on the implementation of programming concepts without requiring GUI frameworks.

### Why Text Files Instead of a Database?

The project is designed as a small-scale academic application. Text files provide simple persistent storage without requiring database installation or external dependencies.

### Why Separate Classes?

Each major module has its own class or manager class. This improves organization, maintainability, and readability.

---

# 17. Limitations

* The application currently supports a single local user.
* Data is stored in local text files.
* The application does not provide a graphical interface.
* It does not synchronize data between multiple devices.
* Laundry reminders are based on a fixed seven-day interval.
* The system does not use an online database.

---

# 18. Future Enhancements

Possible future improvements include:

* Graphical User Interface.
* Login and user authentication.
* Database integration.
* Monthly expense reports.
* Expense charts and visual analytics.
* Automatic assignment reminders.
* Hostel mess menu integration.
* Multiple user profiles.
* Cloud data synchronization.
* Mobile application version.

---

# 19. Learning Outcomes

Through this project, the following concepts were practiced:

* Object-Oriented Programming.
* Classes and objects.
* Encapsulation.
* ArrayList and collections.
* Methods and modular programming.
* Conditional statements.
* Loops.
* Switch-case.
* File handling.
* Exception handling.
* Input validation.
* Date and time operations.
* Modular software design.
* Git and GitHub project management.

---

# 20. Author

**Project:** Hostel Life Manager
**Type:** Java Command-Line Application
**Purpose:** Academic Mini Project
**Technology:** Java

---

## 21. License

This project is developed for academic and educational purposes.
