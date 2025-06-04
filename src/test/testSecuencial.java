package test;

import modelos.QuickSortSecuencial;

import java.util.Random;

public class testSecuencial {
    private static int tam = 100000;
    public static int[] array = new int[tam];

    // Implementación en Java del algoritmo Quicksort
    public static void main(String[] args)
    {
        // Creando array con numeros aleatorios
        Random rand = new Random();
        for (int i = 0; i < tam ; i++) {
            array[i]= rand.nextInt(100);
        }


        // imprime la array sin ordenar
        /*for (int i = 0; i < tam ; i++) {
            System.out.print(" "+ array[i]);
        }
        */

        QuickSortSecuencial quick = new  QuickSortSecuencial();
        quick.quicksort(array, 0, array.length -1);

        System.out.print("termine :)");
        /*// imprime la array ordenada
        for (int i = 0; i < tam ; i++) {
            System.out.print(" "+ array[i]);
        }
        */
    }
}
