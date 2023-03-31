package model.sortingMethods;

import model.Country;
import model.DoublyLink;
import model.DoublyLinkedList;

public class BinaryInsertionSort<T> {
    DoublyLinkedList<T> list;
    private int sortAttribute;
    private long time;
    private int comparaciones;
    private int intercambios;

    public BinaryInsertionSort(DoublyLinkedList<T> list){
        this.list = list;
    }

    public DoublyLinkedList<T> sort(int sortAttribute){
        long inicio = System.nanoTime();
        this.sortAttribute = sortAttribute;
        binaryInsertSort(this.list);
        DoublyLinkedList<T> theResult = this.list;
        long finall = System.nanoTime();
        time = (finall - inicio);

        return theResult;
    }

    private void binaryInsertSort(DoublyLinkedList<T> list) {
        if (list.isEmpty()) {
            return;
        }

        DoublyLink<T> current = list.getFirst().getNext();

        while (current != null) {
            intercambios++;
            int pos = binarySearch(list, current.getPrevious(), current.getdData());

            if (pos != -1) {

                DoublyLink<T> temp = current;
                T tempData = temp.getdData();

                while (temp.getPrevious() != null
                        && compare(tempData, temp.getPrevious().getdData(), this.sortAttribute) < 0) {
                    temp.setdData(temp.getPrevious().getdData());
                    temp = temp.getPrevious();
                }
                temp.setdData(tempData);
            }

            current = current.getNext();
        }
    }

    private int binarySearch(DoublyLinkedList<T> list, DoublyLink<T> last, T key) {
        int left = 0;
        int right = list.sizeList() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            T midVal = list.searchItemPosition(mid);

            int comparation = compare(key, midVal, this.sortAttribute);
            
            if (comparation == 0) {
                return mid;
            } else if (comparation < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
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
        comparaciones++;

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

    public int getComparaciones() {
        return comparaciones;
    }

    public int getIntercambios() {
        return intercambios;
    }

    public int getSortAttribute() {
        return sortAttribute;
    }

    public long getTime() {
        return time;
    }
    
}