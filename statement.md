# Secure File Vault — Project Statement

## 1. Problem Statement

Users often store important files without adequate protection. Unauthorized access, accidental exposure, and lack of activity tracking can create security risks.

The Secure File Vault project provides a simple Java-based command-line application that allows authenticated users to securely manage files. The system provides file creation, file listing, deletion, encryption, decryption, and activity logging.

## 2. Project Scope

The project focuses on developing a lightweight command-line file security system using Java.

The system covers:

* User registration and authentication
* Password hashing
* File management
* File encryption and decryption
* Activity logging
* Input validation and error handling

The project is designed as an academic demonstration of Java programming and basic cybersecurity concepts.

## 3. Target Users

The system is intended for:

* Students learning Java and cybersecurity
* Users who need basic local file protection
* Developers learning file handling and cryptographic concepts
* Academic demonstrations of secure file management

## 4. High-Level Features

### Authentication

* User registration
* User login
* Password validation
* SHA-256 password hashing

### File Management

* Create files
* List files
* Delete files
* Display vault status

### File Security

* AES-GCM file encryption
* AES-GCM file decryption
* Random initialization vector generation
* Encrypted-file validation

### Activity Monitoring

* Record important file operations
* Store activity logs
* Display activity history

## 5. Expected Outcome

The completed system provides a functional command-line Secure File Vault where authenticated users can manage and protect files while maintaining a record of important activities.
