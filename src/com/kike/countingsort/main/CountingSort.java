package com.kike.countingsort.main;

public class CountingSort {

    // Función principal para ordenar un arreglo de enteros utilizando Counting Sort
    static void countingSort(int arr[]) {
        int n = arr.length;

        // Encontrar el valor máximo en el arreglo para determinar el rango
        int max = findMax(arr);

        // Crear un arreglo de conteo "count" con el tamaño igual al valor máximo + 1
        int[] count = new int[max + 1];

        // Inicializar el arreglo de conteo
        for (int i = 0; i <= max; i++) {
            count[i] = 0;
        }

        // Contar la frecuencia de cada elemento en el arreglo original
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Reconstruir el arreglo ordenado
        int[] sortedArr = new int[n];
        int index = 0;

        // Recorrer el arreglo de conteo y colocar los elementos ordenados en "sortedArr"
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                sortedArr[index] = i;
                index++;
                count[i]--;
            }
        }

        // Copiar el arreglo ordenado de vuelta al arreglo original
        System.arraycopy(sortedArr, 0, arr, 0, n);
    }

    // Función auxiliar para encontrar el valor máximo en un arreglo
    static int findMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Función para imprimir un arreglo
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 4, 2, 2, 8, 3, 3, 1 };
        int n = arr.length;

        System.out.println("Arreglo original:");
        printArray(arr);

        countingSort(arr);

        System.out.println("Arreglo ordenado:");
        printArray(arr);
    }
}
