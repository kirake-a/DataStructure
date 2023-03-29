package model;

import model.sortingMethods.BinaryInsertionSort;
import model.sortingMethods.MergeSort;
import model.sortingMethods.QuickSort;
import model.sortingMethods.RadixSort;

/*
 * Este metodo es que el esta encargado de llamar al
 * metodo de ordenamiento que sea requerido.
 * Considerar si se necesitaran excepciones para las llamadas
 * y si sera excepciones propias o ya de java
 */
public class Sorter {
    private DoublyLinkedList<Country> list;

    public Sorter(){}

    public Sorter(DoublyLinkedList<Country> list) {
        this.list = list;
    }

    /**
     * Ordena la lista dada previamente en el constructor del objeto, segun el
     * metodo de ordenamiento
     * seleccionado por la key dada en el argumento.
     * 
     * @param key Selecciona el tipo de algoritmo a usar para ordenar la lista de
     *            datos.
     * @throws Exception El digito de la variable key no es un metodo de
     *                   ordenamiento
     */
    public DoublyLinkedList<Country> sorting(int key, int sortingAttribute) throws Exception {
        /*
         * Escoge el metodo de ordenamiento de la lista, en teoria esta
         * clase debera devolver la lista ordenada para su futuro procesamiento
         */
        switch (key) {
            // Ordenamiento Quick Sort
            case 0:
                QuickSort<Country> quickOperator = new QuickSort<>(this.list);
                quickOperator.sort(sortingAttribute);
                this.list = quickOperator.getList();
                return this.list;
            // Ordenamiento Merge Sort
            case 1:
                MergeSort<Country> mergeOoperator = new MergeSort<>(this.list);
                mergeOoperator.sort(sortingAttribute);
                this.list = mergeOoperator.getList();
                return this.list;
            // Ordenamiento Binary Insertion Sort
            case 2:
                BinaryInsertionSort<Country> binaryOperator = new BinaryInsertionSort<>(this.list);
                binaryOperator.sort(sortingAttribute);
                this.list = binaryOperator.getList();
                return this.list;
            // Ordenamiento Radix Sort
            case 3: // NO ESTA IMPLEMENTADO TODAVIA
                RadixSort<Country> radixOperator = new RadixSort<>(this.list);
                radixOperator.sort(sortingAttribute);
                this.list = radixOperator.getList();
                return this.list;
            default:
                throw new Exception();
        }
    }

    /**
     * 
     * Ordena la lista dada previamente en el constructor del objeto, segun el
     * metodo de ordenamiento
     * seleccionado por la key dada en el argumento.
     * 
     * @param key  Selecciona el tipo de algoritmo a usar para ordenar la lista de
     *             datos
     * @param list La lista doblemente ligada que se quiere ordenar
     * @throws Exception El digito de la variable key no es un metodo de
     *                   ordenamiento
     */
    public void sorting(int key, int sortAttribute, DoublyLinkedList<Country> list) throws Exception {
        /*
         * Escoge el metodo de ordenamiento de la lista, en teoria esta
         * clase debera devolver la lista ordenada para su futuro procesamiento
         */
        switch (key) {
            case 0:

                break;

            default:
                throw new Exception();
        }
    }

}
