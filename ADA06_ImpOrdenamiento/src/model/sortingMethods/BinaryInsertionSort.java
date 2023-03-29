package model.sortingMethods;

import model.Country;
import model.DoublyLinkedList;

public class BinaryInsertionSort<T extends Comparable <T>>{

    /**
     * Busqueda binaria dentro de una {@code DoublyLinkedList}
     * @param list Lista doblemente ligada
     * @param item Dato objetivo
     * @param low Posicion inicial de busqueda
     * @param high Posicion final de busqueda
     * @param sortAttribute Selecciona el atributo por el cual se realizara
     *                      comparacion entre los nodos
     * @return Valor de la comparacion
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

    /**
     * Implementacion del metodo de ordenamiento binary insertion sort con
     * listas doblemente ligadas
     * @param list Lista doblemente ligada
     * @param n
     * @param sortAttribute Selecciona el atributo por el cual se realizara
     *                      comparacion entre los nodos
     */
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

    /**
     * Realiza una comparacion entre el tipo de dato {@code a} y el tipo de dato {@code b}, 
     * en funcion de conocer cual de ellos es mas grande o si fuera el caso, conocer si los datos
     * son iguales, para ellos obtendremos que, si el tipo de dato {@code a} es menor al tipo de 
     * dato {@code b} se regresa {@code -1}, si fuera el caso se regresa un {@code 1}, y si ambos
     * datos son iguales entonces se regresa un {@code 0}
     * @param a Primer dato, se comparara con el segundo dato
     * @param b Segundo dato, se comparara con el primer dato
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