package model.sortingMethods;

import model.Country;
import model.DoublyLink;
import model.DoublyLinkedList;

public class QuickSort<T extends Comparable<T>> {

    public void sort(DoublyLinkedList<T> list, int sortingAttribute) {
        if (list == null || list.isEmpty()) {
            return;
        }
        quicksort(list.getFirst(), list.getLast(), sortingAttribute);
    }

    private void quicksort(DoublyLink<T> left, DoublyLink<T> right, int sortingAttribute) {
        if (left == null || right == null || left == right || left.getPrevious() == right) {
            return;
        }

        DoublyLink<T> pivot = partition(left, right, sortingAttribute);
        quicksort(left, pivot.getPrevious(), sortingAttribute);
        quicksort(pivot.getNext(), right, sortingAttribute);
    }

    private DoublyLink<T> partition(DoublyLink<T> left, DoublyLink<T> right, int sortingAttribute) {
        DoublyLink<T> pivot = right;
        DoublyLink<T> i = left.getPrevious();

        for (DoublyLink<T> j = left; j != right; j = j.getNext()) {
            if (compare(j.getdData(), pivot.getdData(), sortingAttribute) > 0) {
                i = (i == null) ? left : i.getNext();
                swap(i, j);
            }
        }

        i = (i == null) ? left : i.getNext();
        swap(i, right);
        return i;
    }

    private void swap(DoublyLink<T> a, DoublyLink<T> b) {
        T temp = a.getdData();
        a.setdData(b.getdData());
        b.setdData(temp);
    }

    private int compare(T a, T b, int sortAttribute) {

        Country country1 = (Country) a;
        Country country2 = (Country) b;

        switch (sortAttribute) {

            case 1:

                if (country1.getPopulation() > country2.getPopulation()) {
                    return -1;
                } else if (country1.getPopulation() < country2.getPopulation()) {
                    return 1;
                } else {
                    return 0;
                }
            case 2:
                return country1.getCountryName().compareTo(country2.getCountryName());

            case 3:
                if (country1.getActiveCases() > country2.getActiveCases()) {
                    return -1;
                } else if (country1.getActiveCases() < country2.getActiveCases()) {
                    return 1;
                } else {
                    return 0;
                }

            case 4:
                if (country1.getTotalDeaths() > country2.getTotalDeaths()) {
                    return -1;
                } else if (country1.getTotalDeaths() < country2.getTotalDeaths()) {
                    return 1;
                } else {
                    return 0;
                }

            default:
                return 0;
        }
    }
}
