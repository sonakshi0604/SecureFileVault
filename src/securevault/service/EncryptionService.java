
package securevault.service;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

public class EncryptionService {

    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final String SECRET_KEY = "SecureVaultKey12";
    private static final int GCM_TAG_LENGTH = 128;
    private static final int IV_LENGTH = 12;

    private SecretKeySpec getKey() {
        return new SecretKeySpec(
                SECRET_KEY.getBytes(StandardCharsets.UTF_8),
                "AES"
        );
    }

    public boolean encryptFile(String fileName) {

        try {
            Path inputPath = Paths.get("vault", fileName);
            Path outputPath = Paths.get("vault", fileName + ".enc");

            if (!Files.exists(inputPath)) {
                System.out.println("File not found.");
                return false;
            }

            byte[] fileData = Files.readAllBytes(inputPath);

            byte[] iv = new byte[IV_LENGTH];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(iv);

            Cipher cipher = Cipher.getInstance(ALGORITHM);

            GCMParameterSpec gcmSpec =
                    new GCMParameterSpec(GCM_TAG_LENGTH, iv);

            cipher.init(
                    Cipher.ENCRYPT_MODE,
                    getKey(),
                    gcmSpec
            );

            byte[] encryptedData = cipher.doFinal(fileData);

            byte[] outputData =
                    new byte[iv.length + encryptedData.length];

            System.arraycopy(
                    iv,
                    0,
                    outputData,
                    0,
                    iv.length
            );

            System.arraycopy(
                    encryptedData,
                    0,
                    outputData,
                    iv.length,
                    encryptedData.length
            );

            Files.write(outputPath, outputData);

            System.out.println("File encrypted successfully.");

            return true;

        } catch (Exception e) {

            System.out.println("Encryption failed.");
            return false;
        }
    }

    public boolean decryptFile(String fileName) {

        try {
            Path inputPath = Paths.get("vault", fileName);

            if (!Files.exists(inputPath)) {
                System.out.println("Encrypted file not found.");
                return false;
            }

            byte[] encryptedFile =
                    Files.readAllBytes(inputPath);

            if (encryptedFile.length <= IV_LENGTH) {
                System.out.println("Invalid encrypted file.");
                return false;
            }

            byte[] iv = new byte[IV_LENGTH];

            System.arraycopy(
                    encryptedFile,
                    0,
                    iv,
                    0,
                    IV_LENGTH
            );

            byte[] encryptedData =
                    new byte[encryptedFile.length - IV_LENGTH];

            System.arraycopy(
                    encryptedFile,
                    IV_LENGTH,
                    encryptedData,
                    0,
                    encryptedData.length
            );

            Cipher cipher = Cipher.getInstance(ALGORITHM);

            GCMParameterSpec gcmSpec =
                    new GCMParameterSpec(GCM_TAG_LENGTH, iv);

            cipher.init(
                    Cipher.DECRYPT_MODE,
                    getKey(),
                    gcmSpec
            );

            byte[] decryptedData =
                    cipher.doFinal(encryptedData);

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

            return true;

        } catch (Exception e) {

            System.out.println("Decryption failed.");
            return false;
        }
    }
}