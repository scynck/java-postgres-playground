package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager1 {
    private static final String URL = "jdbc:postgresql://localhost.postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "serpro";


    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
