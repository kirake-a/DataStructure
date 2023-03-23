package model.sortingMethods;

public class QuickSort {
    // Todavia no esta la version descendente del metodo

    /**
     * The main funcion that implements QuickSort
     * 
     * @param arr  Array to be sorted
     * @param low  Starting index
     * @param high Ending index
     */
    public void quickSortUpward(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSortUpward(arr, low, pi - 1);
            quickSortUpward(arr, pi + 1, high);
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
}
