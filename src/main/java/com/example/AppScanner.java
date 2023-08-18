package com.example;

import java.util.Scanner;

import com.example.model.Cliente;

public class AppScanner {
    
    // O método main dentro da Classe de mesmo nome do arquivo serve para indicar que esta classe será executada
    public static void main(String[] args){
        
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Fulano Silva");
        cliente1.setAnoNascimento(1992);
        cliente1.setCidade("Uberlandia");
        cliente1.setCpf("99999999999");
        cliente1.setEspecial(false);
        cliente1.setRenda(2000);
        cliente1.setSexo('M');
;
        System.out.println("Ano de nascimento: " + cliente1.getAnoNascimento());
        System.out.println("Nome: " + cliente1.getNome());
        System.out.println("Cidade: " + cliente1.getCidade());
        System.out.println("CPF: " + cliente1.getCpf());
        System.out.println("Especial?: " + cliente1.isEspecial());
        System.out.println("Renda: " + cliente1.getRenda());
        System.out.println("Sexo: " + cliente1.getSexo());

        /*A entrada de dados em Java pode ser feita pela Classe Scanner. Esta classe é bastante ampla, sendo capaz de extrair dados inclusive de arquivos.
         * Para extrair dados do teclado, se faz necessário utilizado o argumento System.in.
         * Uma macete para chamar uma classe que depende de um pacote que precisa ser importado é utilizar o recuso de autocompletar que o comppilador 
         * já chama automaticamente na importação.
         */

        Scanner scanner = new Scanner(System.in);

        Cliente cliente2 = new Cliente();

        /*Para capturar a entrada digitada por um teclado, utiliza-se os seguintes métodos:
        nextLine = Para pegar strings
        nextDouble = Para pegar doubles
        nestBoolean = Para pegar booleans e etc.
        Ressalva 1: O nextLine aceita todas as teclas numéricas, portanto ao digitar ENTER, ele consegue capturar e ir para a próxima linha
        entretanto, os demais não captura a tecla ENTER, fazendo-se necessário inserir um nextLine depois deles para o compilador ser capaz
        de seguir com o programa
        Ressalva 2: Não existe um método específico para pegar variáveis do tipo char. Para tal, utiliza-se o nextLine e o método charAt() para
        pegar o caracter de posição 0 na string recebida.
        */


        System.out.print("Digite o nome do Cliente: ");
        cliente2.setNome(scanner.nextLine());
        System.out.print("Digite a renda do cliente: ");
        cliente2.setRenda(scanner.nextDouble());         
        scanner.nextLine();                                  //Ressalva 1
        System.out.print("Digite o sexo do cliente: ");
        cliente2.setSexo(scanner.nextLine().charAt(0));     //Ressalva 2
        System.out.print("Digite o Ano de nascimento: ");
        cliente2.setAnoNascimento(scanner.nextInt());     
        scanner.nextLine();                                 //Ressalva 1

        /*cliente2.setNome(scanner.nextLine());
        cliente2.setNome(scanner.nextLine());
        */


        System.out.println("Ano de nascimento: " + cliente2.getAnoNascimento());
        System.out.println("Nome: " + cliente2.getNome());
        System.out.println("Cidade: " + cliente2.getCidade());
        System.out.println("CPF: " + cliente2.getCpf());
        System.out.println("Especial?: " + cliente2.isEspecial());
        System.out.println("Renda: " + cliente2.getRenda());
        System.out.println("Sexo: " + cliente2.getSexo());


    }
}
