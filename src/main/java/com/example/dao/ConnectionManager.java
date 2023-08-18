package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "serpro";

    /* Se o método de uma classe não for static, ele não pode ser chamado diretamente pela classe, 
     * mas sim, instanciando a classe e chamando-o pelo objeto criado. Por exeplo, no código em que 
     * o método abaixo getConnection é chamado, não foi necessário instanciar a classe presente,
     * o mesmo pôde ser chamado simplesmente chamando a classe e ele como por exemplo
     * ConnectionManager.getConnection()
     */

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
