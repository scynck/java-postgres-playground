package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Marca;
import com.example.model.Produto;

public class ProdutoDAO extends DAO{

    public ProdutoDAO(Connection conn){
        super(conn); //Herança - chamando o construtor da super classe DAO
    }

    /* +++++++++++++++++ Diferença entre declarar uma variável chamando seu tipo ou sua classe. ++++++++++++++++++++++++++++
    Ao utilizar a letra maíuscula para declarar, estamos chamando a classe. Se utilizarmos a letra minúscula,
    estamos utilizanbdo o tipo, como por exemplo:
    long variavel - Declarando pelo tipo
    Long variável - Declarando pela classe

    A diferença de declarar pela classe é q ela aceita valores nulos, e pelo tipo não. 
    Isso pode ser uma vantagem em algumas situações e desvantagem em outras, por exemplo, 
    na classe Produto, utilizou a classe pq ao criar um produto, não tendo um construtor, 
    o id dele vai ser declarado inicialmente como nulo ao instanciar um objeto.
    Entretando, na função abaixo, utilizamos long minúsculo pq a função vai utilizar o 
    argumento para excluir um item na tabela, logo não podemos aceitar valores nulos para tal
    */

    public void excluir(long idProduto) {
        var sql = "delete from produto where id = ?";
        try(var statement = conn.prepareStatement(sql)){
            statement.setLong(1, idProduto);
            if (statement.executeUpdate() == 1){
                System.out.println("Produto excluído!");
            } else System.out.println("Produto não localizado");

        }catch (SQLException e){
            System.err.println("Erro no statement do método excluir produto. Erro: " + e.getMessage());
        }
    }

    public void atualizar(Produto produto){
        var sql = "update produto set nome = ?, marca_id = ?, valor = ? where id = ?";
        try(var statement = conn.prepareStatement(sql);){
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.setLong(4, produto.getId());
            statement.executeUpdate();

        }catch(SQLException e){
            System.err.println("Erro ao atualizar produto. Erro: " + e.getMessage());
        }

    }

    public void inserir(Produto produto) {
        var sql = "insert into produto (nome, marca_id, valor) values (?, ?, ?)";
        try (var statement = conn.prepareStatement(sql)){
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro no statement do método inserir produto. Erro: " + e.getMessage());
        }      

    }

    public List<Produto> listar() throws SQLException{
        var sql = "select * from estado";
        var produtoList = new LinkedList<Produto>();

        var statement = conn.createStatement();
        var valor = statement.executeQuery(sql);

        while(valor.next()){
            var produto = new Produto();
            var marca = new Marca();
            produto.setId(valor.getLong("id"));
            produto.setNome(valor.getString("nome"));
            marca.setId(valor.getLong("marca_id"));
            produto.setMarca(marca);
            produto.setValor(valor.getDouble("valor"));
            produtoList.add(produto);
        }
        return produtoList;



    } 
    
}
