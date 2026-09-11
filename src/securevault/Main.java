package securevault;

import securevault.model.User;
import securevault.service.VaultManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VaultManager vaultManager = new VaultManager();

        System.out.println("=================================");
        System.out.println("       SECURE FILE VAULT");
        System.out.println("=================================");

        boolean authenticated = false;
        User loggedInUser = null;

        while (!authenticated) {

            System.out.println("\n===== START MENU =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    vaultManager.getAuthenticationService()
                            .register(username, password);
                    break;

                case "2":
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();

                    loggedInUser = vaultManager
                            .getAuthenticationService()
                            .login(loginUsername, loginPassword);

                    if (loggedInUser != null) {
                        authenticated = true;
                    }
                    break;

                case "3":
                    System.out.println(
                            "Exiting Secure File Vault..."
                    );
                    scanner.close();
                    return;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }

        System.out.println(
                "\nWelcome, " + loggedInUser.getUsername() + "!"
        );

        boolean running = true;

        while (running) {

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Show Vault Status");
            System.out.println("2. List Files");
            System.out.println("3. Create File");
            System.out.println("4. Encrypt File");
            System.out.println("5. Decrypt File");
            System.out.println("6. Delete File");
            System.out.println("7. View Activity Logs");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    vaultManager.showVaultStatus();
                    break;

                case "2":
                    vaultManager.getFileService()
                            .listFiles();
                    break;

                case "3":
                    System.out.print("Enter file name: ");
                    String createName = scanner.nextLine();

                    boolean fileCreated =
                            vaultManager.getFileService()
                                    .createFile(createName);

                    if (fileCreated) {

                        vaultManager.getLoggingService()
                                .logActivity(
                                        loggedInUser.getUsername(),
                                        "Created file: " + createName
                                );
                    }
                    break;

                case "4":
                    System.out.print(
                            "Enter file name to encrypt: "
                    );

                    String encryptName = scanner.nextLine();

                    vaultManager.getEncryptionService()
                            .encryptFile(encryptName);

                    vaultManager.getLoggingService()
                            .logActivity(
                                    loggedInUser.getUsername(),
                                    "Encrypted file: " + encryptName
                            );
                    break;

                case "5":
                    System.out.print(
                            "Enter encrypted file name: "
                    );

                    String decryptName = scanner.nextLine();

                    vaultManager.getEncryptionService()
                            .decryptFile(decryptName);

                    vaultManager.getLoggingService()
                            .logActivity(
                                    loggedInUser.getUsername(),
                                    "Decrypted file: " + decryptName
                            );
                    break;

                case "6":
                    System.out.print(
                            "Enter file name to delete: "
                    );

                    String deleteName = scanner.nextLine();

                    boolean fileDeleted =
                            vaultManager.getFileService()
                                    .deleteFile(deleteName);

                    if (fileDeleted) {

                        vaultManager.getLoggingService()
                                .logActivity(
                                        loggedInUser.getUsername(),
                                        "Deleted file: " + deleteName
                                );
                    }
                    break;

                case "7":
                    vaultManager.getLoggingService()
                            .viewLogs();
                    break;

                case "8":
                    running = false;

                    System.out.println(
                            "Exiting Secure File Vault..."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }
}