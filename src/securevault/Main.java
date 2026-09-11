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

        boolean loggedIn = false;
        String currentUser = "";

        // ==============================
        // LOGIN / REGISTRATION
        // ==============================

        while (!loggedIn) {

            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

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
                    username = scanner.nextLine();

                    System.out.print("Enter password: ");
                    password = scanner.nextLine();

                    User user = vaultManager
                            .getAuthenticationService()
                            .login(username, password);

                    if (user != null) {

                        loggedIn = true;
                        currentUser = user.getUsername();

                    }

                    break;

                case "3":

                    System.out.println(
                            "Exiting Secure File Vault."
                    );

                    scanner.close();
                    return;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }

        // ==============================
        // MAIN VAULT MENU
        // ==============================

        while (loggedIn) {

            System.out.println("\n=================================");
            System.out.println("          VAULT MENU");
            System.out.println("=================================");

            System.out.println("1. Show Vault Status");
            System.out.println("2. List Files");
            System.out.println("3. Create File");
            System.out.println("4. Encrypt File");
            System.out.println("5. Decrypt File");
            System.out.println("6. Delete File");
            System.out.println("7. View Activity Logs");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                // ==============================
                // SHOW VAULT STATUS
                // ==============================

                case "1":

                    vaultManager.showVaultStatus();

                    break;

                // ==============================
                // LIST FILES
                // ==============================

                case "2":

                    vaultManager
                            .getFileService()
                            .listFiles();

                    break;

                // ==============================
                // CREATE FILE
                // ==============================

                case "3":

                    System.out.print(
                            "Enter file name: "
                    );

                    String fileName = scanner.nextLine();

                    vaultManager
                            .getFileService()
                            .createFile(fileName);

                    break;

                // ==============================
                // ENCRYPT FILE
                // ==============================

                case "4":

                    System.out.print(
                            "Enter file name to encrypt: "
                    );

                    fileName = scanner.nextLine();

                    boolean encrypted =
                            vaultManager
                                    .getEncryptionService()
                                    .encryptFile(fileName);

                    if (encrypted) {

                        vaultManager
                                .getLoggingService()
                                .logActivity(
                                        currentUser,
                                        "Encrypted file: "
                                                + fileName
                                );
                    }

                    break;

                // ==============================
                // DECRYPT FILE
                // ==============================

                case "5":

                    System.out.print(
                            "Enter encrypted file name: "
                    );

                    fileName = scanner.nextLine();

                    boolean decrypted =
                            vaultManager
                                    .getEncryptionService()
                                    .decryptFile(fileName);

                    if (decrypted) {

                        vaultManager
                                .getLoggingService()
                                .logActivity(
                                        currentUser,
                                        "Decrypted file: "
                                                + fileName
                                );
                    }

                    break;

                // ==============================
                // DELETE FILE
                // ==============================

                case "6":

                    System.out.print(
                            "Enter file name to delete: "
                    );

                    fileName = scanner.nextLine();

                    vaultManager
                            .getFileService()
                            .deleteFile(fileName);

                    vaultManager
                            .getLoggingService()
                            .logActivity(
                                    currentUser,
                                    "Deleted file: "
                                            + fileName
                            );

                    break;

                // ==============================
                // VIEW ACTIVITY LOGS
                // ==============================

                case "7":

                    vaultManager
                            .getLoggingService()
                            .viewLogs();

                    break;

                // ==============================
                // EXIT
                // ==============================

                case "8":

                    System.out.println(
                            "Thank you for using Secure File Vault."
                    );

                    loggedIn = false;

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }

        scanner.close();
    }
}