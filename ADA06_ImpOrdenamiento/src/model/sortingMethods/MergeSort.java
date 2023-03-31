package model.sortingMethods;

import model.Country;
import model.DoublyLink;
import model.DoublyLinkedList;

public class MergeSort<T> {
    private DoublyLinkedList<T> list;
    private int sortAttribute;
    private long tiempo;
    private int comparacion;
    private int intercambios;

    public MergeSort(DoublyLinkedList<T> list) {
        this.list = list;
    }

    public DoublyLinkedList<T> mergeSort(DoublyLinkedList<T> list){
        if (list.sizeList() <= 1) {
            return list;
        }

        DoublyLinkedList<T> leftList = new DoublyLinkedList<>();
        DoublyLinkedList<T> rightList = new DoublyLinkedList<>();
        int middle = list.sizeList() / 2;

        DoublyLink<T> current = list.getFirst();
        int index = 0;

        while (current != null) {
            if (index < middle) {
                leftList.insertLast(current.getdData());
            } else { 
                rightList.insertLast(current.getdData());
            }

            index++;
            current = current.getNext();
        }

        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);

        return merge(leftList, rightList);
    }

    private DoublyLinkedList<T> merge(DoublyLinkedList<T> left, DoublyLinkedList<T> right){
        DoublyLinkedList<T> result = new DoublyLinkedList<>();
        DoublyLink<T> leftNode = left.getFirst();
        DoublyLink<T> rightNode = right.getFirst();

        while ((leftNode != null) && (rightNode != null)) {
            if (compare(leftNode.getdData(), rightNode.getdData(), sortAttribute) <= 0) {
                result.insertLast(leftNode.getdData());
                leftNode = leftNode.getNext();
            } else {
                result.insertLast(rightNode.getdData());
                rightNode = rightNode.getNext();
            }
        }

        while (leftNode != null) {
            result.insertLast(leftNode.getdData());
            leftNode = leftNode.getNext();
        }

        while (rightNode != null) {
            result.insertLast(rightNode.getdData());
            rightNode = rightNode.getNext();
        }

        return result;
    }

    public DoublyLinkedList<T> sort(int sortAttribute) {
        long inicio = System.nanoTime();
        this.sortAttribute = sortAttribute;
        DoublyLinkedList<T> theResult = mergeSort(this.list);
        long finall = System.nanoTime();
        tiempo = (finall - inicio);

        return theResult;
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
        comparacion++;

        Country country1 = (Country) a;
        Country country2 = (Country) b;

        switch (sortAttribute) {

            case 1:

                if (country1.getPopulation() < country2.getPopulation()) {
                    return 1;
                } else if (country1.getPopulation() > country2.getPopulation()) {
                    return -1;
                } else {
                    return 0;
                }
            case 2:
                return country1.getCountryName().compareTo(country2.getCountryName());

            case 3:
                if (country1.getActiveCases() < country2.getActiveCases()) {
                    return 1;
                } else if (country1.getActiveCases() > country2.getActiveCases()) {
                    return -1;
                } else {
                    return 0;
                }

            case 4:
                if (country1.getTotalDeaths() < country2.getTotalDeaths()) {
                    return 1;
                } else if (country1.getTotalDeaths() > country2.getTotalDeaths()) {
                    return -1;
                } else {
                    return 0;
                }

            default:
                return 0;
        }
    }

    public DoublyLinkedList<T> getList() {
        return this.list;
    }

    // DESDE AQUI SE INTENTA IMPLEMENTAR OTRA FORMA DE MERGE SORT
    private void sortMethod(DoublyLinkedList<T> theList) {
        if (theList.sizeList() > 1) {
            int middle = theList.sizeList() / 2;
            DoublyLinkedList<T> leftHalf = theList.sublist(theList, 0, middle);
            DoublyLinkedList<T> rightHalf = theList.sublist(theList, middle, theList.sizeList());

            System.out.println("LeftList: " + leftHalf.sizeList());
            System.out.println("RightList: " + rightHalf.sizeList());

            sortMethod(leftHalf);
            sortMethod(rightHalf);
            merge(leftHalf, rightHalf, theList);
        }
    }

    public void merge(DoublyLinkedList<T> leftHalf, DoublyLinkedList<T> rightHalf, DoublyLinkedList<T> auxList) {
        //intercambios++;
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftHalf.sizeList() && j < rightHalf.sizeList()) {
            if (compare( leftHalf.searchItemPosition(i), rightHalf.searchItemPosition(j),
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

}