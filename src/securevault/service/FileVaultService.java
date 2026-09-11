package securevault.service;

import securevault.model.VaultFile;
import java.io.File;
import java.util.ArrayList;

public class FileVaultService {

    private ArrayList<VaultFile> vaultFiles;

    public FileVaultService() {
        vaultFiles = new ArrayList<>();
    }

    public boolean addFile(String filePath) {

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist.");
            return false;
        }

        if (!file.isFile()) {
            System.out.println("The given path is not a file.");
            return false;
        }

        VaultFile vaultFile = new VaultFile(
                file.getName(),
                file.getAbsolutePath(),
                file.length()
        );

        vaultFiles.add(vaultFile);

        System.out.println("File added to vault successfully!");
        return true;
    }

    public void viewFiles() {

        if (vaultFiles.isEmpty()) {
            System.out.println("Vault is empty.");
            return;
        }

        System.out.println("\n===== VAULT FILES =====");

        for (VaultFile file : vaultFiles) {
            file.displayFileInfo();
            System.out.println("----------------------");
        }
    }

    public void searchFile(String fileName) {

        boolean found = false;

        for (VaultFile file : vaultFiles) {

            if (file.getFileName().equalsIgnoreCase(fileName)) {
                file.displayFileInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("File not found in vault.");
        }
    }

    public boolean removeFile(String fileName) {

        for (VaultFile file : vaultFiles) {

            if (file.getFileName().equalsIgnoreCase(fileName)) {
                vaultFiles.remove(file);
                System.out.println("File removed from vault.");
                return true;
            }
        }

        System.out.println("File not found in vault.");
        return false;
    }
}