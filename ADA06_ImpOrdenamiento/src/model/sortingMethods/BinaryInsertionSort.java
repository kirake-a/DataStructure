package model.sortingMethods;

import model.Country;
import model.DoublyLinkedList;

public class BinaryInsertionSort<T extends Comparable <T>>{

    /**
     * 
     * @param list
     * @param item
     * @param low
     * @param high
     * @return
     */
    public int binarySearch(DoublyLinkedList<T> list, T item, int low, int high, int sortAttribute) {
        while (low <= high) {
            int mid = low + (high - low) / 2; // La mitad de la lista

            if (item.equals(list.searchItemPosition(mid)))
                return mid + 1;
            else if (compare(item, list.searchItemPosition(mid), sortAttribute) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    public void binaryInsertionSort(DoublyLinkedList<T> list, int n, int sortAttribute){
        int i, location, j;
        T selected;

        for (i = 1; i < n; ++i) {
            j = i - 1;
            selected = list.searchItemPosition(i);

            location = binarySearch(list, selected, 0, j, sortAttribute);

            while (j >= location) {
                list.insertInPosition(j+1, list.searchItemPosition(j));
                j--;
            }
            list.insertInPosition(j+1, selected);
        }
    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    private int compare(T a, T b, int sortAttribute) {

        Country country1 = (Country) a;
        Country country2 = (Country) b;

        switch (sortAttribute) {

            case 1:

                if (country1.getPopulation() > country2.getPopulation()) {
                    return -1;
                } else if (country1.getPopulation() < country2.getPopulation()) {
                    return 1;
                } else {
                    return 0;
                }
            case 2:
                return country1.getCountryName().compareTo(country2.getCountryName());

            case 3:
                if (country1.getActiveCases() > country2.getActiveCases()) {
                    return -1;
                } else if (country1.getActiveCases() < country2.getActiveCases()) {
                    return 1;
                } else {
                    return 0;
                }

            case 4:
                if (country1.getTotalDeaths() > country2.getTotalDeaths()) {
                    return -1;
                } else if (country1.getTotalDeaths() < country2.getTotalDeaths()) {
                    return 1;
                } else {
                    return 0;
                }

            default:
                return 0;
        }
    }
}