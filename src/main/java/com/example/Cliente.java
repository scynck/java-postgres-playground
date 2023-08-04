package com.example;

/*Esta classe foi movida do arquivo original clicando nela com o botão direito, Refactor e Move
 * Após este processo, ele deve receber a atribuição de public para ficar acessível para todas as pastas que estejam no projeto
 */


public class Cliente{
    // Atributos são as variáveis declaradas no escopo de uma classe, não dentro de um método
    //Método é uma função declarada dentro de uma classe
    private double renda;
    private char sexo;
    private int anoNascimento;
    private boolean especial;
    private String nome;
    private String cpf;
    private String cidade;


    /*Métodos construtores definem a forma que uma classe é instanciada em um objeto, podendo receber parâmetros que serão informados
     * na ocasião de criação de cada objeto ou alguma lógica que carregue um comportamento sempre que um objeto dessa classe é criado
     * Ao não ser criado, um método construtor é definido automaticamente em Java
     * Para criá-lo, utiliza-se a sintaxe alteradorDeAcesso NomeClasse(). Obrigatoriamente seu nome é o nome da Classe
     */

    public Cliente(){
        System.out.println("Objeto criado pelo construtor sem parâmetro");
        if(Math.random()>0.5){
            especial = true;
        }
    }

    /*Estretanto, pode-se utilizar o princípio do overload para declarar um outro construtor, mas que, desta vez, aceita parâmetros
     * isto é, ele é chamado quando a classe for instanciada fornecendo a quantidade de parâmetros com que ele é definido
     * No exemplo abaixo, definimos um construtor com dois parâmetros: renda e sexo
     * Pode-se inclusive chamar os respectivos setters
     */
    public Cliente(double renda, char sexo){
        this(); //Esta linha serve para chamar o construtor que definimos antes, sem parâmetros, para utilizar suas funcionalidades. Entretanto, sempre que isso ocorrer,
        // ele tem q ser chamado na primeira linha
        // Cria-se o objeto com os atributos utilizando os métodos Setters para garantir as mesmas restrições
        System.out.println("Objeto criado pelo construtor com parâmetros");
        setRenda(renda);
        setSexo(sexo);
    }

        
    /*Dentre os métodos mais comuns em boas práticas de Java, encontram-se os Setters e os Getters
     * Setters são utilizados para se alterar o valor de algum parâmetro de um objeto
     * Getters são utilizados para se obter o valor atual de algum parâmetro de um objeto
     */

     /*Setters por convenção possuem um único atributo e, por boa prática, sua nomenclatura é setNomeAtributo
      * Sua utilização é vantajosa pois permite-se filtrar valores possívels para os atributos de um objeto
      * Como um método Setter não retorna nenhum valor, na sua declaração utiliza-se a palavra void
      * Mas como ele tem um parâmetro por convenção, o parâmetro é declarado com o mesmo tipo do atributo
      */

    /*Uma vez criados os setters e getters, deve-se tornar os atributos privados para que os mesmos sejam alterados ou 
     * fiquem visíveis apenas pelos métodos setters e getters. Para isto, utiliza-se a palavra private em suas declarações
     * Além disso, para se criar setters e getters dos atributos, basta clicar neles com o botão direito, selecionar 
     * Source Action e então criar os setters e getters, inpondo as respectivas restrições de valor
     */

    
    public void setNome(String nome){
        // Strings são classes em Java e portanto possuem métodos que são bastante úteis, como por exemplo:
        // Método trim - Remove espaços no começo e no final de uma string, retornando apenas a parte que tem caracteres
        // Método equals - Utilizado para comparar Strings ao invés de utilizar o operador ==
        // Método toUpperCase e toLowerCase - Que transformam todos os chars de uma string em caixa alta ou baixa
        // Métodos isBlank e isEmpty que retornam um boolean indicando se a String é um objeto vazio ou que possui apenas espaços ou se ele é apenas vazio, respectivamente
        // Método split() que quebra a String em um vetor de Strings a partir de um determinado identificador
        // Método charAt() que retorna qual o caracter em uma dada posição na String

        if(nome.isBlank()){
            System.out.println("Nome inválido!");
        } else{
            this.nome = nome.trim().toUpperCase();  
        }
        
    }
    public String getNome(){
        return nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public String getCidade(){
        return cidade;
    }

    public void setEspecial(boolean especial){
        this.especial = especial;
    }

    public boolean isEspecial(){
        return especial;
    }

    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        if(sexo == 'M' || sexo == 'H')
            this.sexo = sexo;
        else System.out.println("Informe um sexo válido");
    }
    public int getAnoNascimento() {
        return anoNascimento;
    }
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public void setRenda(double renda){
        // Por boa prática, utiliza-se o parâmetro com o mesmo nome do atributo. Entretanto, para diferenciá-los
        //no escopo de uma função, utiliza-se o this para se referir ao atributo
        if(renda >= 0)
            this.renda = renda;
        else System.out.println("Informe uma renda válida");
    }
    /*Já o métodos Getter, não possui nenhum parâmetro, entretanto ele deve retornar um valor, portanto na sua declaração
     * utiliza-se o tipo da variável que ele retorna, da mesma forma que se declara uma variável, entretanto com o () após seu nome.
     * Por boa prática, nomeia-se um Getter como getNomeAtributo
    */
    public double getRenda(){
        return this.renda;
    }



}