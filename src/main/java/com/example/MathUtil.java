package com.example;

public class MathUtil {

    static int mdc(int a, int b){
        //P7
        a = Math.abs(a);
        b = Math.abs(b);
        int maior = Math.max(a, b);
        b = Math.min(a,b);
        a = maior;

        //P1
        if (b > 0 && a % b == 0){
            return b;
        }

        if(b == 0){
            return Math.abs(a);
        }

        return mdc(a-b, b);

        /*while (a != b){
            diferenca = a - b;
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("diferenca = " + diferenca);
            if (diferenca > 0){
                a = diferenca;
                System.out.println("Entrou no 1 if");
                System.out.println("a = " + a);
                break;
            }
            break;
        }*/

    }

    static int mdc(int ...valores){
        if (valores == null){
            throw new NullPointerException("Deve ser informado um valor diferente de null");
        }

        if (valores.length == 0){
            throw new IllegalArgumentException("É necessário ao menos um valor para calcular o MDC");
        }

        int a = valores[0];
        for (int i : valores) {
            a = mdc(a, i);
        }
        return a;
    }
}
