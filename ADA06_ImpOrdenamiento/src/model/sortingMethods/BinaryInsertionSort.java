package model.sortingMethods;

import model.DoublyLinkedList;

public class BinaryInsertionSort<T> {

    // implementacion iterativa
    /**
     * Realiza una busqueda binaria en una lista(array),
     * dado el valor que se quiere encontrar (item)
     * 
     * @param list
     * @param item
     * @param low
     * @param high
     * @return
     */
    public int binarySearch(int list[], int item, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2; // La mitad de la lista

            if (item == list[mid])
                return mid + 1;
            else if (item > list[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    /**
     * 
     * @param list
     * @param item
     * @param low
     * @param high
     * @return
     */
    public int binarySearch(DoublyLinkedList<T> list, T item, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2; // La mitad de la lista

            if (item.equals(list.searchItemPosition(mid)))
                return mid + 1;
            else if (item.hashCode() > list.searchItemPosition(mid).hashCode())
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    /**
     * 
     * @param a
     * @param n
     */
    public void binaryInsertionSort(int a[], int n) {
        int i, location, j, selected;
        // int k;

        for (i = 1; i < n; ++i) {
            j = i - 1;
            selected = a[i];

            // encuentra la posicion donde debe ser insertado el elemento
            location = binarySearch(a, selected, 0, j);

            // Hace un corrimiento a la derecha de los datos
            while (j >= location) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = selected;
        }
    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}