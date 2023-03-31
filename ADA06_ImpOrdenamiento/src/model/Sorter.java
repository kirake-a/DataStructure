package model;

import model.sortingMethods.BinaryInsertionSort;
import model.sortingMethods.MergeSort;
import model.sortingMethods.QuickSort;

/**
 * Encargado de realizar las llamadas a las funciones que
 * realizan los ordenamiento del dataset que llega en forma de
 * una lista doblemente ligada
 * 
 * @author Monica Garcilazo
 * @author Ruben Alvarado
 * @version 31/03/2023
 * @see DoublyLinkedList
 * @see MergeSort
 * @see QuickSort
 * @see BinaryInsertionSort
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

    /**
     * Constructor por defecto para generar instancias
     */
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

    /**
     * Despliega la lista del argumento en forma descendente
     * 
     * @param auxList Lista a mostrar
     */
    public void printListDesc(DoublyLinkedList<Country> auxList) {
        DoublyLink<Country> current = auxList.getLast();
        while (current != null) {
            System.out.println(current.getdData().getCountryName());
            current = current.getPrevious();
        }
    }

    /**
     * Despliega la lista del argumento en forma ascendente
     * 
     * @param auxList Lista a mostrar
     */
    public void printListAsc(DoublyLinkedList<Country> auxList) {
        DoublyLink<Country> current = auxList.getFirst();
        while (current != null) {
            System.out.println(current.getdData().getCountryName());
            current = current.getNext();
        }
    }

    /**
     * Tiempo de ejecucion del metodo de ordenamiento
     * {@code Quick Sort}
     * 
     * @return Tiempo total de ejecucion en nanosegundo
     * @see QuickSort
     */
    public long getTiempoEjecucionQuick() {
        return tiempoEjecucionQuick;
    }

    /**
     * Tiempo de ejecucion del metodo de ordenamiento
     * {@code Binary Insertion Sort}
     * 
     * @return Tiempo total de ejecucion en nanosegundo
     * @see BinaryInsertionSort
     */
    public long getTiempoEjecucionBinary() {
        return tiempoEjecucionBinary;
    }

    /**
     * Tiempo de ejecucion del metodo de ordenamiento
     * {@code Merge Sort}
     * 
     * @return Tiempo total de ejecucion en nanosegundo
     * @see MergeSort
     */
    public long getTiempoEjecucionMerge() {
        return tiempoEjecucionMerge;
    }

    /**
     * Numero de comparaciones dadas al implementar
     * el metodo de ordenamiento {@code Quick Sort}
     * 
     * @return Numero total de comparaciones
     * @see QuickSort
     */
    public int getNumComparacionesQuick() {
        return numComparacionesQuick;
    }

    /**
     * Numero de comparaciones dadas al implementar
     * el metodo de ordenamiento {@code Binary Insertion Sort
     * @return Numero total de comparaciones
     * 
     * @see BinaryInsertionSort
     */
    public int getNumComparacionesBinary() {
        return numComparacionesBinary;
    }

    /**
     * Numero de comparaciones dadas al implementar
     * el metodo de ordenamiento {@code Merge Sort}
     * 
     * @see MergeSort
     * @return Numero total de comparaciones
     */
    public int getNumComparacionesMerge() {
        return numComparacionesMerge;
    }

    /**
     * Numero de intercambios realizados
     * el implementar la funcion {@code Quick Sort}
     * 
     * @return Numero de intercambios
     * @see QuickSort
     */
    public int getNumIntercambiosQuick() {
        return numIntercambiosQuick;
    }

    /**
     * Numero de intercambios realizados
     * el implementar la funcion {@code Binary Insertio Sort}
     * 
     * @return Numero de intercambios
     * @see BinaryInsertiionSort
     */
    public int getNumIntercambiosBinary() {
        return numIntercambiosBinary;
    }

    /**
     * Numero de intercambios realizados
     * el implementar la funcion {@code Merge Sort}
     * 
     * @return Numero de intercambios
     * @see MergeSort
     */
    public int getNumIntercambiosMerge() {
        return numIntercambiosMerge;
    }

}
