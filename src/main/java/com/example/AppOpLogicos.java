package com.example;

import java.time.LocalDate;

public class AppOpLogicos {

    boolean a(boolean valor){
            System.out.println("a");
            return valor;
         }

    boolean b(boolean valor){
            System.out.println("b");
            return valor;
         }

    boolean c(boolean valor){
            System.out.println("c");
            return valor;
        }

        /*Como os métodos a, b e c foram declarados como dinâmicos (ausência do static na frente), a função main, que é static não consegue
         * lidar com métodos não static. Para funcionar, pode-se declarar a, b e c como static mas isso não é uma boa prática.
         * A solução conforme o clean code é criar um construtor para a classe que leva o nome do arquivo e que, por sua vez, também leva o nome
         * da classe, e nele chamar os métodos que não são static.
         * Por fim, no main instancia a própria classe chamando na verdade o construtor que vai executar o código que está nele
         * Ficar atento porque o Java, ao avaliar uma expressão lógica, se ele já souber o resultado sem ter q varrer toda a expressão, ele não
         * o fará, já retornando seu valor.
        */
        
        AppOpLogicos(){
            
            System.out.println(a(true) && b(false) || c(true));
        }


    public static void main(String[] args) {
        /*Neste exemplo, vamos criar uma função que apenas printa seu nome quando é chamada, mas que retorna o valor lógico
         * que for dado como argumento
         */
        new AppOpLogicos();

        


    }
    
}
