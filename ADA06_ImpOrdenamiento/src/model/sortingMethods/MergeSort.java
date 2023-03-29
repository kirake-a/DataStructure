package model.sortingMethods;

import model.Country;
import model.DoublyLinkedList;

public class MergeSort<T extends Comparable<T>> {
    private DoublyLinkedList<T> theList;
    private int nElems; // number of data items
    private int sortAttribute;

    // public MergeSort(int max) {
    // theArray = new long[max]; // create array
    // nElems = 0;
    // }

    public MergeSort() {
        nElems = 0;
    }

    public void insert(T value) {
        theList.insertInPosition(nElems, value);
        nElems++;
    }

    // public void mergeSort() {
    // long[] workSpace = new long[nElems];
    // recMergeSort(workSpace, 0, nElems-1);
    // }

    public void mergeSort(int sortAttribute) {
        DoublyLinkedList<T> list = new DoublyLinkedList<>();
        this.sortAttribute = sortAttribute;
        recMergeSort(list, 0, nElems - 1);
    }

    private void recMergeSort(DoublyLinkedList<T> list, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(list, lowerBound, mid);
            recMergeSort(list, mid + 1, upperBound);
            merge(list, lowerBound, mid + 1, upperBound, this.sortAttribute);
        }
    }

    private void merge(DoublyLinkedList<T> list, int lowPtr, int highPtr, int upperBound, int sortAttribute) {
        int j = 0; // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int numItems = upperBound - lowerBound + 1;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (compare(theList.searchItemPosition(lowPtr), theList.searchItemPosition(highPtr), sortAttribute) < 0) {
                list.insertInPosition(j++, this.theList.searchItemPosition(lowPtr++));
            } else {
                list.insertInPosition(j++, this.theList.searchItemPosition(highPtr++));
            }
        }

        while (lowPtr <= mid) {
            list.insertInPosition(j++, this.theList.searchItemPosition(lowPtr++));
        }

        while (highPtr <= upperBound) {
            list.insertInPosition(j++, this.theList.searchItemPosition(highPtr++));
        }

        for (int i = 0; i < numItems; i++) {
            this.theList.insertInPosition(lowerBound + i, list.searchItemPosition(i));
        }
    }

    /**
     * Realiza una comparacion entre el tipo de dato {@code a} y el tipo de dato
     * {@code b},
     * en funcion de conocer cual de ellos es mas grande o si fuera el caso, conocer
     * si los datos
     * son iguales, para ellos obtendremos que, si el tipo de dato {@code a} es
     * menor al tipo de
     * dato {@code b} se regresa {@code -1}, si fuera el caso se regresa un
     * {@code 1}, y si ambos
     * datos son iguales entonces se regresa un {@code 0}
     * 
     * @param a             Primer dato, se comparara con el segundo dato
     * @param b             Segundo dato, se comparara con el primer dato
     * @param sortAttribute Selecciona el atributo por el cual se realizara
     *                      comparacion entre los nodos
     * @return El valor resultante de la comparacion
     */
    private int compare(T a, T b, int sortAttribute) {

        Country country1 = (Country) a;
        Country country2 = (Country) b;

        switch (sortAttribute) {

            case 1:

                if (country1.getPopulation() < country2.getPopulation()) {
                    return -1;
                } else if (country1.getPopulation() > country2.getPopulation()) {
                    return 1;
                } else {
                    return 0;
                }
            case 2:
                return country1.getCountryName().compareTo(country2.getCountryName());

            case 3:
                if (country1.getActiveCases() < country2.getActiveCases()) {
                    return -1;
                } else if (country1.getActiveCases() > country2.getActiveCases()) {
                    return 1;
                } else {
                    return 0;
                }

            case 4:
                if (country1.getTotalDeaths() < country2.getTotalDeaths()) {
                    return -1;
                } else if (country1.getTotalDeaths() > country2.getTotalDeaths()) {
                    return 1;
                } else {
                    return 0;
                }

            default:
                return 0;
        }
    }
}