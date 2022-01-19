package com.SOLID.SRP.Sol;

public class CredentialManager {
    private Credentials getCredentialsFromFile(String xmlFileName) {
//Decrypt the credentials and return
        String encryptedCredentials = readFromFile(xmlFileName);
        return decrypt(encryptedCredentials);
    }
    private String readFromFile(String xmlFileName) {
// open file and read the contents. Then close
    }
    private String decrypt(String encryptedCredentials) {
//Decode using Base64 algorithm
    }
}