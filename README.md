# Library Management System

## Overview

A console-based Library Management System built in Java that demonstrates Object-Oriented Programming principles, exception handling, collections, and clean software design.

The application manages books, magazines, members, borrowing requests, borrowing history, and catalog searches through a modular architecture.

---

## Features

### Catalog Management

* Add books and magazines
* Store library items in a centralized catalog
* Search items by title

### Member Management

* Register members
* View member information

### Borrowing System

* Submit borrow requests
* Borrow available books
* Return borrowed books
* Maintain borrowing history

### Search Functionality

* Search library items
* Return structured search results

### Exception Handling

* BookNotFoundException
* BookNotAvailableException
* MemberNotFoundException
* LibraryException

---

## Project Structure

```text
src
├── catalog
│   ├── LibraryCatalog.java
│   └── SearchResult.java
│
├── exception
│   ├── LibraryException.java
│   ├── BookNotFoundException.java
│   ├── BookNotAvailableException.java
│   └── MemberNotFoundException.java
│
├── interfaces
│   └── Borrowable.java
│
├── model
│   ├── LibraryItem.java
│   ├── Book.java
│   ├── Magazine.java
│   ├── Member.java
│   ├── BorrowRequest.java
│   └── BorrowRecord.java
│
├── service
│   └── LibraryService.java
│
└── Main.java
```

---

## OOP Concepts Demonstrated

### Abstraction

`LibraryItem` acts as an abstract base class for all library resources.

### Inheritance

* Book extends LibraryItem
* Magazine extends LibraryItem

### Encapsulation

Private fields with controlled access through getters and setters.

### Polymorphism

Library items can be handled through common parent references.

### Interfaces

Borrowable defines borrowing behavior that can be implemented by library resources.

---

## Collections Used

* ArrayList
* HashMap
* List
* Map

Used for:

* Catalog management
* Member storage
* Borrow history
* Search results

---

## Custom Exceptions

The system uses custom exceptions for robust error handling:

* BookNotFoundException
* BookNotAvailableException
* MemberNotFoundException
* LibraryException

---

## Sample Output

```text
===== LIBRARY MANAGEMENT SYSTEM =====

Book Added:
ID: B101
Title: Clean Code

Magazine Added:
ID: M201
Title: Java Monthly

Member Registered:
ID: U101
Name: Arpit Kumar

Borrow Request Created:
Book: Clean Code
Member: Arpit Kumar

Book Borrowed Successfully

Borrow Record:
Book: Clean Code
Member: Arpit Kumar
Borrowed At: 2025-06-01T10:00

Book Returned Successfully

Search Results:
1. Clean Code
2. Effective Java
```

---

## How to Run

Compile the project:

```bash
javac Main.java
```

Run the application:

```bash
java Main
```

---


