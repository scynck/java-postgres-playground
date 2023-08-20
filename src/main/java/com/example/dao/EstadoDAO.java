package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Estado;
import com.example.model.RegiaoGeografica;

public class EstadoDAO extends DAO{
    Connection conn;

    public EstadoDAO(Connection conn){
        super(conn);
    }

    public List<Estado> listar() throws SQLException{    
   
        var lista = new LinkedList<Estado>();
        var statement = conn.createStatement();
        var result = statement.executeQuery("select * from estado");
        while(result.next()){
            var estado = new Estado();
            var regiao = new RegiaoGeografica();
            estado.setId(result.getLong("ID"));
            estado.setNome(result.getString("nome"));
            estado.setUf(result.getString("uf"));
            estado.setArea(result.getInt("area_km2"));
            estado.setPopulacao(result.getInt("populacao"));
            /*Ideia de exercício: Fazer um método em alguma classe adequada para retornar o nome da região a partir da ID para salvar no objeto estado */
            regiao.setId(result.getLong("regiao_id"));
            estado.setRegiao(regiao);
            lista.add(estado);
        }

    return lista;
        
    }


    public void localizar(String uf){
        try{
            
            // Concatenar variáveis com strings funciona, porém é vulnerável a ataques de SQL Injection
            //var statement = conn.createStatement();
            //var result = statement.executeQuery("select * from estado where uf = '" + uf + "'");
            //Como solução, utiliza-se o método prepareStatement
            var sql = "select * from estado where uf = ?";
            var statement = conn.prepareStatement(sql);
            statement.setString(1, uf);
            var result = statement.executeQuery();

            if(result.next()){
                System.out.printf("ID: %d, Nome: %s, UF: %s \n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }

        } catch(SQLException e){
            System.err.println("Consulta ao Banco de dados incorreta. Erro: " + e.getMessage());
        }

    }


}
