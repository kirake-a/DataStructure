package model;

import model.sortingMethods.BinaryInsertionSort;
import model.sortingMethods.MergeSort;
import model.sortingMethods.QuickSort;

/*
 * Este metodo es que el esta encargado de llamar al
 * metodo de ordenamiento que sea requerido.
 * Considerar si se necesitaran excepciones para las llamadas
 * y si sera excepciones propias o ya de java
 */
public class Sorter {
    private long tiempoEjecucionQuick = 0;
    private long tiempoEjecucionBinary = 0;
    private long tiempoEjecucionMerge = 0;

    private int numComparacionesQuick = 0;
    private int numComparacionesBinary = 0;
    private int numComparacionesMerge = 0;

    private int numIntercambiosQuick = 0;
    private int numIntercambiosBinary = 0;
    private int numIntercambiosMerge = 0;

    public Sorter() {
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
    public DoublyLinkedList<Country> sorting(int key, int sortAttribute, DoublyLinkedList<Country> auxList)
            throws Exception {
        /*
         * Escoge el metodo de ordenamiento de la lista, en teoria esta
         * clase debera devolver la lista ordenada para su futuro procesamiento
         */
        switch (key) {
            // Ordenamiento Quick Sort
            case 0:
                QuickSort<Country> quickOperator = new QuickSort<>(auxList);
                quickOperator.sort(sortAttribute);
                auxList = quickOperator.getList();
                this.tiempoEjecucionQuick = quickOperator.getTiempo();
                System.out.println(tiempoEjecucionQuick);
                this.numComparacionesQuick = quickOperator.getComparaciones();
                System.out.println(numComparacionesQuick);
                this.numIntercambiosQuick = quickOperator.getIntercambios();
                System.out.println(numIntercambiosQuick);
                return auxList;
            // Ordenamiento Merge Sort
            case 1:
                MergeSort<Country> mergeOperator = new MergeSort<Country>(auxList);
                auxList = mergeOperator.sort(sortAttribute);
                this.tiempoEjecucionMerge = mergeOperator.getTime();
                this.numComparacionesMerge = mergeOperator.getComparacion();
                this.numIntercambiosMerge = mergeOperator.getIntercambios();
                System.out.println(tiempoEjecucionMerge);
                System.out.println(numComparacionesMerge);
                System.out.println(numIntercambiosMerge);
                return auxList;
            // Ordenamiento Binary Insertion Sort
            case 2:
                BinaryInsertionSort<Country> binaryOperator = new BinaryInsertionSort<Country>(auxList);
                DoublyLinkedList<Country> theResult = binaryOperator.sort(sortAttribute);
                this.tiempoEjecucionBinary = binaryOperator.getTime();
                this.numComparacionesBinary = binaryOperator.getComparaciones();
                this.numIntercambiosBinary = binaryOperator.getIntercambios();
                System.out.println(tiempoEjecucionBinary);
                System.out.println(numComparacionesBinary);
                System.out.println(numIntercambiosBinary);
                return theResult;
            default:
                throw new Exception();
        }
    }

    public void printListDesc(DoublyLinkedList<Country> auxList){
        DoublyLink<Country> current = auxList.getLast();
        while (current != null) {
            System.out.println(current.getdData().getCountryName());
            current = current.getPrevious();
        }
    }

    public void printListAsc(DoublyLinkedList<Country> auxList){
        DoublyLink<Country> current = auxList.getFirst();
        while (current != null) {
            System.out.println(current.getdData().getCountryName());
            current = current.getNext();
        }
    }

    public long getTiempoEjecucionQuick() {
        return tiempoEjecucionQuick;
    }

    public long getTiempoEjecucionBinary() {
        return tiempoEjecucionBinary;
    }

    public long getTiempoEjecucionMerge() {
        return tiempoEjecucionMerge;
    }

    public int getNumComparacionesQuick() {
        return numComparacionesQuick;
    }

    public int getNumComparacionesBinary() {
        return numComparacionesBinary;
    }

    public int getNumComparacionesMerge() {
        return numComparacionesMerge;
    }

    public int getNumIntercambiosQuick() {
        return numIntercambiosQuick;
    }

    public int getNumIntercambiosBinary() {
        return numIntercambiosBinary;
    }

    public int getNumIntercambiosMerge() {
        return numIntercambiosMerge;
    }
    
}
