import java.util.Arrays;
public class testSecuencial {

    public static void swap (int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Partición usando el esquema de partición de Lomuto
    public static int partition(int[] a, int start, int end)
    {
        // Elija el elemento más a la derecha como un pivote de la array
        int pivot = a[end];

        // los elementos menores que el pivote serán empujados a la izquierda de `pIndex`
        // elementos más que el pivote serán empujados a la derecha de `pIndex`
        // elementos iguales pueden ir en cualquier dirección
        int pIndex = start;

        // cada vez que encontramos un elemento menor o igual que el pivote,
        // `pIndex` se incrementa, y ese elemento se colocaría
        // antes del pivote.
        for (int i = start; i < end; i++)
        {
            if (a[i] <= pivot)
            {
                swap(a, i, pIndex);
                pIndex++;
            }
        }

        // intercambiar `pIndex` con pivote
        swap(a, end, pIndex);

        // devuelve `pIndex` (índice del elemento pivote)
        return pIndex;
    }

    // Rutina de clasificación rápida
    public static void quicksort(int[] a, int start, int end)
    {
        // condición base
        if (start >= end) {
            return;
        }

        // reorganizar los elementos a través del pivote
        int pivot = partition(a, start, end);

        // recurre en un subarray que contiene elementos menores que el pivote
        quicksort(a, start, pivot - 1);

        // se repite en el subarray que contiene más elementos que el pivote
        quicksort(a, pivot + 1, end);
    }

    // Implementación en Java del algoritmo Quicksort
    public static void main(String[] args)
    {
        int[] a = { 9, -3, 5, 2, 6, 8, -6, 1, 3 };

        quicksort(a, 0, a.length - 1);

        // imprime la array ordenada
        System.out.println(Arrays.toString(a));
    }
}
