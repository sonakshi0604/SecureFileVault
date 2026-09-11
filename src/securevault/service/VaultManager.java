package securevault.service;

public class VaultManager {

    private AuthenticationService authenticationService;
    private LoggingService loggingService;
    private FileService fileService;
    private EncryptionService encryptionService;

    public VaultManager() {
        authenticationService = new AuthenticationService();
        loggingService = new LoggingService();
        fileService = new FileService();
        encryptionService = new EncryptionService();
    }

    public void showVaultStatus() {
        System.out.println("\n===== SECURE VAULT STATUS =====");
        System.out.println("Authentication Service: Active");
        System.out.println("Logging Service: Active");
        System.out.println("File Service: Active");
        System.out.println("Encryption Service: Active");
        System.out.println("Vault Manager: Active");
    }

    public FileService getFileService() {
        return fileService;
    }

    public EncryptionService getEncryptionService() {
        return encryptionService;
    }

    public LoggingService getLoggingService() {
        return loggingService;
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }
}