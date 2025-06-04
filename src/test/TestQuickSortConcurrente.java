package test;

import modelos.QuickSortConcurrente;

import java.util.Random;

public class TestQuickSortConcurrente {
    private static int tam = 10000;
    public static int[] array = new int[tam];

    public static void main(String[] args) {

        // Creando array con numeros aleatorios
        Random rand = new Random();
        for (int i = 0; i < tam ; i++) {
            array[i]= rand.nextInt(100);
        }
        /*for (int i = 0; i < tam ; i++) {
            System.out.print(" "+ array[i]);
        }

         */
        // Crear el objeto ConcurrentQuickSort con todo el arreglo
        QuickSortConcurrente sorter = new QuickSortConcurrente(array, 0, array.length - 1);
        sorter.start(); // Inicia el proceso concurrente

        try {
            sorter.join(); // Espera a que termine la ejecución de todos los hilos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mostrar el arreglo ordenado
        System.out.println("termine :)");
        /*
        for (int i = 0; i < tam ; i++) {
            System.out.print(" "+ array[i]);
        }

         */
    }
}

