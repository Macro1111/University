# 🎓 University Management System

This is a Java console-based application developed as the final project for the Basic Java module. It simulates a university environment where students, teachers, and classes can be managed through an interactive menu.

The system is built with object-oriented programming principles and provides a clean separation of responsibilities across its classes.

---

## 📌 Features

The program includes the following functionality:

### 1. Show all teachers  
Displays all registered teachers, including their type (full-time or part-time) and their calculated salary.

### 2. Show all classes  
Lists available university classes and lets the user view class details, including:
- Course name
- Assigned classroom
- Assigned teacher
- List of enrolled students

### 3. Create a new student and enroll in a class  
- User inputs the student’s name and age  
- Confirms the information  
- Selects a class for enrollment

### 4. Create a new class  
- Input class name and classroom number  
- Assign an existing teacher  
- Select one or more existing students  
- Confirm and create the class

### 5. Search classes by student ID  
- View all students and select one by ID  
- List all classes in which the student is enrolled

### 0. Exit the program

---

## 🧠 Object-Oriented Design

This project demonstrates core OOP concepts:

- **Abstraction** → `Teacher` is an abstract base class
- **Inheritance** → `FullTimeTeacher` and `PartTimeTeacher` extend `Teacher`
- **Encapsulation** → Attributes are protected/private with accessors
- **Polymorphism** → Salary is calculated differently based on teacher type
- **Composition** → `UniversityClass` contains a teacher and a list of students

---

## 📂 Project Structure

```plaintext
Main.java → Contains the main program and console interaction  
Campus.java → Contains the logic to create and manage classes, students, and teachers  
Student.java → Represents a student with name, age, and auto-generated ID  
UniversityClass.java → Represents a course with a classroom, teacher, and students  

teachers/
├── Teacher.java → Abstract base class for all teachers  
├── FullTimeTeacher.java → Full-time teacher with experience-based salary  
└── PartTimeTeacher.java → Part-time teacher with hourly-based salary  

uml/
└── uml-diagram.png → Class diagram of the system  
