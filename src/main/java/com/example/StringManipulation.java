package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringManipulation {
    public static void main(String[] args){
        String sentence = "Socorram-me subi no onibus em Marrocos";
        StringBuilder reversed = palindromo(sentence);        
        System.out.println(reversed.toString());
        List<Integer> values = FibonacciSequence(7);
        System.out.println(values);

        //System.out.println(FibonacciSequence(7));

    }

    public static StringBuilder palindromo(String sentence){
        String charSentence = sentence.trim().replace(" ", "").toLowerCase().replace("-", "");
        StringBuilder reversedSentence = new StringBuilder(charSentence);
        reversedSentence = reversedSentence.reverse();
        if(charSentence.equals(reversedSentence.toString())){
            System.out.println("É palíndromo");
        }else System.err.println("Não é palíndromo");        
        return reversedSentence;
    }


    public static int Fibonacci(Integer n){
        if (n<=1){
            return 1;
        }
            else{
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }

    public static List<Integer> FibonacciSequence(Integer n){
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            System.out.println(i);
            System.out.println(Fibonacci(i));
            sequence.add(Fibonacci(i));
            
        }
        int[] listaqualquer = {2, 6, 5, 2, 9, 1};
            Arrays.sort(listaqualquer);
            for (int i : listaqualquer) {
                System.out.print(i + " ");
            }
            
        return sequence;
    }
}

