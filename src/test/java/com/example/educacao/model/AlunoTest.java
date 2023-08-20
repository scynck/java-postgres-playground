package com.example.educacao.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AlunoTest {
    @Test
    void CalculaMediaErroPrecisao() {
        var nota1 = 10.00;
        var nota2 = 8.00;
        var nota3 = 8.00;
        var esperado = 8.66;
        var aluno = new Aluno();
        aluno.setNota1(nota1);
        aluno.setNota2(nota2);
        aluno.setNota3(nota3);
        var obtido = aluno.calculaMedia();
        assertEquals(esperado, obtido, 0.01);
    }
    @Test
    void CalculaMediaExato() {
        var nota1 = 10.00;
        var nota2 = 8.00;
        var nota3 = 9.00;
        var esperado = 9.00;
        var aluno = new Aluno();
        aluno.setNota1(nota1);
        aluno.setNota2(nota2);
        aluno.setNota3(nota3);
        var obtido = aluno.calculaMedia();
        assertEquals(esperado, obtido);
    }
}
