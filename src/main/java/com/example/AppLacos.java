package com.example;
import java.util.Arrays;

public class AppLacos {
    
    public static void main(String[] args) {
        // Aula 6 - Utilizando laços FOR para gerar e printar vetores e matrizes

        int vetorInt[] = new int[5];
        // Para chamar um laço for, um atalho é digitar fori que o vscode autocompleta
        for (int i = 0; i < vetorInt.length; i++) {
            vetorInt[i] = 10 * (i+1);
        }
        System.out.println(Arrays.toString(vetorInt));

        // Construir e Printar uma matriz
        double matrizDouble[][] = new double[3][4];
        for(int i = 0; i < matrizDouble.length; i++) {
            for(int j = 0; j < matrizDouble[i].length; j++) {
                matrizDouble[i][j] = (j + 1) + (i * matrizDouble[i].length);
                System.out.printf("%5.1f ", matrizDouble[i][j]);                
            }
            System.out.println();
        }

        for(int i = 0; i < matrizDouble.length; i++){
            for (int j = 0; j < matrizDouble[i].length; j++) {
                System.out.printf("%5.1f ", matrizDouble[i][j]);                
            }
            System.out.println();
        }   

    }
}
