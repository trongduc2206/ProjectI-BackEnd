package com.project.utils;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
public class CipherUtils {

    private static final String cipherTransformation    = "AES/CBC/PKCS5PADDING";
    private static final String aesEncryptionAlgorithem = "AES";


    /**
     * Method for Encrypt Plain String Data
     * @param plainText
     * @return encryptedText
     */
    public static String encrypt(String plainText, String encryptionKey) {
        String encryptedText = null;
        try {
            Cipher cipher   = Cipher.getInstance(cipherTransformation);
            byte[] key      = encryptionKey.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
            IvParameterSpec ivparameterspec = new IvParameterSpec(key);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivparameterspec);
            byte[] cipherText = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            Base64.Encoder encoder = Base64.getEncoder();
            encryptedText = encoder.encodeToString(cipherText);

        } catch (Exception e) {
            log.error("Encrypt Exception ={}",e.getMessage());
        }
        return encryptedText;
    }

    /**
     * Method For Get encryptedText and Decrypted provided String
     * @param encryptedText
     * @return decryptedText
     */
    public static String decrypt(String encryptedText, String encryptionKey) {
        String decryptedText = null;
        try {
            Cipher cipher = Cipher.getInstance(cipherTransformation);
            byte[] key = encryptionKey.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
            IvParameterSpec ivparameterspec = new IvParameterSpec(key);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivparameterspec);
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] cipherText = decoder.decode(encryptedText.getBytes(StandardCharsets.UTF_8));
            decryptedText = new String(cipher.doFinal(cipherText), StandardCharsets.UTF_8);

        } catch (Exception e) {
            log.error("Encrypt Exception ={}",e.getMessage());

        }
        return decryptedText;
    }
}
