package com.example;

import java.util.Arrays;

public class AppArray {
    public static void main(String[] args) {
        //Aula 05____________________________________________________________________________
        /*Na aula 5 será apresentado o primeiro tipo complexo em Java, que se opõe aos tipos simples por serem capazes de armezanar
        mais de 1 valor.
        Iremos trabalhar com arrays e como se estruturam suas operações.
        Primeiramente, para declarar um array, utiliza-se uma sintaxe parecida com a declaração de variáveis simples, com o acréscimo de 
        colchetes[], quantos pares for a dimensão do array, se apenas um (vetor), ou se mais de um (matrizes de 2 ou mais dimensões).
        Os valores são sempre declarados entre chaves {} */
        int vetorInt[] = {1, 2, 3};
        double vetorDouble[] = {1.0, 2.0, 3.0};
        System.out.println(vetorInt);
        System.out.println(vetorDouble);

        /*Veja que printar um array não funciona muito bem. Para vizualizar o conteúdo dele, deve-se, antes de printar, converter
        seus valores para strings*/
        System.out.println(Arrays.toString(vetorInt));
        System.out.println(Arrays.toString(vetorDouble));

        // Ou printar um valor único, chamando o valor dentro do vetor com o índice, que começa em 0, entre colchetes
        System.out.println(vetorInt[1]);

        // Utilizando a mesma chamada do vetor, pode-se alterar seu valor

        vetorInt[1] = 4;
        System.out.println(Arrays.toString(vetorInt));

        /*  Matrizes são declaradas colocando uma sequência de pares de colchetes que corresponde à dimensão do array. 
        IMPORTANTE: Matrizes não precisam ser declaradas com as dimensões possuindo o mesmo tamanho. Por exemplo, 
        uma matriz pode ter 2 linhas e 3 colunas, com uma das linhas tendo apenas 2 colunas, como no exemplo abaixo*/

        int matrizInt[][] = {{1, 2}, {10, 20, 30}};
        System.out.println(Arrays.toString(matrizInt[0]));
        System.out.println(Arrays.toString(matrizInt[1]));

        /*Diferentemente das variáveis simples, não é possível converter arrays para tipos maiores, simplesmente atribuindo
         * ao novo valor. Entretanto, se os arrays forem do mesmo tipo.
         */
        double vetorDouble2[] = vetorDouble;
        System.out.println(Arrays.toString(vetorDouble2));

        double vetorDouble3[] = {50, 60, 70, 60};
        System.out.println(Arrays.toString(vetorDouble3));
        vetorDouble3 = vetorDouble;
        System.out.println(Arrays.toString(vetorDouble3));
        //A operação abaixo não é possível
        //vetorDouble3 = vetorInt;
        //System.out.println(Arrays.toString(vetorDouble3));

        /*Além de ser possível substituir o valor de um array por outro array de mesmo tipo, mas de tamanho diferente, também é possível substituir
        seu valor declarando da seguinte forma.
        NÃO ESQUECER A SINTAXE new tipo[]{valores}, porque o java só aceita reescrever um array se for do mesmo tipo, mesmo que seja de tamanho diferente
         */
        vetorDouble3 = new double[]{100, 200, 300, 400, 500, 600};
        System.out.println(Arrays.toString(vetorDouble3));

        //O mesmo vale para matriz, deve ser do mesmo tipo, não precisa ser do mesmo tamanho
        matrizInt[0] = new int[]{9, 8, 7, 6};
        System.out.println(Arrays.toString(matrizInt[0]));
        System.out.println(Arrays.toString(matrizInt[1]));

        /*IMPORTANTE: Como as variáveis são estaticas em Java, não é possível extender o tamanho de um array simplesmente
         * adicionando novos elementos a ele. Como solução, ou declara o vetor vazio, identificando apenas seu tamanho, alocando
         * os espaços ou utiliza-se a sintaxe com o comando new. Veja que dessa forma ele cria com valores padrão 0.
         */

         int vetorInt2[] = new int[4];
         System.out.println(Arrays.toString(vetorInt2));

    }
    
}
