package com.example.dao;

import java.sql.Connection;

public class DAO1 {
    protected Connection conn;

    public DAO1(Connection conn){
        this.conn = conn;
        
    }
    
}
