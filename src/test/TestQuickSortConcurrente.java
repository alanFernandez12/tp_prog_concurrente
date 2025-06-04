package test;

import modelos.QuickSortConcurrente;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class TestQuickSortConcurrente {
    private static int tam = 1000000;
    public static int[] array = new int[tam];

    public static void main(String[] args) {

        // Creando array con numeros aleatorios
        Random rand = new Random();
        for (int i = 0; i < tam ; i++) {
            array[i]= rand.nextInt(100);
        }
//        for (int i = 0; i < tam ; i++) {
//            System.out.print(" "+ array[i]);
//        }


        ForkJoinPool pool = new ForkJoinPool();
        QuickSortConcurrente sorter = new QuickSortConcurrente(array, 0, array.length - 1);

        long start = System.currentTimeMillis();
        pool.invoke(sorter);
        long end = System.currentTimeMillis();

        System.out.println("Terminé :)");
//        for (int i = 0; i < tam ; i++) {
//            System.out.print(" "+ array[i]);
//        }
        System.out.println("Tiempo: " + (end - start) + " ms");
    }
}

