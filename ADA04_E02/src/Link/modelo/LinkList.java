package Link.modelo;

import Link.nodo.Link;

/**
 * Crea una lista generica simplemente ligada, con un primer nodo en estado de
 * nulo
 * 
 * @author Ruben Alvarado
 * @author Monica Garcilazo
 * @version 21/02/2023
 */
public class LinkList<T> {
    private Link<T> first;
    T data;

    /**
     * Constructor para la clase, con un primer nodo (first) con
     * valores en null
     */
    public LinkList() {
        first = null;
    }

    /**
     * Permite verificar si el objeto LinkList esta vacio
     * @return true si la lista esta vacia, sino false
     */
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * Crea un nuevo nodo y lo inserta al inicio de la LinkList
     * @param datum El dato que contendra el nuevo nodo
     */
    public void insertFirst(T datum) {
        Link<T> newLink = new Link<T>(datum);
        // newLink.next = first;
        newLink.setNext(first);
        first = newLink;
    }

    /**
     * Inserta un nuevo nodo al final de la lista
     * @param datum Valor del nodo
     */
    public void insertLast(T datum) {
        Link<T> current = first;

        while (current != null) {
            if (current.getNext() == null) {
                Link<T> newLink = new Link<T>(datum);
                newLink.setNext(null);
                current.setNext(newLink);
                break;
            } else {
                current = current.getNext();
            }
        }
    }

    /**
     * Inserta un dato de manera ordenada a la lista, dado un parametro entero para
     * realizar la insersion, si la lista estuviera vacia el dato unicamente se
     * inserta en la lista para poder inicializarla
     * @param data  Valor del dato que tendra el nodo que se quiere insertar
     * @param order Valor entero por el cual se decide como se inserta el valor a la
     *              lista.
     *              0. Insertar de manera ascendente. 1. Insertar de manera
     *              descendente
     */
    public  void insertInOrder(int order, T data) {

        if (!((order == 0) || (order == 1))) {
            System.out.println("Esta opcion de ordenamiento no existe");
            return;

        } else {
            
            if (!isEmpty()) {
                Link<T> current = first;
                @SuppressWarnings("unchecked") Comparable<Object> firstComparable = (Comparable<Object>) data;
                @SuppressWarnings("unchecked") Comparable<Object> secondComparable = (Comparable<Object>) current.getdData();
                Link<T> newLink = new Link<T>(data);
                Link<T> previous = first;
                switch (order) {
                    case 0:
                        while ((current != null) && (firstComparable.compareTo(secondComparable) > 0)) {
                            previous = current;
                            current = current.getNext();
                        }
                        if (current == first) {
                            insertFirst(data);
                        } else {
                            previous.setNext(newLink);
                            newLink.setNext(current);
                        }
                        break;
                    case 1:
                        while (current != null && (firstComparable).compareTo(secondComparable) < 0) {
                            previous = current;
                            current = current.getNext();
                        }
                        if (current == first) {
                            insertFirst(data);
                        } else {
                            previous.setNext(newLink);
                            newLink.setNext(current);
                        }
                        break;
                }
            } else {
                insertFirst(data);
                return;
            }
        }
    }

    /**
     * Muestra el primer elemento sin eliminarlo
     * @return Primer nodo en la lista, null si no existieran valores en la lista.
     * @see #isEmpty()
     */
    public Link<T> showFirst() {
        if (!isEmpty()) {
            System.out.print("First Link --> ");
            Link<T> current = first;
            current.displayLink();
            System.out.println("");

            return current;
        }
        return null;
    }

    /**
     * Muestra el ultimo elemento sin eliminarlo
     * @return Ultimo nodo, null si la lista estaba vacia
     * @see #isEmpty()
     */
    public Link<T> showLast() {
        if (!isEmpty()) {
            System.out.print("Last Link --> ");
            Link<T> current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.displayLink();
            System.out.println("");

            return current;
        }
        return null;
    }

    /**
     * Nos devuelve el tamanio de la lista
     * @return El tamanio de la lista
     */
    public int sizeList() {
        int cont = 0;
        Link<T> current = first;
        while (current != null) {
            cont++;
            current = current.getNext();
        }
        return cont;
    }

    /**
     * Hace una busqueda de un elemento y devuelve -1 si no lo encontro y la
     * posicion del dato en la lista en caso de que se haya encontrado.
     * @param datum El dato que se busca
     * @return La posicion del nodo, si no existe -1
     */
    public int searchItem(T datum) {
        int cont = 0;
        Link<T> current = first;
        while (current != null) {
            if (current.getdData().equals(datum)) {
                System.out.println("Position--> " + cont);
                current = null;
                return cont;
            } else {
                current = current.getNext();
                cont++;
            }

        }
        System.out.println("Elemento no encontrado, -1");
        return -1;
    }

