package com.example.model;

public class Produto {
    private Long id;
    private String nome;
    private Marca marca;
    private Double valor;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }  
    public void setValor(double valor){
        this.valor = valor;
    }
    public double getValor(){
        return valor;
    }


}
