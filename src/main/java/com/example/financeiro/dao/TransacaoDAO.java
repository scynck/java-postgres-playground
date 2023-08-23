package com.example.financeiro.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.financeiro.model.Transacao;

public class TransacaoDAO extends DAO{

    public TransacaoDAO(Connection conn){
        super(conn);
    }  

    public void criarTransacao(Transacao transacao){
        var sql = "INSERT INTO transacao (cliente, valor, moeda, tipo) VALUES (?, ?, ?, ?)";
        try(var statement = conn.prepareStatement(sql)) {
            statement.setString(1, transacao.getCliente());
            statement.setDouble(2, transacao.getValor());
            statement.setString(3, transacao.getMoeda());
            statement.setString(4, String.valueOf(transacao.getTipo()));
            statement.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //System.err.println("Não foi possível executar a inserção no banco de dados, erro: " + e);
            throw new RuntimeException("Não foi possível executar a inserção no banco de dados, erro: " + e);
        }
    }

    public List<Transacao> listarTransacao(){
        var sql = "SELECT * FROM transacao";
        List<Transacao> listaTransacoes= new LinkedList<>();
        try (var statement = conn.createStatement()) {
            var retornoBD = statement.executeQuery(sql);
            while(retornoBD.next()){
                Transacao transacao = new Transacao(retornoBD.getString("cliente"), retornoBD.getDouble("valor"), retornoBD.getString("moeda"), retornoBD.getString("tipo").charAt(0));
                listaTransacoes.add(transacao);
            }
            return listaTransacoes;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException("Não foi possível listar os valores presentes no banco de dados. Erro: " + e);
        }
    }


    
}
