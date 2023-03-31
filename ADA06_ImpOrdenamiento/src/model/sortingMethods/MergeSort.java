package model.sortingMethods;

import model.Country;
import model.DoublyLink;
import model.DoublyLinkedList;

/**
 * Implementa el metodo de ordenamiento Merge Sort
 * haciendo uso de listas doblemente ligadas.
 * 
 * @author Monica Garcilazo
 * @author Ruben Alvarado
 * @version 31/03/2023
 * @see DoublyLinkedList
 */
public class MergeSort<T> {
    private DoublyLinkedList<T> list;
    private int sortAttribute;
    private long time;
    private int comparacion;
    private int intercambios;

    /**
     * Inicializa un nuevo {@code MergeSort} con una
     * {@code DoublyLinkedList<T>}.
     * 
     * @param list Lista que se integra a la clase para operarse.
     */
    public MergeSort(DoublyLinkedList<T> list) {
        this.list = list;
    }

    private DoublyLinkedList<T> mergeSort(DoublyLinkedList<T> list) {
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

    private DoublyLinkedList<T> merge(DoublyLinkedList<T> left, DoublyLinkedList<T> right) {
        DoublyLinkedList<T> result = new DoublyLinkedList<>();
        DoublyLink<T> leftNode = left.getFirst();
        DoublyLink<T> rightNode = right.getFirst();

        while ((leftNode != null) && (rightNode != null)) {
            if (compare(leftNode.getdData(), rightNode.getdData(), sortAttribute) <= 0) {
                result.insertLast(leftNode.getdData());
                leftNode = leftNode.getNext();
                intercambios++;
            } else {
                result.insertLast(rightNode.getdData());
                rightNode = rightNode.getNext();
                intercambios++;
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

    /**
     * Inicia el proceso de ordenamiento de la lista dada en el argumento del
     * constructor de la clase
     * {@code MergeSort}.
     * 
     * @param sortAttribute Variable que identifica el atributo por el cual la lista
     *                      {@code list} se ordena.
     * @return Lista resultante del proceso de ordenamiento.
     * @see DoublyLinkedList
     */
    public DoublyLinkedList<T> sort(int sortAttribute) {
        long inicio = System.nanoTime();
        this.sortAttribute = sortAttribute;
        DoublyLinkedList<T> theResult = mergeSort(this.list);
        long finall = System.nanoTime();
        time = (finall - inicio);

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

    /**
     * Tiempo total en el que el algoritmo de
     * ordenamiento realizo el proceso completo
     * 
     * @return Tiempo total
     */
    public long getTime() {
        return time;
    }

    /**
     * Numero de comparaciones totales generadas
     * al realizar el proceso de ordenamiento
     * 
     * @return Comparaciones totales
     */
    public int getComparacion() {
        return comparacion;
    }

    /**
     * Numero de intercambios totales generados
     * al realiza el proceso de ordenamiento
     * 
     * @return Intercambios totales
     */
    public int getIntercambios() {
        return intercambios;
    }

}