# Library Management System



## Problem Statement
To develop a menu-driven Library Management System using Java and Object-Oriented Programming concepts. The system manages books and members and supports borrowing and returning books.

## Features
- Add books with author details and stock quantity
- Register regular and premium members
- Display available books
- Borrow books and generate a borrowing receipt
- Return borrowed books and calculate late fines
- Validate user input and handle invalid entries
- Prevent duplicate book and member IDs
- Enforce member borrowing limits

## Object-Oriented Programming Concepts
- Encapsulation: Private fields and public getter methods
- Inheritance: `PremiumMember` extends `Member`
- Polymorphism: Overridden methods provide premium-member borrowing limits
- Object relationships: Books reference authors, and transactions reference books and members
- Packages: Code is organized into `model`, `service`, `exception`, and `main`

## Project Structure

```text
LibraryManagementSystem/
├── model/
│   ├── Author.java
│   ├── Book.java
│   ├── Member.java
│   ├── PremiumMember.java
│   ├── BorrowTransaction.java
│   └── ReturnTransaction.java
├── service/
│   └── Library.java
├── exception/
│   └── LibraryException.java
├── main/
│   └── Main.java
└── README.md
```

## Requirements
- Java JDK
- Eclipse IDE or another Java IDE

## How to Run
1. Download or clone this repository.
2. Open Eclipse.
3. Import the project using **File → Import → Existing Projects into Workspace** if it is an Eclipse project.
4. Ensure the Java files are inside the corresponding source packages: `model`, `service`, `exception`, and `main`.
5. Open `Main.java`.
6. Run the program and follow the menu displayed in the console.

## Input Validation
The program checks for invalid menu input, empty text fields, non-positive IDs and stock quantities, invalid member types, duplicate IDs, unavailable books, and invalid borrowing transactions.

## Author
Bhumika M

Register Number: 717825E207

