package DoublyLinkedList;

/**
 * Lista generica doblemente ligada
 * 
 * @author Monica Garcilazo
 * @author Ruben Alvarado
 * 
 * @version 21/02/2023
 */
public class DoublyLinkedList<T> {
    private DoublyLink<T> first; 
    private DoublyLink<T> last; 
    
    /**
     * Constructor default de la clase
     */
    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    /**
     *  Devuelve true si la lista creada esta vacia
     * @return Si la lista esta vacia
     */
    public boolean isEmpty() {
        return first == null;
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
     * @param dd Valor del nodo 
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
     * @param key Valor del nodo previo al que se quiere insertar
     * @param datum Valor del nodo que se quiere insertar
     * 
     * @return Si se pudo insertar o no
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
            //current.next.previous = newLink;
        }
        newLink.setPrevious(current);
        current.setNext(newLink);
        return true;
    }

    /**
     * Despliega e lprimer elemento del DoublyLink
     * 
     * @return primer nodo
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
     * @return ultimo nodo
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
     * Nos devuelve el tamanio de la lista
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
     *  Hace una búsqueda de un elemento y devuelve -1 si no lo encontró y la posición del dato 
     *  en la lista en caso de que se haya encontrado.
     * 
     * @param datum Dato que se busca
     * 
     * @return Retorna la posicion del nodo, si no existe -1
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
     * Actualiza el dato de un nodo, proporcionando el valor anterior y el valor a actualizar
     * 
     * @param oldDaum Valor anterior
     * @param datum Valor al que se quiere actualizar
     * 
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
     * Actualiza el dato de un nodo, proporcionando el valor a actualizar y la posición del elemento 
     * que se quiere actualizar
     * 
     * @param position POsicion del nodo
     * @param newValue Nuevo valor del nodo
     * 
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
     * Elimina y devuelve el ultimoo valor de la lista
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
     * 
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
     *  Elimina un elemento de una posición en la lista 
     * 
     * @param position Posicion del nodo
     * 
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
     * Elimina todos los nodos de la lista
     */
    public void deleteAll() {
        while (first != null) {
            first = first.getNext();
        }
    }
    
    /**
     * 
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
     * 
     */
    public void displayBackward() {
        System.out.print("List (last-->first): ");
        DoublyLink<T> current = last;
        while(current != null) {
            current.displayLink(); 
            current = current.getPrevious(); 
        }
        System.out.println("");
    }
} 