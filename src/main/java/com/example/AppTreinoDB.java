package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AppTreinoDB {
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "serpro";

    public static void main(String[] args){
        new AppTreinoDB();
    }

    public AppTreinoDB() {
        //Não é necessário fazer o carregamento do driver JDBC em aplicações mais modernas pq alguns frameworks se encarregam disso
        // carregarDriverJDBC();        
        try (var conn = getConnection()){
        //listarEstados(conn);
            localizarEstado(conn, "MG");    

            Marca marca = new Marca();
            marca.setId(1L);
            Produto produto = new Produto();
            produto.setNome("Produto Teste 1");
            produto.setMarca(marca);
            produto.setValor(200);
            produto.setId(203L);

            //inserirProduto(conn, produto);
            //excluirProduto(conn, 204L);
            atualizarProduto(conn, produto);
            
            listarDadosTabela(conn, "produto");

        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados. Erro: " + e.getMessage());
        }
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

    private void excluirProduto(Connection conn, long idProduto) {
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

    private void atualizarProduto(Connection conn, Produto produto){
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

    private void inserirProduto(Connection conn, Produto produto) {
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

    private void listarDadosTabela(Connection conn, String tabela){
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

    private void localizarEstado(Connection conn, String uf){
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

    private void listarEstados(Connection conn) {        

        try {            
            System.out.println("Conexão com o banco realizada com sucesso!");
            var statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado");
            while(result.next()){
                System.out.printf("Id: %d, Nome: %s, UF: %s \n", result.getInt("ID"), result.getString("nome"), result.getString("uf"));
            }
        } catch (SQLException e) {
                System.err.println("Consulta ao Banco de dados incorreta. Erro: " + e.getMessage());
            }
        
    }

    public void carregarDriverJDBC(){
        try{
            Class.forName("org.postgresql.Driver");

        } catch(ClassNotFoundException e){
            System.err.println("Não foi possível carregar a biblioteca. Erro: " + e.getMessage());
        }
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
    
}
