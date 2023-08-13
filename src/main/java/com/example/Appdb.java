package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Appdb {
    public static void main(String[] args){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            System.err.println("Não foi possível carregar a biblioteca: " + e.getMessage());
        }

        Statement statement = null;
        try(var conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "serpro")){
            System.out.println("Conexão realizada com sucesso");
            statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado");
            while (result.next()){
                System.out.printf("Id: %d, Nome: %s, UF: %s \n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }
        } catch (SQLException e){
            if (statement == null){
                System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());
            } else System.err.println("Não foi possível executar a consulta ao banco" + e.getMessage());
        }


    }
}
