package com.example.educacao.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.crypto.spec.DESKeySpec;

import com.example.educacao.model.Aluno;
import com.example.model.Estado;



public class AlunoDAO extends DAO{


    public AlunoDAO(Connection conn){
        super(conn);
    }

    public void cadastrarAluno(Aluno aluno){
        try {
            var sql = "insert into aluno (nome) values (?)";
            var statement = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, aluno.getNome());
            statement.executeUpdate();
            var result = statement.getGeneratedKeys();
            if (result.next()){
                aluno.setMatricula(result.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível cadastrar o aluno", e);
        }     
    }

    public void inserirNota(int matricula, int idDisciplina, double nota){     
        if (idDisciplina <= 0 || idDisciplina > 3){
            throw new IllegalArgumentException("O id da disciplina deve estar entre 1 e 3");
            }   
        try {
            var sql = "update aluno set nota" + idDisciplina + " = ? where matricula = ?";
            var statement = conn.prepareStatement(sql);
            statement.setDouble(1, nota);
            statement.setInt(2, matricula);
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível inserir/atualizar a nota", e);
        }
    }


    public List<Aluno> listarAlunos(){
        try{
        var lista = new LinkedList<Aluno>();
        var sql = "select * from aluno";
        var statement = conn.createStatement();
        var consulta = statement.executeQuery(sql);

        while(consulta.next()){
            var aluno = new Aluno();
            aluno.setMatricula(consulta.getInt("Matricula"));
            aluno.setNome(consulta.getString("Nome"));
            aluno.setNota1(consulta.getDouble("Nota1"));
            aluno.setNota2(consulta.getDouble("Nota2"));
            aluno.setNota3(consulta.getDouble("Nota3"));
            lista.add(aluno);            
        }
        return lista;
    } catch(SQLException e){
        throw new RuntimeException("Não foi possível listar os alunos da tabela", e);
    }

    } 


    }

