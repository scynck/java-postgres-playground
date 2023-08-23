package com.example.financeiro.model;

import java.util.*;

public class Transacao {
    private Integer id;
    private String cliente;
    private double valor;
    private String moeda;    
    private char tipo;

    public Transacao(String cliente, double valor, String moeda, char tipo){
        this.cliente = cliente;
        this.valor = valor;
        this.moeda = moeda;
        this.tipo = tipo;
    }    

    public Integer getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public String getMoeda() {
        return moeda;
    }

    public char getTipo() {
        return tipo;
    }

    public List<Transacao> getTodasTransacoes() {
        return todasTransacoes;
    }


    public List<Transacao> todasTransacoes = new ArrayList<>();

    public void adicionarTransacao(Transacao t){
        todasTransacoes.add(t);
    }

    public List<Transacao> filtrar(String cliente){
        List<Transacao> listaFiltrada = new LinkedList<>();
        for (Transacao transacao : todasTransacoes) {
            if(transacao.getCliente().equals(cliente)){
                listaFiltrada.add(transacao);
            }
        }
        return listaFiltrada;
    }

    public List<Transacao> filtrar(char tipo){
        return todasTransacoes.stream()
                                .filter(transacao -> transacao.getTipo() == tipo)
                                .toList();
    }

    public double getSaldo(String cliente){
        double saldo = 0.0;
        for(Transacao t : todasTransacoes){
            if (t.cliente.equals(cliente)){
                saldo += t.valor;
            }
        }
    return saldo;
    }

    public String toString(){
        return("Cliente: " + this.cliente + ", Valor: " + this.valor + "\n");
    }


    
}
