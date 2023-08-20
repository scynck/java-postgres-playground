package com.example.educacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.educacao.dao.ConnectionManager;
import com.example.educacao.dao.AlunoDAO;
import com.example.educacao.model.Aluno;

public class Principal {

    public static void main(String[] args) {
        try (Connection conn = ConnectionManager.getConnection()) {
            var AlunoDAO = new AlunoDAO(conn);
            var aluno2 = new Aluno();            
            //aluno2.setNome("Beltrano");
            //AlunoDAO.cadastrarAluno(aluno2);
            aluno2.setMatricula(2);
            System.out.println("Aluno inserido com sucesso, matrícula = " + aluno2.getMatricula());            
            //AlunoDAO.inserirNota(aluno2.getMatricula(), 3, 5.43);;
            System.out.println(AlunoDAO.listarAlunos());

        } catch (SQLException e) {
            System.err.println("Não foi possível realizar a conexão com o banco de dados. Erro: " + e.getMessage());
        }

        catch (RuntimeException e){
            System.err.println(e.getMessage());
        }
           
    }
}
