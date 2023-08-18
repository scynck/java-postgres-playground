package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DAO {

    protected Connection conn;

    public DAO(Connection conn) {
        this.conn = conn;
    }

    public void listarDados(String tabela){
        var sql = "select * from " + tabela; //Não indicado concatenar com dados oriundos do usuário
        try {
            var statement = conn.createStatement();
            var result = statement.executeQuery(sql);
            int cols = result.getMetaData().getColumnCount();

            for (int i = 1; i <= cols; i++) {
                System.out.printf("%-25s | ", result.getMetaData().getColumnName(i));                
            }
            System.out.println();

            while(result.next()){
                for (int i = 1; i <= cols; i++) {
                    System.out.printf("%-25s | ", result.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar a tabela.");
        }
    }
    
}
