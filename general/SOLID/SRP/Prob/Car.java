package com.SOLID.SRP.Prob;

import java.sql.Connection;
import java.sql.SQLException;

public class Car {
    private Engine engine;
    private Wheel wheel;
    private Body body;
    private ServiceHistory serviceHistory;

    public void start() {
    }

    public void stop() {
    }

    public void logServiceHistory() throws SQLException {
        Credentials credentials = getCredentialsFromFile("credentials.xml");
        Connection connection = getOracleDbConnection(credentials);
//write data into DB
        connection.commit();
        connection.close();
    }

    private Credentials getCredentialsFromFile(String xmlFileName) {
//Decrypt the credentials and return
        String encryptedCredentials = readFromFile(xmlFileName);
        return decrypt(encryptedCredentials);
    }

    private Connection getOracleDbConnection(Credentials credentials) {
//Using jdbc get connection to the DB
    }

    private String readFromFile(String xmlFileName) {
// open file and read the contents. Then close
    }

    private String decrypt(String encryptedCredentials) {
//Decode using Base64 algorithm
    }
}
