package com.example.model;
import java.time.LocalDate;

public class Cidadao {

    private LocalDate dataNascimento;
    private int idade;

    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    public int idade(){
        this.idade = LocalDate.now().getYear() - dataNascimento.getYear();
        return idade;
    }

    public String eleitor(){
        /*IMPORTANTE
         * Quando se tem o return dentro de um encadeamento de ifs, não é necessário utilizar o else if, porque se ele adentrar um dos ifs, 
         * ao passar pelo return, ele já sai da função ou do método
         */
        if(idade < 16)
            return "Não é eleitor";
        
        if(idade > 16 && idade < 18 || idade > 70)
            return "Eleitor facultativo";
        
        else return "Eleitor obrigatório";
            
        }
    }
