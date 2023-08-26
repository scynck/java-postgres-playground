package com.example;

public class Ordenamento {

    public static void main(String[] args) {
        Double[] vetor = {5.0, 4.0, 2.0, 7.0, 5.0, 9.0, 3.0, 2.0};
        Double[] bubbledVector = BubbleSort(vetor);
        Double[] quickedVector = QuickSort(vetor, 0, vetor.length-1);

        for (Double double1 : bubbledVector) {
            System.out.print(double1 + " ");
        }
        System.out.println();
        for(Double double2 : quickedVector){
            System.out.print(double2 + " ");
        }

    }

    public static Double[] BubbleSort(Double[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if(vetor[j] > vetor[j+1]){
                    var aux = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                }                
            }
        }
        return vetor;
    }    

    public static Double[] QuickSort(Double[] vetor, int iniVet, int endVet){
        int i = iniVet;
        int j = endVet;
        double pivo = vetor[Math.round((i + j)/2)];

        while(i <= j){
            while(vetor[i] < pivo){
                i++;
            }
            while(vetor[j] > pivo){
                j--;
            }
            if(i <= j){
                double aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
                i++;
                j--;
            }
            if (i < endVet){
                QuickSort(vetor, i, endVet);
            }
            if (iniVet < j){
                QuickSort(vetor, iniVet, j);
            }
        }
        return vetor;
    }

}
