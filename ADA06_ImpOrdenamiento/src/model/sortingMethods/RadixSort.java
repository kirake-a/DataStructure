package model.sortingMethods;

// Radix sort Java implementation
//import java.io.*;
import java.util.*;

import model.Country;
import model.DoublyLink;
import model.DoublyLinkedList;

public class RadixSort<T> {
	private DoublyLinkedList<T> theList;
	private int comparaciones = 0;
	private int intercambios;
	private long tiempo;
	private int sortAttribute;

	public RadixSort(DoublyLinkedList<T> list){
		this.theList = list;
	}

	public void sorter(int sortAttribute){
		this.sortAttribute = sortAttribute;
		DoublyLinkedList<T> result;
	}

	private void radixSort(DoublyLinkedList<T> list){
		if (list.isEmpty() || list.sizeList() == 1) {
			return; // Ordered list
		}

		int digitos = getMaxdigits(list);
	}

	private int getMaxdigits(DoublyLinkedList<T> list){
		int max = Integer.MIN_VALUE;
		DoublyLink<T> current = list.getFirst();

		while (current != null) {
			T data = current.getdData();
			int digits = getAmountDigits(data);

		}
	}

	@SuppressWarnings("unchecked")
	private int getAmountDigits(T data){
		int digits = 0;

		while (compare(data, (T)Integer.valueOf(0), this.sortAttribute) > 0) {
			data = (T) Integer.valueOf(data.intValue() / 10);
			digits++;
		}

		return digits;
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

	public long getTiempo() {
		return tiempo;
	}

	
}
