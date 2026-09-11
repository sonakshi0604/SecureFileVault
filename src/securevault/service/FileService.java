package securevault.service;

import java.io.File;
import java.io.IOException;

public class FileService {

    private String vaultPath;

    public FileService() {

        vaultPath = "vault";

        File vault = new File(vaultPath);

        if (!vault.exists()) {
            vault.mkdir();
        }
    }

    public void listFiles() {

        File vault = new File(vaultPath);
        File[] files = vault.listFiles();

        System.out.println("\n===== VAULT FILES =====");

        if (files == null || files.length == 0) {
            System.out.println("No files available in the vault.");
            return;
        }

        for (File file : files) {

            if (file.isFile()) {
                System.out.println("- " + file.getName());
            }
        }
    }

    public boolean createFile(String fileName) {

        File file = new File(vaultPath, fileName);

        try {

            if (file.createNewFile()) {

                System.out.println(
                        "File created successfully: " + fileName
                );

                return true;

            } else {

                System.out.println("File already exists.");

                return false;
            }

        } catch (IOException e) {

            System.out.println("Error creating file.");

            return false;
        }
    }

    public boolean deleteFile(String fileName) {

        File file = new File(vaultPath, fileName);

        if (file.exists() && file.delete()) {

            System.out.println(
                    "File deleted successfully."
            );

            return true;

        } else {

            System.out.println(
                    "File not found or could not be deleted."
            );

            return false;
        }
    }
}