package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Cidadao;
import com.example.model.Cliente;

public class AppListas {
    /*Definição de vetores - Eles podem ser definidos sobre qualquer tipo, primitivo ou composto, inclusive classes criadas */
    public static void main(String[] ags){
    
    Cliente[] vetorCliente = new Cliente[10]; //Ao declarar um vetor, já deve-ser declarar seu tamanho

    List<Cliente> listaCliente = new ArrayList<>(); //Ao criar uma lista, não precisa especificar o tamanho, mas é uma boa prática utilizar no caso das arraylists
    /*  Ao criar uma ArrayList, cria-se uma estrutura de dados de 10 elementos, caso forçe a ter mais q isso, o java automaticamente cria uma nova estrutura 
    com mais 5 posições, migra o conteúdo da existente para a nova e portanto abre mais 5 espaços e isso é repetido sempre que se adiciona mais elementos
    */

    List<Cliente> linkedCliente = new LinkedList<>(); // Já as linked lists são mais recomendadas para os casos em que não se conhece o tamanho do array, mas é mais lenta

    /*Ao se utilizar a sintaxe acima, está criando uma lista genérica que, estranhamente, só aceita elementos do tipo declarado inicialmente, utilizando a sintaxe abaixo sem
     * o <>, permite-se que a lista receba qualquer tipo, o que é desaconselhável como boa prática, como no exemplo abaixo
     */

    List listaQqCoisa = new ArrayList();
    listaQqCoisa.add(new Cliente());
    listaQqCoisa.add(new Cidadao());
    listaQqCoisa.add("Isto é uma string");
    listaQqCoisa.add(123);
    System.out.println(listaQqCoisa);

    Cliente cliente1 = new Cliente();
    cliente1.setNome("Fulano");
    cliente1.setCidade("Tangamandapio");

    Cliente cliente2 = new Cliente();
    cliente2.setNome("Beltrano");
    cliente2.setCidade("Araguari");

    listaCliente.add(cliente1);
    listaCliente.add(cliente2);
    listaCliente.add(cliente1);
    listaCliente.add(cliente2);
    listaCliente.add(cliente1);
    listaCliente.add(cliente2);
    listaCliente.add(cliente1);
    listaCliente.add(cliente2);
    listaCliente.add(cliente1);
    listaCliente.add(cliente2);

    listaCliente.remove(0);
    listaCliente.remove(cliente1);
    
    System.out.println(vetorCliente);
    System.out.println(listaCliente);

    for (var cliente : listaCliente){
        System.out.println(cliente);
    }
    

    }


}
