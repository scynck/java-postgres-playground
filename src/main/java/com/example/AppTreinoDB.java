package com.example;

import java.sql.SQLException;

import com.example.dao.ConnectionManager;
import com.example.dao.DAO;
import com.example.dao.EstadoDAO;
import com.example.dao.ProdutoDAO;
import com.example.model.Estado;
import com.example.model.Marca;
import com.example.model.Produto;

/*Exercício: Implementar os métodos faltantes no EstadoDAO e no ProdutoDAO, o que tem em um que não tem no outro */

public class AppTreinoDB {
    public static void main(String[] args){
        new AppTreinoDB();
    }

    public AppTreinoDB() {
        //Não é necessário fazer o carregamento do driver JDBC em aplicações mais modernas pq alguns frameworks se encarregam disso
        // carregarDriverJDBC();        
        try (var conn = ConnectionManager.getConnection()){
            var estadoDAO = new EstadoDAO(conn); //Houve necessidade de instanciar pq os métodos não são estáticos
            var produtoDAO = new ProdutoDAO(conn);
            var dao = new DAO(conn);        

            var listaEstados = estadoDAO.listar();

            for (Estado estado : listaEstados) {
                System.out.println(estado);
            }
            estadoDAO.localizar("MG");    

            Marca marca = new Marca();
            marca.setId(1L);
            Produto produto = new Produto();
            produto.setNome("Produto Teste 2");
            produto.setMarca(marca);
            produto.setValor(200);
            produto.setId(203L);

            produtoDAO.inserir(produto);
            produtoDAO.excluir(204L);
            produtoDAO.atualizar(produto);
            
            dao.listarDados("produto");

        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados. Erro: " + e.getMessage());
        }
    }


    public void carregarDriverJDBC(){
        try{
            Class.forName("org.postgresql.Driver");

        } catch(ClassNotFoundException e){
            System.err.println("Não foi possível carregar a biblioteca. Erro: " + e.getMessage());
        }
    }
    
}