    /**
     * Actualiza el dato de un nodo, proporcionando el valor previo al
     * que se quiere actualizar y el valor a actualizar.
     * @param previousValue Valor previo al que se quiere actualizar
     * @param newValue      Nuevo valor
     */
    public void updateWithPrevNode(T previousValue, T newValue) {

        if (!isEmpty()) {
            Link<T> current = first;

            while (current != null) {

                if (current.getdData().equals(previousValue)) {
                    current.getNext().setdData(newValue);
                    break;
                } else {
                    current = current.getNext();
                }
            }

        }
    }

    /**
     * Actualiza el dato de un nodo proporcionando su valor actual y el
     * valor con el que se quiere actualizar
     * @param oldValue Valor anterior
     * @param newVelue Valor a actualizar
     */
    public void updateNode(T oldValue, T newVelue) {
        if (!isEmpty()) {
            Link<T> current = first;

            while (current != null) {
                if (current.getdData().equals(oldValue)) {
                    current.setdData(newVelue);
                    break;
                } else {
                    current = current.getNext();
                }
            }
        }
    }

    /**
     * Actualiza el dato de un nodo, proporcionando el valor a actualizar y la
     * posición del elemento
     * que se quiere actualizar
     * @param position Posicion del nodo
     * @param newValue Valor a actualizar
     */
    public void updateWithPosition(int position, T newValue) {

        if (!isEmpty()) {
            if (position > this.sizeList()) {
                System.out.println("La posicion sobrepasa el tamanio de la lista");
            } else {
                int cont = 0;
                Link<T> current = first;

                while (current != null) {
                    if (cont == position) {
                        current.setdData(newValue);
                        break;
                    } else {
                        cont++;
                        current = current.getNext();
                    }
                }
            }
        }
    }

    /**
     * Elimina y devuelve el primer elemento de la lista
     * @return Elemento eliminado, null si la lista estaba vacia
     */
    public Link<T> deleteFirst() {
        Link<T> temp = null;
        if (!isEmpty()) {
            temp = first;
            first = first.getNext();
        }
        return temp;
    }

    /**
     * Elimina y devuelve el ultimo elemento de la lista
     * @return Elemento eliminado, null si la lista estaba vacia
     */
    public Link<T> deleteLast() {

        if (!isEmpty()) {
            Link<T> current = first;
            Link<T> temp = null;

            while (current != null) {
                if (current.getNext().getNext() == null) {
                    temp = current.getNext();
                    current.setNext(null);
                    current = null;
                } else
                    current = current.getNext();
            }

            return temp;
        }
        return null;
    }

    /**
     * Elimina un elemento de una posicion en la lista
     * @param position Posicion del nodo
     * @return Elemento eliminado, null si la lista estaba vacia
     */
    public Link<T> deletePosition(int position) {
        if (!isEmpty()) {
            if (position > this.sizeList()) {
                System.out.println("La posicion sobrepasa el tamanio de la lista");
            } else {
                int cont = 0;
                Link<T> temp = null;
                Link<T> current = first;
                if (position == 0) {
                    temp = first;
                    first = first.getNext();
                }
                while (current != null) {
                    if (cont == (position - 1)) {
                        temp = current.getNext();
                        current.setNext(current.getNext().getNext());
                        current = null;
                    } else {
                        cont++;
                        current = current.getNext();
                    }
                }
                return temp;
            }
        }
        return null;
    }

    /**
     * Elimina un elemento proporcionado, mediante su dato
     * @param data Valor del nodo a eliminar
     * @return Elemento eliminado, null si la lista estaba vacia
     */
    public Link<T> deleteItem(T data) {
        if (!isEmpty()) {
            Link<T> current = first;
            Link<T> temp = null;
            if (current.getdData().equals(data)) {
                temp = first;
                first = first.getNext();
            } else {
                while (current.getNext() != null) {
                    if (current.getNext().getdData().equals(data)) {
                        temp = current;
                        current.setNext(current.getNext().getNext());
                        break;
                    } else
                        current = current.getNext();

                }
                return temp;
            }
        }
        return null;
    }

    /**
     * Elimina todos los elementos de la lista
     */
    public void deleteAll() {
        while (first != null) {
            first = first.getNext();
        }
    }

    /**
     * Despliega todos los datos en la lista, mostrando el first y last
     */
    public void displayList() {
        System.out.print("List (first--> ");
        Link<T> current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("<--last)");
    }

}