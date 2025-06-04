package test;

import modelos.QuickSortSecuencial;

import java.util.Random;

public class testSecuencial {
    private static int tam = 1000000;
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
        long start = System.currentTimeMillis();
        QuickSortSecuencial quick = new  QuickSortSecuencial();
        quick.quicksort(array, 0, array.length -1);


        /*// imprime la array ordenada
        for (int i = 0; i < tam ; i++) {
            System.out.print(" "+ array[i]);
        }
        */


        long end = System.currentTimeMillis();

        System.out.println("Terminé :)");
//        for (int i = 0; i < tam ; i++) {
//            System.out.print(" "+ array[i]);
//        }
        System.out.println("Tiempo: " + (end - start) + " ms");
    }
}
