package com.SOLID.SRP.Sol;

import java.sql.Connection;

public interface DbConnectionManager {
    public Connection getConnection();
    public void closeConnection();
}