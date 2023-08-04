package com.example;

public class AppClasses {
    
    // O método main dentro da Classe de mesmo nome do arquivo serve para indicar que esta classe será executada
    public static void main(String[] args){
        /*Objetos são instanciados obedecendo às mesmas regras de instanciação de variáveis de tipos simples, ou seja
        tipo nomeDaVariável = new tipo, considerando que a classe criada é um tipo novo de variável criado pelo dev para o projeto*/
        Cliente cliente1 = new Cliente();     
        Cliente cliente2 = new Cliente(); 
        
        /*Para atribuir valor aos atributos de um objeto, utiliza-se a sintaxe abaixo, a qual está comentada porque se tornou inválida
        porque os atributos foram definidos como privados para só serem acessíveis pelos métodos setter e getter
        
        cliente1.renda = 10000;
        cliente1.sexo = 'M';
        cliente1.anoNascimento = 1990;
          
        cliente2.renda = 20000;
        cliente2.sexo = 'F';
        cliente2.anoNascimento = 1970;

        // Para chamar os atributos de objetos
        System.out.println(cliente1.renda);
        System.out.println(cliente1.sexo);
        System.out.println(cliente1.anoNascimento);        
        System.out.println();
        System.out.println(cliente2.renda);
        System.out.println(cliente2.sexo);
        System.out.println(cliente2.anoNascimento);
        */


        /*Utilizando os métodos Setter e Getter para definir e chamar os atributos*/
        System.out.println();
        cliente1.setRenda(2000);
        System.out.println(cliente1.getRenda());
        cliente2.setSexo('M');
        System.out.println(cliente1.isEspecial());
        System.out.println(cliente2.isEspecial());

        Cliente cliente3 = new Cliente();
        Cliente cliente4 = new Cliente(3000, 'M');

        /*Strings são classes e portanto podem ser declarados como um objeto, entretanto, por simplificação também
         * podem ser declaradas como uma variáveis de tipo simples
         */
        
        String nome1 = new String("Fulano");
        String nome2 = "Beltrano";
        System.out.println("Nome é: " + nome1); 
        System.out.println("Nome é: " + nome2); 


        cliente3.setNome(nome1);
        cliente3.setCpf("99999999999");
        cliente3.setCidade("Uberlandia");
        cliente4.setNome(nome2);
        cliente4.setCpf(new String("99999999999"));
        cliente4.setCidade("uberlandia");

        /*Testanto os métodos de Strings: */

        /*Utilizando o == para comparar Strings pode retornar true or false se ambas forem iguais. Isso acontece pq o Java otimiza o código em tempo
         * de compilação, trabalhando com ponteiros que apontam para mesmos campos de memória, caso duas ou mais variáveis possuam os mesmos valores, 
         * retornando, neste caso, true. Entretanto, quando se força a criação de uma nova variável com a sintaxe utilizando new Stirng como acima,
         * mesmo que seu valor seja igual ao de uma outra string, ele não vai reconhecè-la como igual, pois o == não compara valores, e sim os objetos
         * por inteiro. Por isso se faz necessário o uso do método .equals()
         */
        if (cliente3.getCpf() == cliente4.getCpf()){
            System.out.println("Mesmo CPF");
        } else{
            System.out.println("CPFs diferentes");
        }
        
        if (cliente3.getCpf().equals(cliente4.getCpf())){
            System.out.println("Mesmo CPF");
        } else{
            System.out.println("CPFs diferentes");
        }

        if (cliente3.getCidade().equals(cliente4.getCidade())){
            System.out.println("Mesma Cidade");
        } else{
            System.out.println("Cidades diferentes");
        }

        if (cliente3.getCidade().equalsIgnoreCase(cliente4.getCidade())){
            System.out.println("Mesma Cidade");
        } else{
            System.out.println("Cidades diferentes");
        }
        
        String nome3 = "Fulano Silva  ";
        System.out.println(nome3.trim());
        System.out.println(nome3.split(" ")[0]);
        System.out.println(nome3.split(" ")[1]);
        System.out.println(nome3.charAt(1));
        System.out.println(nome3.toLowerCase());

    }
}
