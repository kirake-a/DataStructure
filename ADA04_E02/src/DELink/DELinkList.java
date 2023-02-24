package DELink;

/**
 * Lista generica simplemente ligada que usa un 
 * apuntador first y uno last para indicar topes
 * por ambos lados
 * 
 * @author Monica Garcilazo
 * @author Ruben Alvarado
 * 
 * @version 21/02/2023
 */
class DELinkList<T> {
    private DELink<T> first;
    private DELink<T> last;
    
    /**
     * Constructor de la clase
     */
    public DELinkList() {
        first = null;
        last = null;
    }

    /**
     * 
     * @return true si la lista esta vacia
     */
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * Crea un nuevo nodo y lo inserta al inicio de la lista
     * 
     * @param datum El valor que contendra el nodo
     */
    public void insertFirst(T datum) {
        DELink<T> newLink = new DELink<>(datum);
        if (isEmpty())
            last = newLink;
        newLink.setNext(first); 
        first = newLink;
    }

    /**
     * Crea un nuevo nodo y lo inserta al final de la lista
     * 
     * @param datum El dato que contendra el nodo
     */
    public void insertLast(T datum) {
        DELink<T> newLink = new DELink<>(datum);
        if (isEmpty())
            first = newLink;
        else
            last.setNext(newLink);;
        last = newLink;
    }

    /**
     * Muesta al primer elemento de la lista si es que
     * la lista no esta vacia
     * 
     * @return Primer nodo
     */
    public DELink<T> showFirst() {
        if (!isEmpty()) {
            System.out.print("First DELink --> ");
            DELink<T> current = first;
            current.displayLink();
            System.out.println("");

            return current;
        }
        return null;
    }

    /**
     * Muestra al ultimo elemento de la lista si es que
     * la lista no esta vacia
     * 
     * @return Ultimo nodo
     */
    public DELink<T> showLast() {
        if (!isEmpty()) {
            System.out.print("Last DELink --> ");
            DELink<T> current = last;
            current.displayLink();
            System.out.println("");

            return current;
        }
        return null;
    }

    /**
     * Regresa el tamanio de la lista
     * 
     * @return Tamanio de la lista
     */
    public int sizeList() {
        int cont = 0;
        DELink<T> current = first;
        while (current != null) {
            cont++;
            current = current.getNext();
        }
        return cont;
    }
    
    /**
     * Hace una búsqueda de un elemento y devuelve -1 si no lo encontró y la posición del dato 
     *  en la lista en caso de que se haya encontrado.
     * 
     * @param datum Dato que se busca
     * 
     * @return Retorna la posicion del nodo, sino existe -1
     */
    public int searchItem(T datum) {
        int counter = 0;

        if (!isEmpty()) {
            DELink<T> current = first;

            while (current != null) {
                if (current.getdData().equals(datum)) {
                    return counter;
                } else {
                    current = current.getNext();
                    counter++;
                }
            }

        }

        return -1;
    }
    
    /**
     * Actualizael valor(dato) de un nodo, dado su valor previo
     * 
     * @param oldValue El dato que se busca en la lista
     * @param newVelue Dato que sustituira al valor oldValue
     * 
     */
    public void updateNode(T oldValue, T newVelue) {
        if (!isEmpty()) {
            DELink<T> current = first;

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
     * Actualiza el dato de un nodo, proporcionado el valor previo al
     * que se quiere actualizar y el valor a actualizar
     * 
     * @param previousValue Valor del nodo previo al que se quiere actualizar
     * @param newValue Nuevo valor en el nodo
     */
    public void updateWithPrevNode(T previousValue, T newValue) {

        if (!isEmpty()) {
            DELink<T> current = first;

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
     * Actualiza el dato de un nodo, proporcionando el valor a actualizar y 
     * la posición del elemento que se quiere actualizar
     * 
     * @param position Posicion del nodo
     * @param newValue Valor a actualizar
     * 
     */
    public void updateWithPosition(int position, T newValue) {

        if (!isEmpty()) {
            if (position > this.sizeList()) {
                System.out.println("La posicion sobrepasa el tamanio de la lista");
            } else {
                int cont = 0;
                DELink<T> current = first;

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
     * Elimina el primer elemento de la lista
     * 
     * @return Elemento eliminado
     */
    public T deleteFirst() {
        T temp = first.getdData();
        if (first.getNext() == null)
            last = null;
        first = first.getNext();
        return temp;
    }

    /**
     * Elimina el ultimo elemento de la lista
     * 
     * @return Elemento eliminado
     */
    public T deleteLast() {
        T temp = last.getdData();
        last = null;
        return temp;
    }
    
     /**
     * Elimina un elemento proporcionado, mediante su dato
     * 
     * @param data Valor del nodo a eliminar
     * 
     * @return Elemento eliminado
     */
    public DELink<T> deleteItem(T data) {
        if (!isEmpty()) {
            DELink<T> current = first;
            DELink<T> temp = null;
            if(current.getdData().equals(data)){
                temp = first;
                first = first.getNext();
            }else{
                while (current.getNext() != null) {
                    if (current.getNext().getdData().equals(data)) {
                        temp = current;
                        current.setNext(current.getNext().getNext());
                        break;
                    } else
                        current = current.getNext();
                }
            }
            return temp;
        }

        return null;
    }
    
    /**
     *  Elimina un elemento de una posición en la lista
     * 
     * @param position Posicion del nodo
     *  
     * @return Elemento eliminado
     */
    public DELink<T> deletePosition(int position) {
        if (!isEmpty()) {
            if (position > this.sizeList()) {
                System.out.println("La posicion sobrepasa el tamanio de la lista");
            } else {
                int cont = 0;
                DELink<T> temp = null;
                DELink<T> current = first;
                if(position == 0){
                    first = first.getNext();
                    temp = first;
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
     * Elimina todos los nodos del objeto
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
        DELink<T> current = first;
        while(current != null) {
            current.displayLink(); 
            current = current.getNext(); 
        }
        System.out.println("<--last)");
    }

}