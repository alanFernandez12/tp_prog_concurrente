package modelos;

public class QuickSortConcurrente extends Thread{
    private int[] arr;    // Arreglo a ordenar
    private int low;      // Índice de inicio del subarreglo
    private int high;     // Índice de fin del subarreglo

    // Constructor que recibe el arreglo y los límites
    public QuickSortConcurrente(int[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    // Método que se ejecuta cuando el hilo comienza
    public void run() {
        if (low < high) { // Condición base para dividir el arreglo
            int pi = partition(arr, low, high); // Se obtiene la posición del pivote después de la partición

            // Se crean dos nuevos hilos para ordenar las mitades izquierda y derecha del pivote
            QuickSortConcurrente left = new QuickSortConcurrente(arr, low, pi - 1);
            QuickSortConcurrente right = new QuickSortConcurrente(arr, pi + 1, high);

            left.start(); // Se inicia el hilo izquierdo
            right.start(); // Se inicia el hilo derecho

            try {
                left.join(); // Se espera que termine el hilo izquierdo
                right.join(); // Se espera que termine el hilo derecho
            } catch (InterruptedException e) {
                e.printStackTrace(); // Manejo de excepción si un hilo es interrumpido
            }
        }
    }

    // Método para realizar la partición del arreglo
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Se toma el último elemento como pivote
        int i = low - 1; // Índice del menor elemento

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) { // Si el elemento actual es menor o igual al pivote
                i++; // Se incrementa el índice del menor
                // Se intercambian los elementos en i y j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Se coloca el pivote en su posición correcta (i + 1)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Se retorna el índice del pivote
    }
}
