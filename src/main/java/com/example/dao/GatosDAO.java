package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Gatos;

public class GatosDAO extends DAO1{

    private Connection conn;

    public GatosDAO(Connection conn){
        super(conn);
    }
    
    public Gatos pegarGato(Integer id){

        var sql = "SELECT * FROM gatos WHERE id = ?";
        Gatos gato1 = new Gatos();
        try(var statement = conn.prepareStatement(sql)){
            statement.setInt(1, id);
            var registro = statement.executeQuery();
            while(registro.next()){
                
                gato1.setNome(registro.getString("nome"));
                gato1.setIdade(registro.getInt("idade"));
                gato1.setCor(registro.getString("cor"));
            }       

        }catch(SQLException e){
            System.out.println("Erro ao ler um registro. Erro: " + e.getMessage());
        }
        return gato1;       

    }

    public List<Gatos> listTable(){
        List<Gatos> listaGatos = new LinkedList<Gatos>(null);
        var sql = "select * from gatos";
        try(var statement = conn.createStatement()){
            var registers = statement.executeQuery(sql);
            while(registers.next()){
                var gato = new Gatos();
                gato.setNome(registers.getString("nome"));
                gato.setIdade(registers.getInt("idade"));
                gato.setCor(registers.getString("cor"));
                listaGatos.add(gato);
            }
            
        }catch(SQLException e){
            System.err.println("Não foi possível executar a consulta. Erro: " + e.getMessage());
        }
        return listaGatos;
    }

    public void inserirGato(Gatos gato) throws SQLException{
        var sql = "insert into gatos (nome, idade, cor) values (?, ?, ?)";
        var statement = conn.prepareStatement(sql);
        statement.setString(1, gato.getNome());
        statement.setInt(2, gato.getIdade());
        statement.setString(3, gato.getCor());
        statement.executeUpdate();        

    }

    public void atualizarGato(Integer id, Gatos gato)throws SQLException{
        var sql = "update gatos set nome = ?, idade = ?, cor = ? where id = ?";
        var statement = conn.prepareStatement(sql);
        statement.setString(1, gato.getNome());
        statement.setInt(2, gato.getIdade());
        statement.setString(3, gato.getNome());
        statement.setInt(4, id);
        statement.executeUpdate();
    }

    public void excluirGato(Integer id)throws SQLException{
        var sql = "delete from gatos where id = ?";
        var statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        if (statement.executeUpdate() == 1){
            System.out.println("Exclusão realizada com sucesso");
        }else System.out.println("Gato não localizado");
        
    }

}
