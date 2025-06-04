package modelos;

import java.util.concurrent.RecursiveAction;

public class QuickSortConcurrente extends RecursiveAction {
    private int[] arr;
    private int low;
    private int high;
    private static final int THRESHOLD = 10000; // Tamaño mínimo para dividir tareas

    public QuickSortConcurrente(int[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {
        if (low < high) { // si el subarreglo tiene al menos dos elementos
            if (high - low < THRESHOLD) { //si el arreglo es pequeño se puede ordernar secuencialmente
                quickSortSecuencial(arr, low, high);
            } else {
                int pi = partition(arr, low, high); //Particiona el arreglo y obtiene el pivote
                invokeAll( // crea 2 tareas en paralero y recursivo
                        new QuickSortConcurrente(arr, low, pi - 1), //izquierdo
                        new QuickSortConcurrente(arr, pi + 1, high) // derecho
                );
            }
        }
    }

    private void quickSortSecuencial(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortSecuencial(arr, low, pi - 1);
            quickSortSecuencial(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // toma el ultimo elemento como pivote
        int i = low - 1; //menor elemento

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) { //si el elemento es menor o igual al pivote
                i++; // incrementa el indice
                swap(arr, i, j); // intercambia los elementos
            }
        }

        swap(arr, i + 1, high); //coloca el pivote en su posición final
        return i + 1; // Retorma el indice del pivote
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; // Intercambia dos elementos del arreglo
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
