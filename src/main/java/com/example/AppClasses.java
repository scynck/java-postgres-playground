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


        /*Utilizando os métodos Setter e Getter */
        System.out.println();
        cliente1.setRenda(2000);
        System.out.println(cliente1.getRenda());
        cliente2.setSexo('P');
        
    }
}
