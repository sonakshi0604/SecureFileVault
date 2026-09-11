package securevault.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionService {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "SecureVaultKey12";

    private SecretKeySpec getKey() {
        return new SecretKeySpec(
                SECRET_KEY.getBytes(),
                ALGORITHM
        );
    }

    public void encryptFile(String fileName) {

        try {
            byte[] fileData = Files.readAllBytes(
                    Paths.get("vault", fileName)
            );

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, getKey());

            byte[] encryptedData = cipher.doFinal(fileData);

            Files.write(
                    Paths.get("vault", fileName + ".enc"),
                    encryptedData
            );

            System.out.println("File encrypted successfully.");

        } catch (Exception e) {
            System.out.println("Encryption failed.");
            e.printStackTrace();
        }
    }

    public void decryptFile(String fileName) {

        try {
            byte[] encryptedData = Files.readAllBytes(
                    Paths.get("vault", fileName)
            );

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, getKey());

            byte[] decryptedData = cipher.doFinal(encryptedData);

            String originalName;

            if (fileName.endsWith(".enc")) {
                originalName = fileName.substring(
                        0,
                        fileName.length() - 4
                );
            } else {
                originalName = "decrypted_" + fileName;
            }

            Files.write(
                    Paths.get("vault", originalName),
                    decryptedData
            );

            System.out.println("File decrypted successfully.");

        } catch (Exception e) {
            System.out.println("Decryption failed.");
            e.printStackTrace();
        }
    }
}