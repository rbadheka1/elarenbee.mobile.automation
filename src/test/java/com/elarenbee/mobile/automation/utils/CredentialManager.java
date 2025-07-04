package com.elarenbee.mobile.automation.utils;

import org.jasypt.util.text.BasicTextEncryptor;

public class CredentialManager {
    private static final BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

    static {
        String secret = System.getenv("CONFIG_SECRET");
        if (secret == null) {
            throw new IllegalStateException("CONFIG_SECRET env variable is not set!");
        }
        textEncryptor.setPassword(secret);
    }

    public static String decrypt(String encrypted) {
        if (encrypted != null && encrypted.startsWith("ENC(") && encrypted.endsWith(")")) {
            encrypted = encrypted.substring(4, encrypted.length() - 1);
        }
        return textEncryptor.decrypt(encrypted);
    }
}
