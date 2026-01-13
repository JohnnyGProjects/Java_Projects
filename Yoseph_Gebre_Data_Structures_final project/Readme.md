Course Contents Manager (JavaFX)
Overview

This project is a JavaFX desktop application that organizes and displays university course information, including assignments, midterms, and final exams, using custom-built data structures.

The application loads course data from a file, stores it using linked lists, dictionaries, and priority queues, and allows users to:

View structured course contents

View assignments ordered by due date and priority

This project demonstrates practical usage of data structures, file processing, and GUI development in Java.

📚 Courses Included

The data file contains structured information for the following courses:

Data Structures

Assignments: 4

Complexity Analysis & Arrays

Linked Lists

Dictionary

Binary Tree

Midterm Exam

Final Exam

Cryptography

Assignments: 3

Theoretical Foundations

Cryptographic Protocols

Cryptographic Applications

Midterm Exam

Final Exam

Numerical Analysis

Assignments: 2

Newton’s Method

Numerical Integration

Midterm Exam

Final Exam

Advanced Networking

Assignments: 2

EIGRP

OSPF

Midterm Exam

Final Exam

Network Security

Assignments: 3

NTP

VPN

SSH

Midterm Exam

Final Exam

Each assignment includes:

Name

Submission date

Weight (%)

🖥 Application Features
View Course Contents

Displays all courses

Shows assignments, midterms, and finals per course

Uses a custom Dictionary to store course data

View Assignments

Displays assignments across all courses

Sorted by:

Submission date (earliest first)

Weight (higher weight first if dates match)

Implemented using a custom Priority Queue

🧱 Data Structures Implemented

This project avoids Java’s built-in collections and instead implements core structures manually:

Custom Implementations

LinkedList

Used for assignment storage

Dictionary

Implemented using a singly linked list of key–value pairs

PriorityQueue

Orders assignments using Comparable

Binary Node Utilities

Supporting classes for list and queue operations

📂 Project Structure
Core Application

Main.java
JavaFX entry point, UI logic, file loading, and event handling

Models

Assignment
Represents assignments and exams, includes comparison logic

CourseContent
Stores course name, assignments, midterm, and final

AssignmentType
Enum for Homework vs Exam

Data Structures

LinkedList<T>

Dictionary<Key, Value>

PriorityQueue<T>

Utilities

Node<T>

QueueNode<T>

Pair<Key, Value>

📄 Data File

The application reads course data from:

data/contents.txt


Data is parsed and converted into structured objects at runtime.

▶️ How to Run
Requirements

Java 11+

JavaFX configured in your environment

Steps

Compile the project

Ensure contents.txt exists in the data/ directory

Run the Main class

🎯 Learning Outcomes

This project demonstrates:

Custom implementation of core data structures

File parsing and data modeling

Priority-based sorting using Comparable

JavaFX GUI development

Separation of concerns (models, structures, UI)

👨‍💻 Author

Johnny (Yoseph Gebre)

📌 Notes

No Java built-in collections are used for storage

Assignment ordering is deterministic and reproducible
