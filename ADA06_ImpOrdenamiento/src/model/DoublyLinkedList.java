package model;

import java.util.Collection;
import java.util.LinkedList;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator;

/**
 * Implementacion personalizada de una lista doblemente ligada
 * 
 * @author Monica Garcilazo
 * @author Ruben Alvarado
 * @version 21/02/2023
 */
@SuppressWarnings("unused")
public class DoublyLinkedList<T> {
    private DoublyLink<T> first;
    private DoublyLink<T> last;

    /**
     * Crear a la lista con un first y last en valor null, es decir,
     * sin elementos en su interior como lista.
     */
    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    /**
     * Devuelve true si la lista creada esta vacia, false si no lo esta
     * 
     * @return Si la lista esta vacia
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Regresa el nodo {@code first} dentro de la lista doblemente ligada
     * 
     * @return Nodo first
     */
    public DoublyLink<T> getFirst() {
        return this.first;
    }

    /**
     * Regresa el nodo {@code last} dentro de la lista doblemente ligada
     * 
     * @return Nodo last
     */
    public DoublyLink<T> getLast() {
        return this.last;
    }

    public void insertInPosition(int position, T datum) {
        if (!isEmpty()) {

            if (position > this.sizeList() && position < 0) {
                System.out.println("La posicion sobrepasa el tamanio de la lista");
            } else {
                int counterPosition = 0;
                DoublyLink<T> current = first;

                while (current != null) {
                    if (counterPosition == position) {
                        DoublyLink<T> newLink = new DoublyLink<>(datum);

                        newLink.setNext(current.getNext());
                        newLink.setPrevious(current);
                        current.setNext(newLink);
                        current.getNext().setPrevious(newLink);
                    } else {
                        current = current.getNext();
                        counterPosition++;
                    }
                }
            }
        }
    }

    /**
     * Crea un nuevo nodo y lo inserta al inicio
     * 
     * @param dd El dato que contendra el nuevo nodo
     */
    public void insertFirst(T dd) {
        DoublyLink<T> newLink = new DoublyLink<>(dd);
        if (isEmpty())
            last = newLink;
        else
            first.setPrevious(newLink);
        newLink.setNext(first);
        first = newLink;
    }

    /**
     * Inserta un nuevo nodo al final de la lista
     * 
     * @param dd Valor que tendra el nodo
     */
    public void insertLast(T dd) {
        DoublyLink<T> newLink = new DoublyLink<>(dd);
        if (isEmpty())
            first = newLink;
        else {
            last.setNext(newLink);
            newLink.setPrevious(last);
        }
        last = newLink;
    }

    /**
     * Inserta un nuevo nodo despues de otro
     * 
     * @param key   Valor del nodo previo al que se quiere insertar
     * @param datum Valor del nodo que se quiere insertar
     * @return true si se consiguio insertar, de lo contrario false
     */
    public boolean insertAfter(T key, T datum) {
        DoublyLink<T> current = first;
        while (current.getdData() != key) {
            current = current.getNext();
            if (current == null)
                return false;
        }
        DoublyLink<T> newLink = new DoublyLink<>(datum);
        if (current == last) {
            newLink.setNext(null);
            last = newLink;
        } else {
            newLink.setNext(current.getNext());
            current.getNext().setPrevious(newLink);
            // current.next.previous = newLink;
        }
        newLink.setPrevious(current);
        current.setNext(newLink);
        return true;
    }

