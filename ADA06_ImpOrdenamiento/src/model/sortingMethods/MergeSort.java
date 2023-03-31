package model.sortingMethods;

import model.Country;
import model.DoublyLinkedList;

public class MergeSort<T> {
    private DoublyLinkedList<T> listAttribute;
    private int nElems; // number of data items
    private int sortAttribute;
    private long tiempo;
    private int comparacion;
    private int intercambios;

    public MergeSort(DoublyLinkedList<T> theList) {
        this.listAttribute = theList;
        this.nElems = theList.sizeList();
    }

    public void sort(int sortAttribute) {
        long inicio = System.nanoTime();
        this.sortAttribute = sortAttribute;
        sortMethod(this.listAttribute);
        long finall = System.nanoTime();
        tiempo = (finall - inicio);
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
    private int compare(Country a, Country b, int sortAttribute) {
        comparacion++;

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

    public DoublyLinkedList<T> getList() {
        return this.listAttribute;
    }

    // DESDE AQUI SE INTENTA IMPLEMENTAR OTRA FORMA DE MERGE SORT
    private void sortMethod(DoublyLinkedList<T> theList) {
        if (theList.sizeList() > 1) {
            int middle = theList.sizeList() / 2;
            DoublyLinkedList<T> leftHalf = theList.sublist(theList, 0, middle);
            DoublyLinkedList<T> rightHalf = theList.sublist(theList, middle, theList.sizeList());

            System.out.println("LeftList: " + leftHalf.sizeList());
            System.out.println("RightList: " + rightHalf.sizeList());
            System.out.println("theList: " + theList.sizeList());

            sortMethod(leftHalf);
            sortMethod(rightHalf);
            merge(leftHalf, rightHalf, theList);
        }
    }

    public void merge(DoublyLinkedList<T> leftHalf, DoublyLinkedList<T> rightHalf, DoublyLinkedList<T> auxList) {
        intercambios++;
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftHalf.sizeList() && j < rightHalf.sizeList()) {
            if (compare((Country) leftHalf.searchItemPosition(i), (Country) rightHalf.searchItemPosition(j),
                    this.sortAttribute) <= 0) {
                auxList.insertInPosition(k, leftHalf.searchItemPosition(i));
                i++;
            } else {
                auxList.insertInPosition(k, rightHalf.searchItemPosition(j));
                j++;
            }

            k++;
        }

        while (i < leftHalf.sizeList()) {
            auxList.insertInPosition(k, leftHalf.searchItemPosition(i));
            i++;
            k++;
        }

        while (j < rightHalf.sizeList()) {
            auxList.insertInPosition(k, leftHalf.searchItemPosition(j));
            j++;
            k++;
        }
    }

    public long getTiempo() {
        return tiempo;
    }

    public int getComparacion() {
        return comparacion;
    }

    public int getIntercambios() {
        return intercambios;
    }

    public DoublyLinkedList<T> sublist(DoublyLinkedList<T> aList, int start, int end) {
        DoublyLinkedList<T> auxList = new DoublyLinkedList<>();
        System.out.println("PrincipalSizeList: " + aList.sizeList());
        System.out.println("Start: " + start);
        System.out.println("End: " + end);
        if ((start < aList.sizeList()) && (end <= aList.sizeList())) {
            int counter = 0;
            System.out.println("ENTREEEEEE");
            while (counter != end) {
                auxList.insertInPosition(counter, aList.searchItemPosition(counter));
                counter++;
            }
        }
        
        return auxList;
    }

}