package com.example.model;

public class RegiaoGeografica {
    private Long id;
    private String nome;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
}
