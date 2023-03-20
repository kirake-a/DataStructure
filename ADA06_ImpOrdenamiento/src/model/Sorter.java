package model;

import java.util.Arrays;

public class Sorter {
    DoublyLinkedList<Song> songs;

    public Sorter() {
        songs = new DoublyLinkedList<>();
    }

    public Sorter(DoublyLinkedList<Song> songs) {
        this.songs = songs;
    }

    public void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            // Encuentra el punto medio del vector.
            int middle = (left + right) / 2;

            // Divide la primera y segunda mitad (llamada recursiva).
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Une las mitades.
            merge(arr, left, middle, right);
        }
    }

    private void merge(int arr[], int left, int middle, int right) {
        // Encuentra el tamaño de los sub-vectores para unirlos.
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Vectores temporales.
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        // Copia los datos a los arrays temporales.
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + j + 1];
        }
        /* Une los vectorestemporales. */

        // Índices inicial del primer y segundo sub-vector.
        int i = 0, j = 0;

        // Índice inicial del sub-vector arr[].
        int k = left;

        // Ordenamiento.
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        } // Fin del while.

        /* Si quedan elementos por ordenar */
        // Copiar los elementos restantes de leftArray[].
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        // Copiar los elementos restantes de rightArray[].
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void binaryInsertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int x = array[i];

            // Find location to insert
            // using binary search
            int j = Math.abs(
                    Arrays.binarySearch(array, 0,
                            i, x) + 1);

            // Shifting array to one
            // location right
            System.arraycopy(array, j,
                    array, j + 1, i - j);

            // Placing element at its
            // correct location
            array[j] = x;
        }
    }

    /**
     * The main funcion that implements QuickSort
     * 
     * @param arr  Array to be sorted
     * @param low  Starting index
     * @param high Ending index
     */
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * This function takes the last element as pivot, places
     * the pivot element as its correct position in sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right
     * of pivot
     * 
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return (i + 1);
    }

    /**
     * Implements the radix Sort method
     * @param array
     * @param size
     */
    void radixSort(int array[], int size) {
        // Get maximum element
        int max = getMax(array, size);

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(array, size, place);
    }

    // Using counting sort to sort the elements in the basis of significant places
    private void countingSort(int array[], int size, int place) {
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;

        // Calculate count of elements
        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;

        // Calculate cumulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }

        for (int i = 0; i < size; i++)
            array[i] = output[i];
    }

    // Function to get the largest element from an array
    private int getMax(int array[], int n) {
        int max = array[0];

        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

}
