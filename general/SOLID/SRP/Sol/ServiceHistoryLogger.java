package com.SOLID.SRP.Sol;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceHistoryLogger {
    private DbConnectionManager dbConnectionManager;
    public void logServiceHistory(Car car) throws SQLException {
        Connection connection = dbConnectionManager.getConnection();
//write data into DB using connection
        connection.close();
    }
    public void setDbConnectionManager(DbConnectionManager dbConnectionManager) {
        this.dbConnectionManager = dbConnectionManager;
    }
}