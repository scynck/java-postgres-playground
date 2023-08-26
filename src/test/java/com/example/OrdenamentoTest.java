package com.example;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


public class OrdenamentoTest {
    @Test
    void testBubbleSort() {
        Double[] expected = {1.0, 2.0, 3.0, 4.0};
        Double[] vetor = {4.0,3.0,2.0,1.0};
        Double[] returned = Ordenamento.BubbleSort(vetor);
        assertArrayEquals(expected, returned);
    }

    @Test
    void testQuickSort() {
        Double[] expected = {1.0, 2.0, 3.0, 4.0};
        Double[] vetor = {4.0,3.0,2.0,1.0};
        Double[] returned = Ordenamento.QuickSort(vetor, 0, vetor.length-1);
        assertArrayEquals(expected, returned);

    }

    @Test    
    void testEntradaPar() {
        Double[] expected = {1.0, 2.0, 3.0, 4.0, 6.0, 9.0};
        Double[] vetor = {4.0,3.0,2.0,1.0, 9.0, 6.0};
        Double[] returnedBubble = Ordenamento.BubbleSort(vetor);
        Double[] returnedQuick = Ordenamento.QuickSort(vetor, 0, vetor.length-1);

        assertArrayEquals(expected, returnedBubble);
        assertArrayEquals(expected, returnedQuick);
    }

    @Test    
    void testEntradaImpar() {
        Double[] expected = { 0.0, 1.0, 2.0, 3.0, 4.0, 6.0, 9.0};
        Double[] vetor = {4.0,3.0,2.0,1.0, 9.0, 6.0,  0.0};
        Double[] returnedBubble = Ordenamento.BubbleSort(vetor);
        Double[] returnedQuick = Ordenamento.QuickSort(vetor, 0, vetor.length-1);

        assertArrayEquals(expected, returnedBubble);
        assertArrayEquals(expected, returnedQuick);
    }
}