    /**
     * Inserta un dato de manera ordenada a la lista, dado un parametro entero para
     * realizar la insersion, si la lista estuviera vacia el dato unicamente se
     * inserta a la lista, de esa forma inicializandola
     * 
     * @param data  Valor del dato que contendra el nodo a insertar
     * @param order valor entero que determina si se inserta de forma
     *              ascendente o descendente
     */
    public void insertInOrder(int order, T data) {
        if (!((order == 0) || (order == 1))) {
            System.out.println("Esta opcion de ordenamiento no existe");
            return;
        } else {
            if (!isEmpty()) {
                DoublyLink<T> newLink = new DoublyLink<T>(data);
                DoublyLink<T> current = first;
                DoublyLink<T> previous = first;
                @SuppressWarnings("unchecked")
                Comparable<Object> firstComparable = (Comparable<Object>) data;
                @SuppressWarnings("unchecked")
                Comparable<Object> secondComparable = (Comparable<Object>) current.getdData();
                switch (order) {
                    case 0:
                        while (current != null && (firstComparable).compareTo(secondComparable) > 0) {
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
     * Despliega el primer elemento del DoublyLink
     * 
     * @return primer nodo, de lo contrario regresa null
     */
    public DoublyLink<T> showFirst() {
        if (!isEmpty()) {
            System.out.print("First DoublyLink --> ");
            DoublyLink<T> current = first;
            current.displayLink();
            System.out.println("");
            return current;
        }
        return null;
    }

    /**
     * Despliega el ultimo elemento del DoublyLink
     * 
     * @return El ultimo nodo, de lo contrario null
     */
    public DoublyLink<T> showLast() {
        if (!isEmpty()) {
            System.out.print("Last DoublyLink --> ");
            DoublyLink<T> current = last;
            current.displayLink();
            System.out.println("");

            return current;
        }
        return null;
    }

    /**
     * Conocer el tamanio de la lista
     * 
     * @return tamanio de la lista
     */
    public int sizeList() {
        int cont = 0;
        DoublyLink<T> current = first;

        while (current != null) {
            cont++;
            current = current.getNext();
        }

        return cont;
    }

    /**
     * Hace una busqueda de un elemento y devuelve -1 si no lo encontro y la
     * posicion del dato en la lista en caso de que se haya encontrado.
     * 
     * @param datum Dato que se busca
     * @return Retorna la posicion del nodo, si no existe retorna -1
     */
    public int searchItem(T datum) {
        int cont = 0;
        DoublyLink<T> current = first;
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
     * Retorna el valor contenido en el nodo en la posicion dada
     * 
     * @param position La posicion en la lista de la cual se requiere obtener el
     *                 valor del nodo
     * @return Objeto contenido en el nodo
     */
    public T searchItemPosition(int position) {
        T data = null;

        if (!isEmpty()) {
            if (position > this.sizeList() && position < 0) {
                System.out.println("La posicion sobrepasa el tamanio de la lista");
            } else {
                int counter = 0;
                DoublyLink<T> current = this.first;

                while (current != null) {
                    if (counter == position) {
                        data = current.getdData();
                        break;
                    } else {
                        counter++;
                        current = current.getNext();
                    }
                }
            }
        }

        return data;
    }

    /**
     * Actualiza el dato de un nodo, proporcionando el valor actual y el valor
     * con el que se quiere actualizar el nodo
     * 
     * @param oldDaum Valor anterior
     * @param datum   Valor al que se quiere actualizar
     */
    public void updateNode(T oldDaum, T datum) {
        if (!isEmpty()) {
            DoublyLink<T> current = first;

            while (current != null) {
                if (current.getdData().equals(oldDaum)) {
                    current.setdData(datum);
                    break;
                } else
                    current = current.getNext();
            }
        }
    }

    /**
     * Intercambia los valores entre dos nodos dados sus posiciones dentro de la
     * lista
     * 
     * @param position1 La posicion del primero nodo
     * @param position2 La posicion del segundo nodo
     */
    public void changeValuePositions(int position1, int position2) {
        if (!isEmpty()) {
            if ((position1 > this.sizeList()) | (position2 > this.sizeList())) {
                System.out.println("La posicion sobrepasa el tamanio de la lista");
            } else {
                T data1 = this.searchItemPosition(position1);
                T data2 = this.searchItemPosition(position2);

                this.updateNode(data1, data2);
                this.updateNode(data2, data1);
            }
        }
    }

    /**
     * Actualiza el dato de un nodo, proporcionando el valor a actualizar y la
     * posicion del elemento que se quiere actualizar. Siempre y cuando la lista no
     * sea una lista vacia
     * 
     * @param position Posicion del nodo
     * @param newValue Nuevo valor del nodo
     * @see #isEmpty()
     */
    public void updateWithPosition(int position, T newValue) {
        if (!isEmpty()) {
            if (position > this.sizeList()) {
                System.out.println("La posicion sobrepasa el tamanio de la lista");
            } else {
                int counter = 0;
                DoublyLink<T> current = first;
                while (current != null) {
                    if (counter == position) {
                        current.setdData(newValue);
                        break;
                    } else {
                        counter++;
                        current = current.getNext();
                    }
                }
            }

        }

    }

    /**
     * Regresa una lista derivada de la lista original dado un intervalo de
     * la lista original para con ello obtener a todos esos nodos, en el intervalo.
     * 
     * @param start Posicion de inicio de la sublista
     * @param end   Posicion de finalizado de la lista. Tomar en cuenta que el nodo
     *              en
     *              la posicion {@code end} no se agrega a la sublista
     * @return Sublista de la original en los intervalores recibidos
     */
    public DoublyLinkedList<T> sublist(DoublyLinkedList<T> aList, int start, int end) {
        if (start < 0 || start > aList.sizeList() - 1 || end < 0 || end > aList.sizeList() || start > end) {
            throw new IndexOutOfBoundsException();
        }

        DoublyLinkedList<T> subList = new DoublyLinkedList<T>();
        DoublyLink<T> current = aList.getFirst();
        int index = 0;

        while (index < start) {
            current = current.getNext();
            index++;
        }

        while (index < end) {
            subList.insertLast(current.getdData());
            current = current.getNext();
            index++;
        }

        return subList;
    }

    /**
     * Unifica la lista actual con la lista del argumento.
     * Agrega la lista del argumento en su mismo orden al final
     * de la lista actual.
     * 
     * @param listJoin Lista que se anexara al final
     */
    public void mergeList(DoublyLinkedList<T> listJoin) {
        int counterPosition = 0;
        int listSize = listJoin.sizeList();

        while (counterPosition != listSize) {
            this.insertLast(listJoin.searchItemPosition(counterPosition));
            counterPosition++;
        }
    }

    /**
     * Elimina y devuelve el primer valor de la lista
     * 
     * @return Elemento eliminado
     */
    public DoublyLink<T> deleteFirst() {
        DoublyLink<T> temp = first;
        if (first.getNext() == null)
            last = null;
        else
            first.getNext().setPrevious(null);
        first = first.getNext();
        return temp;
    }

    /**
     * Elimina y devuelve el ultimo valor en la lista
     * 
     * @return Elemento eliminado
     */
    public DoublyLink<T> deleteLast() {
        DoublyLink<T> temp = last;
        if (first.getNext() == null)
            first = null;
        else
            last.getPrevious().setNext(null);
        last = last.getPrevious();
        return temp;
    }

    /**
     * Elimina y devuelve un nodo de la lista
     * 
     * @param key Valor del nodo
     * @return Nodo eliminado
     */
    public DoublyLink<T> deleteKey(T key) {
        DoublyLink<T> current = first;
        while (current.getdData() != key) {
            current = current.getNext();
            if (current == null)
                return null;
        }
        if (current == first)
            first = current.getNext();
        else
            current.getPrevious().setNext(current.getNext());
        if (current == last)
            last = current.getPrevious();
        else
            current.getNext().setPrevious(current.getPrevious());
        return current;
    }

    /**
     * Elimina un elemento en la lista, dada su posicion.
     * Unicamente si la lista no esta vacia
     * 
     * @param position Posicion del nodo
     * @see #isEmpty()
     * @return Valor eliminado
     */
    public DoublyLink<T> deletePosition(int position) {
        DoublyLink<T> current = first;
        if (isEmpty()) {
            if (position == 0) {
                first = current.getNext();
            }
            for (int i = 0; current != null && i < position - 1; i++) {
                current = current.getNext();
            }
            if (current == null || current.getNext() == null) {
                return current;
            }
            current.setNext(current.getNext().getNext());
            return current;
        }
        return null;
    }

    /**
     * Convierte una lista de tipo {@code DoublyLinkedList} a una lista
     * de tipo {@code LinkedList}
     * 
     * @return Lista derivada de la clase {@code LinkedList}
     * @see LinkedList
     */
    public LinkedList<T> fromDoublyLinkedListToLinkedList() {
        LinkedList<T> newList = new LinkedList<>();

        if (!isEmpty()) {
            DoublyLink<T> current = first;
            while (current != null) {
                newList.add(current.getdData());
            }
        }
        return newList;
    }

    /**
     * Elimina todos los nodos contenido en la lista
     */
    public void deleteAll() {
        while (first != null) {
            first = first.getNext();
        }
    }

    /**
     * Despliega los datos de la lista tomando como inicio el nodo
     * first de la lista
     */
    public void displayForward() {
        System.out.print("List (first-->last): ");
        DoublyLink<T> current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("");
    }

    /**
     * Despliega los datos de la lista tomando como inicio el nodo
     * last de la lista
     */
    public void displayBackward() {
        System.out.print("List (last-->first): ");
        DoublyLink<T> current = last;
        while (current != null) {
            current.displayLink();
            current = current.getPrevious();
        }
        System.out.println("");
    }

    public void setFirst(DoublyLink<T> first){
        this.first = first;
    }

}