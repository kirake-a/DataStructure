package model.sortingMethods;

import model.Country;
import model.DoublyLinkedList;

public class MergeSort<T> {
    private DoublyLinkedList<T> listAttribute;
    private int nElems; // number of data items
    private int sortAttribute;

    // public MergeSort(int max) {
    // theArray = new long[max]; // create array
    // nElems = 0;
    // }

    public MergeSort(DoublyLinkedList<T> theList) {
        this.listAttribute = theList;
        this.nElems = 0;
    }

    public void insert(T value) {
        listAttribute.insertInPosition(nElems, value);
        nElems++;
    }

    // public void mergeSort() {
    // long[] workSpace = new long[nElems];
    // recMergeSort(workSpace, 0, nElems-1);
    // }

    public void sort(int sortAttribute) {
        this.sortAttribute = sortAttribute;
        sortMethod(this.listAttribute);
    }

    private void recMergeSort(DoublyLinkedList<T> auxList, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(auxList, lowerBound, mid);
            recMergeSort(auxList, mid + 1, upperBound);
            merge(auxList, lowerBound, mid + 1, upperBound, this.sortAttribute);
        }
    }

    private void merge(DoublyLinkedList<T> auxList, int lowPtr, int highPtr, int upperBound, int sortAttribute) {
        int j = 0; // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int numItems = upperBound - lowerBound + 1;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (compare(auxList.searchItemPosition(lowPtr), auxList.searchItemPosition(highPtr), sortAttribute) < 0) {
                auxList.insertInPosition(j++, this.listAttribute.searchItemPosition(lowPtr++));
            } else {
                auxList.insertInPosition(j++, this.listAttribute.searchItemPosition(highPtr++));
            }
        }

        while (lowPtr <= mid) {
            auxList.insertInPosition(j++, this.listAttribute.searchItemPosition(lowPtr++));
        }

        while (highPtr <= upperBound) {
            auxList.insertInPosition(j++, this.listAttribute.searchItemPosition(highPtr++));
        }

        for (int i = 0; i < numItems; i++) {
            this.listAttribute.insertInPosition(lowerBound + i, auxList.searchItemPosition(i));
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

    public DoublyLinkedList<T> getListAttribute(){
        return this.listAttribute;
    }

    // DESDE AQUI SE INTENTA IMPLEMENTAR OTRA FORMA DE MERGE SORT
    public void sortMethod(DoublyLinkedList<T> theList){
        if (theList.sizeList() > 1) {
            int middle = theList.sizeList() / 2;
            DoublyLinkedList<T> leftHalf = theList.sublist(0, middle);
            DoublyLinkedList<T> rightHalf = theList.sublist(middle, theList.sizeList());
            sortMethod(leftHalf);
            sortMethod(rightHalf);
            merge(leftHalf, rightHalf, theList);
        }
    }

    public void merge(DoublyLinkedList<T> leftHalf, DoublyLinkedList<T> rightHalft, DoublyLinkedList<T> list){
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftHalf.sizeList() && j < rightHalft.sizeList()) {
            if (compare(leftHalf.searchItemPosition(i), rightHalft.searchItemPosition(j), this.sortAttribute) < 0) {
                list.insertInPosition(k, leftHalf.searchItemPosition(i));
                i++;
            } else {
                list.insertInPosition(k, rightHalft.searchItemPosition(j));
                j++;
            }

            k++;
        }

        while (i < leftHalf.sizeList()) {
            list.insertInPosition(k, leftHalf.searchItemPosition(i));
            i++;
            k++;
        }

        while (j < rightHalft.sizeList()) {
            list.insertInPosition(k, leftHalf.searchItemPosition(j));
            j++;
            k++;
        }
    }
}