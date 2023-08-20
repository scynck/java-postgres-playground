package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// Pode-se importar um método estático de uma classe específica com a sintaxe abaixo
import static com.example.MathUtil.mdc;

// Classes e métodos de teste não precisam ser públicos, mas eles devem
// obrigatoriamente fazer menção ao pacote em que a classe a ser testada
// se encontra, uma vez que ela pode ter métodos protected
public class MathUtilTest {
    @Test   //Anotação - isso que vai dizer que o método abaixo é um teste
    void testMdcP1Bimpar() {
        int a = 6, b = 3;
        int esperado = 3;
        int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
    }
    @Test
    void testMdcP1Bpar() {
        int a = 6, b = 2;
        int esperado = 2;
        int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
    }
    @Test
    void testMdcP3Negativo() {
        int a = -6, b = 0;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
    }
    @Test
    void testMdcP3Positivo() {
        int a = 6, b = 0;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
    }
    @Test
    void testMdcP5Crescente() {
        int a = 6, b = 2;
        int esperado = MathUtil.mdc(b, a);
        int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
    }
    @Test
    void testMdcP5Decrescente() {
        int a = 2, b = 6;
        int esperado = MathUtil.mdc(b, a);
        int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
    }
    @Test
    void testMdcP7() {
        int a = 2, b = 6;
        int esperado = MathUtil.mdc(-a, b);
        int obtido = MathUtil.mdc(a, -b);
        assertEquals(esperado, obtido);
        System.out.println(esperado + "," + obtido);
    }
    @Test
    void testMdcP8Popsitivo() {
        int a = 6;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, a);
        assertEquals(esperado, obtido);
    }
    @Test
    void testMdcP8Negativo() {
        int a = -6;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, a);
        assertEquals(esperado, obtido);
    }
    @Test
    void testMdcP12DoisPrimos() {
        int p = 7, a = p;
        int esperado = p;
        int obtido = MathUtil.mdc(p, a);
        assertEquals(esperado, obtido);
    }
    @Test
    void testMdcP12UmPrimo() {
        int p = 7, a = 2;
        int esperado = 1;
        int obtido = MathUtil.mdc(p, a);
        assertEquals(esperado, obtido);
    }
    @Test
    void testMdcP12PrimoEUm() {
        int p = 7, a = 1;
        int esperado = 1;
        int obtido = MathUtil.mdc(p, a);
        assertEquals(esperado, obtido);
    }
    @Test
    void testMdcCasoGeral30e12() {
        int a = 30, b = 12;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
    }
    @Test
    void testMdcCasoGeral12e9() {
        int a = 9, b = 12;
        int esperado = 3;
        int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
    }
    @Test
    void testMdcP4() {
        int m = 2, a = 6, b = 12;
        int esperado = MathUtil.mdc(m * a, m * b);
        int obtido = m * MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
        assertEquals(12, obtido);   // Pode-se utilizar quantos asserts quiser em um mesmo teste
    }

    @Test
    void testMdc3Valores() {
        int a = 4, b = 12, c = 6;
        int esperado = 2;
        int obtido = MathUtil.mdc(a, b, c);
        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP9() {
        int a = 4, b = 12, c = 6;
        assertTrue(mdc(a, mdc(b, c)) == mdc(mdc(a,b), c) && mdc(mdc(a,b), c) == mdc(a, b, c));

    }

    /*Existe um teste para ver se, o método testado retorna uma exceção quando intencionalmente
     * forçamos um erro nele. Este método é a assertiva assertTrhows e ela tem uma implementação que 
     * demanda um certo cuidado. 
     * Primeiro, ela exige que seja passada a classe da exceção e não a exceção em si e isso é
     * resolvido colocando .class após a exceção.
     * Segundo, ela exige que seja passada uma função sem argumentos e sem retorno que ela vai testar,
     * e isso é feito criando-se uma espécie de decorador, como o abaixo, encapsulando a função ou método
     * que se deseja testar. Além disso, um outro cuidado é que o assertThrows não aceita como argumento
     * o que a função retorna, e sim a própria função e isso é obtido utilizando a sintaxe this::nomeDoMétodo,
     * ou seja, a função não vai ser executada, mas sim será passada ela mesma como argumento para esta
     * asserção
     */
  
    void mdcSemParametros(){
        mdc();
    }

    @Test
    void testMdcNenhumParametro(){
        var exception = assertThrows(IllegalArgumentException.class, this::mdcSemParametros);
        // Esta é uma outra forma de passar a função como argumento, utilizando a função lambda
        assertThrows(IllegalArgumentException.class, () -> mdc());
        // Uma terceira forma, que não demanda a criação de um método aqui é a seguinte:
        // Mesmo o método mdc devolvendo um valor, o assertThrows ignora o valor devolvido
        assertThrows(IllegalArgumentException.class, MathUtil::mdc);

        System.out.println(exception.getMessage());
    
    }

    @Test
    void testMdcParametroNull(){
        var exception = assertThrows(NullPointerException.class, () -> mdc(null));
        var msgexcecao = "Deve ser informado um valor diferente de null";
        assertEquals(msgexcecao, exception.getMessage());

        System.out.println(exception.getMessage());
    
    }

}
