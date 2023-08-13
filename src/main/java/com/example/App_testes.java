package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App_testes {
    public static void main(String[] args) {
        System.out.println("Aplicação Java\n");
        System.out.println();    //Atalho para o comando de printar = sysout e o vscode já completa o resto
        //Vídeo 2________________________________________________________________________________
        /*  Declaração de variável
         Em java, as variáveis são fortemente e estaticamente tipadas
         A declaração ocorre assim: tipo nomeDaVariavel = valor; Não esquecer o ; ao final 
         */
        int idade = 120;
        double peso = 80.6;
        System.out.println("Idade é " + idade + ", Peso é: " + peso);
        

        //Vídeo 3________________________________________________________________________________
        /* Conversão de tipo - Cast
        É possível fazer um processo de conversão de tipo de variáveis, chamado de cast.
        Este processo força o compilador a alterar o tipo de uma variável.
        A alteração de tipo de uma variável pode ser feito sem o Cast, desde que uma variável declarada como sendo de um tipo,
        tenha um TIPO "menor" do que o novo tipo, como no exemplo abaixo.*/
        byte idadeByte1 = 127;
        int idadeInt1 = idadeByte1;
        System.out.println(idadeInt1);

        /*Dizer que um tipo se enquadra em outro tipo tem a ver com o fato de que alguns tipos são mais amplos que outros,
        por exemplo, no caso de números inteiros, o tipo byte é menor que o tipo short, que é menor que o tipo int
        que é menor que o tipo double. Dessa forma, qualquer conversão de variáveis de um tipo menor para um maior por ser feita sem problema.
        Entretanto, caso um tipo de uma variável seja maior que um outro tipo para o qual que se queira conversar a variável,
        o compilador indicará um erro da forma: Type mismatch: cannot convert from int to byte*/
        int idadeInt2 = 127;
        //byte idadeByte2 = idadeInt2; //Código comentado para não dar erro de compilação, para ver o erro basta descomentar e ver o grifado vermelho//

        /*É possível ainda forçar a conversão de um tipo maior para outro menor utilizando o Cast através da sintaxe:
        novotipo nomeDaVariável = (novotipo)variávelAntiga*/
        byte idadeByte2 = (byte)idadeInt2;
        System.out.println(idadeByte2);

        /*Entretanto, esta conversão pode levar a um erro comum de sobrecarga que não é percebido pel Compilador, apenas pelo Programador e que é comum
        de ser cobrado em provas práticas.
        Este erro se origina da situação em que se queira conversar uma variável de um tipo maior para um tipo menor sendo que o valor declarado anteriormente
        não "cabe" no tipo menor, como por exemplo, caso se queira converter um int de valor 128 para um byte que só comporta valores entre 0 e 127.
        Neste caso, o compilador irá realizar uma conversão expúria e o novo valor armazenado no tipo byte não terá relação com o valor anterior armazenado em int */
        int idadeInt3 = 128;
        byte idadeByte3 = (byte)idadeInt3;
        System.out.println(idadeByte3);

        //Vídeo 4________________________________________________________________________________

        /*Em Java, a declaração de variáveis de texto é um pouco diferente das demais, por exemplo, para decalarar um char, que é um único caracter,
        utiliza-ze aspas simples ('') e para declarar strings, aspas duplas("")*/
        char caracter = 'r';
        System.out.println(caracter);

        /*Para declarar booleanos, utiliza o tipo boolean e os valores permitidos são false e true. Diferentemente de outras linguagens, utilizar
        0 ou 1 para booleanos não funciona*/
        
        boolean booleano = true;
        System.out.println(booleano);

        /*Nas versões mais recentes do Java, houve inclusão do comando var que permite criar uma variável qualquer sem necessariamente especificar seu tipo,
        entretanto, depois de criada, como o Java é fortemente e estaticamente tipado, o tipo da variável é atribuído automaticamente pelo compilador e a mudança 
        posteriormente não é permitida. */
        //Por padrão, ao se declarar números inteiros, ele reconhece automaticamente como int.
        var algumInt = 10;

        //Para se declarar um float, faz-se necessário utilizar um valor condizente, por exemplo

        var algumFloat = 10.0;

        System.out.println(algumInt);
        System.out.println(algumFloat);


    }
}
