# Secure File Vault

## 1. Project Overview

Secure File Vault is a Java-based command-line application designed to securely manage files using authentication, encryption, decryption, file management, and activity logging.

The project demonstrates important concepts of Java programming, file handling, exception handling, object-oriented programming, and basic cryptographic security.

---

## 2. Problem Statement

Users often store important files without adequate protection. Unauthorized access, accidental exposure, and lack of activity tracking can create security risks.

Secure File Vault provides a simple command-line solution where users can register, log in, create and manage files, encrypt sensitive files, decrypt them when required, and monitor file-related activities through logs.

---

## 3. Objectives

* Provide authenticated access to the file vault.
* Store passwords in hashed form.
* Allow users to create, list, and delete files.
* Provide encryption and decryption of files.
* Maintain activity logs for important operations.
* Demonstrate secure and modular Java programming.
* Provide a simple and user-friendly command-line interface.

---

## 4. Features

### Authentication

* User registration
* User login
* Password validation
* SHA-256 password hashing

### File Management

* Create files
* List vault files
* Delete files
* Display vault status

### File Security

* AES-GCM encryption
* AES-GCM decryption
* Random initialization vector (IV) for encryption
* Validation of encrypted files

### Activity Logging

* Records important file operations
* Stores logs in a file
* Displays previous activity logs

---

## 5. Functional Requirements

1. The system shall allow a new user to register.
2. The system shall validate username and password input.
3. The system shall authenticate registered users.
4. The system shall allow users to create files.
5. The system shall allow users to view files stored in the vault.
6. The system shall encrypt selected files.
7. The system shall decrypt encrypted files.
8. The system shall allow users to delete files.
9. The system shall record important activities.
10. The system shall display activity logs.

---

## 6. Non-Functional Requirements

### Security

Passwords are stored using SHA-256 hashing and files are protected using AES-GCM encryption.

### Usability

The application provides a simple menu-driven command-line interface.

### Reliability

The application validates inputs and handles file and encryption errors.

### Maintainability

The project is divided into separate classes and packages according to their responsibilities.

### Performance

The application performs file operations directly through Java file-handling APIs.

### Error Handling

Invalid inputs, missing files, invalid encrypted files, and authentication failures are handled with appropriate messages.

---

## 7. Technologies Used

* Java
* Java Cryptography Architecture (JCA)
* AES-GCM
* SHA-256
* Java File I/O
* Object-Oriented Programming
* Git and GitHub
* Command Line / PowerShell

---

## 8. Project Structure

```text
SecureFileVault/
│
├── src/
│   └── securevault/
│       ├── Main.java
│       │
│       ├── model/
│       │   ├── User.java
│       │   ├── VaultFile.java
│       │   └── ActivityLog.java
│       │
│       ├── security/
│       │   └── PasswordSecurity.java
│       │
│       └── service/
│           ├── AuthenticationService.java
│           ├── EncryptionService.java
│           ├── FileService.java
│           ├── FileVaultService.java
│           ├── LoggingService.java
│           └── VaultManager.java
│
├── data/
├── vault/
├── .gitignore
└── README.md
```

---

## 9. Major Functional Modules

### 1. Authentication Module

Responsible for user registration, login, password validation, and password hashing.

### 2. File Management Module

Responsible for creating, listing, and deleting files in the vault.

### 3. Encryption Module

Uses AES-GCM to encrypt and decrypt files.

### 4. Logging Module

Records important user activities and stores them in a log file.

### 5. Vault Management Module

Coordinates the different services and manages the overall vault workflow.

---

## 10. Application Workflow

```text
Start
  |
  v
Register / Login
  |
  v
Authentication Successful
  |
  v
Vault Menu
  |
  +--> Show Vault Status
  |
  +--> List Files
  |
  +--> Create File
  |
  +--> Encrypt File
  |
  +--> Decrypt File
  |
  +--> Delete File
  |
  +--> View Activity Logs
  |
  v
Exit
```

---

## 11. How to Run

### Prerequisites

* Java Development Kit (JDK)
* Git

### Clone the Repository

```text
git clone https://github.com/sonakshi0604/SecureFileVault.git
```

### Navigate to the Project

```text
cd SecureFileVault
```

### Compile the Project

PowerShell:

```text
javac -d . (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName })
```

### Run the Application

```text
java securevault.Main
```

---

## 12. Testing

The following functionalities were tested successfully:

* Java source compilation
* User registration
* User login
* Invalid login handling
* File creation
* File listing
* AES-GCM file encryption
* AES-GCM file decryption
* Invalid encrypted-file handling
* Activity logging
* Vault menu operations

The application successfully completed the tested authentication, file management, encryption/decryption, and logging workflows.

---

## 13. Security Implementation

### Password Security

Passwords are not stored directly. The application uses SHA-256 hashing before storing password information.

### File Encryption

Files are encrypted using:

```text
AES/GCM/NoPadding
```

A random 12-byte initialization vector (IV) is generated for each encryption operation.

### Authentication

Only successfully authenticated users can access the main vault menu.

---

## 14. Design Decisions

* Java was selected because the project demonstrates object-oriented programming, file handling, exception handling, and security concepts.
* A modular package structure was used to separate models, security functionality, and services.
* AES-GCM was selected to provide authenticated encryption.
* File-based storage was used to keep the project lightweight and easy to execute from the command line.
* SHA-256 hashing was implemented for password storage in this academic project.

---

## 15. Challenges

* Managing multiple Java classes and packages.
* Handling file input/output operations.
* Implementing encryption and decryption correctly.
* Resolving encryption key length issues.
* Handling invalid files and authentication errors.
* Connecting and pushing the project to GitHub.

---

## 16. Learning Outcomes

Through this project, the following concepts were practiced:

* Java Object-Oriented Programming
* Classes and objects
* Packages
* Java File I/O
* Exception handling
* Authentication
* Password hashing
* Symmetric encryption
* AES-GCM
* Activity logging
* Modular software design
* Git and GitHub

---

## 17. Future Enhancements

* Replace SHA-256 password hashing with a password-specific hashing algorithm such as PBKDF2.
* Store encryption keys securely instead of using a hard-coded key.
* Add role-based access control.
* Add stronger file-name/path validation.
* Add a graphical user interface.
* Add database-based user and activity storage.
* Add automated unit testing.
* Improve key management and recovery mechanisms.

---

## 18. Repository

GitHub Repository:

https://github.com/sonakshi0604/SecureFileVault

---

## 19. Author

**Sonakshi Dashore**
B.Tech CSE – Cyber Security and Digital Forensics
VIT Bhopal University
