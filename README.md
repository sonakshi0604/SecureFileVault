\# Secure File Vault



\## Overview



Secure File Vault is a Java-based command-line application designed to provide secure file management through user authentication, file encryption/decryption, file operations, and activity logging.



The project demonstrates practical concepts of Java programming, file handling, authentication, cryptography, object-oriented programming, and basic security principles.



\## Features



\* User registration and login

\* Password hashing using SHA-256

\* Secure file creation and deletion

\* File listing and vault status monitoring

\* AES-GCM file encryption

\* AES-GCM file decryption

\* Random initialization vector (IV) generation for encryption

\* Activity logging with timestamps

\* Persistent user and activity data

\* Input validation and error handling

\* Modular package-based architecture



\## Technologies Used



\* \*\*Programming Language:\*\* Java

\* \*\*Java Version:\*\* Java 26

\* \*\*Cryptography:\*\* AES-GCM, SHA-256

\* \*\*File Handling:\*\* Java I/O and NIO

\* \*\*Data Storage:\*\* Local text files

\* \*\*Version Control:\*\* Git and GitHub

\* \*\*Interface:\*\* Command Line Interface (CLI)



\## Project Structure



```text

SecureFileVault/

│

├── src/

│   └── securevault/

│       ├── model/

│       │   ├── ActivityLog.java

│       │   ├── User.java

│       │   └── VaultFile.java

│       │

│       ├── security/

│       │   └── PasswordSecurity.java

│       │

│       ├── service/

│       │   ├── AuthenticationService.java

│       │   ├── EncryptionService.java

│       │   ├── FileService.java

│       │   ├── FileVaultService.java

│       │   ├── LoggingService.java

│       │   └── VaultManager.java

│       │

│       └── Main.java

│

├── data/

├── vault/

├── .gitignore

└── README.md

```



\## Major Functional Modules



\### 1. User Authentication



Users can register and log in using a username and password.



Passwords are stored as SHA-256 hashes rather than plain text.



\### 2. File Management



The system allows authenticated users to:



\* Create files

\* List vault files

\* Delete files

\* Check vault status



\### 3. File Encryption and Decryption



Files can be encrypted using AES-GCM.



A randomly generated 12-byte IV is used for every encryption operation.



Encrypted files are stored with the `.enc` extension.



\### 4. Activity Logging



Important vault activities are recorded with:



\* Username

\* Action performed

\* Timestamp



\### 5. Input Validation and Error Handling



The application validates user input and handles common errors such as:



\* Empty usernames

\* Short passwords

\* Duplicate usernames

\* Missing files

\* Invalid encrypted files

\* Failed encryption/decryption operations



\## Non-Functional Requirements



\* \*\*Security:\*\* Password hashing and AES-GCM encryption are used to protect sensitive information.

\* \*\*Usability:\*\* A simple menu-driven CLI makes the application easy to operate.

\* \*\*Reliability:\*\* File existence checks and exception handling prevent common failures.

\* \*\*Maintainability:\*\* The application is divided into models, security components, and service classes.

\* \*\*Performance:\*\* Local file operations are used for efficient processing of small and medium-sized files.

\* \*\*Error Handling:\*\* Invalid inputs and failed operations are handled without terminating the application unexpectedly.



\## How to Run



\### 1. Clone the repository



```bash

git clone https://github.com/sonakshi0604/SecureFileVault.git

cd SecureFileVault

```



\### 2. Compile the Java source files



For PowerShell:



```powershell

javac -d . (Get-ChildItem -Recurse -Filter \*.java src | ForEach-Object { $\_.FullName })

```



\### 3. Run the application



```powershell

java securevault.Main

```



\## Application Workflow



```text

Start

&#x20; |

&#x20; v

Register / Login

&#x20; |

&#x20; v

Authentication

&#x20; |

&#x20; v

Vault Menu

&#x20; |

&#x20; +--> Show Vault Status

&#x20; |

&#x20; +--> List Files

&#x20; |

&#x20; +--> Create File

&#x20; |

&#x20; +--> Encrypt File

&#x20; |

&#x20; +--> Decrypt File

&#x20; |

&#x20; +--> Delete File

&#x20; |

&#x20; +--> View Activity Logs

&#x20; |

&#x20; v

Exit

```



\## Testing



The application has been tested for the following operations:



\* Successful user registration

\* Successful login

\* File creation

\* File listing

\* AES-GCM encryption

\* AES-GCM decryption

\* Invalid file decryption

\* Activity log generation

\* Application exit

\* Java source compilation



\## Security Implementation



The project uses AES-GCM for authenticated encryption. Each encryption operation generates a new random initialization vector (IV), which is stored together with the encrypted data.



User passwords are converted into SHA-256 hashes before being stored.



> Note: This project is an academic implementation. Production systems should use stronger password-key derivation methods such as PBKDF2, Argon2, or bcrypt and should manage encryption keys using a secure key-management mechanism.



\## Learning Outcomes



This project helped demonstrate practical implementation of:



\* Java Object-Oriented Programming

\* Java packages and modular design

\* File handling

\* Exception handling

\* Authentication

\* Password hashing

\* Symmetric cryptography

\* AES-GCM encryption

\* Logging

\* Git version control

\* Software architecture and project documentation



\## Future Enhancements



\* Implement PBKDF2/Argon2 password hashing with salt

\* Secure external key management

\* Add file path validation

\* Add role-based access control

\* Add automated unit testing

\* Add graphical user interface

\* Add stronger file metadata management

\* Add secure cloud storage integration



\## Author



\*\*Sonakshi Dashore\*\*



B.Tech CSE – Cyber Security and Digital Forensics

VIT Bhopal University



