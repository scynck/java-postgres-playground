package com.example.financeiro.dao;

import java.sql.Connection;

public class DAO {
    protected Connection conn;

    public DAO(Connection conn){
        this.conn = conn;
    }
    
}
