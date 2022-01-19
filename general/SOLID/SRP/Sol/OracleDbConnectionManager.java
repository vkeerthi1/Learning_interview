package com.SOLID.SRP.Sol;

import java.sql.Connection;

public class OracleDbConnectionManager implements DbConnectionManager{
    private CredentialManager credentialManager;
    public Connection getConnection() {
//get DB connection using password provided by credentialManager
        return null;
    }
    @Override
    public void closeConnection() {
    }
}