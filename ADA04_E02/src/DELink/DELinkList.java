package DELink;

/**
 * Lista generica simplemente ligada que usa un apuntador first y uno last para indicar topes
 * por ambos lados
 * @author Monica Garcilazo
 * @author Ruben Alvarado
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
     * Conocer si la lista esta vacia, o en su caso esta
     * inicializada con al menos un nodo
     * @return true si la lista esta vacia, false si no lo esta
     */
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * Crea un nuevo nodo y lo inserta al inicio de la lista
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
     * @param datum El dato que contendra el nodo
     */
    public void insertLast(T datum) {
        DELink<T> newLink = new DELink<>(datum);
        if (isEmpty())
            first = newLink;
        else
            last.setNext(newLink);
        ;
        last = newLink;
    }
    
    /**
     * Inserta un dato de manera ordenada a la lista, dado un parametro entero para
     * realizar la insersion, si la lista estuviera vacia el dato unicamente se
     * inserta a la lista, de esa forma inicializandola
     * @param data          Valor del dato que tendra el nodo que se quiere insertar
     * @param order Valor entero por el cual se decide como se inserta el
     *                      valor a la lista.
     *                      0. Insertar de manera ascendente. 1. Insertar de manera
     *                      descendente
     */
    public void insertInOrder(int order, T data){
       if (!((order == 0) || (order == 1))) {
        System.out.println("Esta opcion de ordenamiento no existe");
        return;
       } else {
        if (!isEmpty()) {
            DELink<T> newLink = new DELink<T>(data);
            DELink<T> current = first;
            DELink<T> previous = first;
            switch(order){
                case 0:
                    while (current != null && ((Comparable) data).compareTo((Comparable) current.getdData()) > 0) {
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
                    while (current != null && ((Comparable) data).compareTo((Comparable) current.getdData()) < 0) {
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
        }else {
            insertFirst(data);
            return;
        }
       }
    }

    /**
     * Muesta al primer elemento de la lista si es que la lista no esta vacia
     * @return Primer nodo, null si la lista estaba vacia
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
     * Muestra al ultimo elemento de la lista si es que la lista no esta vacia
     * @return Ultimo nodo, null si la lista estaba vacia
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
     * Conocer el tamanio que tiene la lista
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
     * Hace una busqueda de un elemento y devuelve -1 si no lo encontro y la posicion del dato 
     *  en la lista en caso de que se haya encontrado.
     * @param datum Dato que se busca
     * @return Retorna la posicion del nodo buscado, si no existe -1
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
     * Actualizael valor(dato) de un nodo, conociendo su valor previo
     * @param oldValue El dato que se busca en la lista
     * @param newVelue Dato que sustituira al valor oldValue
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
     * @param position Posicion del nodo
     * @param newValue Valor a actualizar
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
     * @return Elemento eliminado
     */
    public T deleteLast() {
        T temp = last.getdData();
        last = null;
        return temp;
    }
    
     /**
     * Elimina un elemento en la lista, proporcionando el dato que contiene el nodo.
     * Unicamente si la lista no esta vacia
     * @param data Valor del nodo a eliminar
     * @return Elemento eliminado, null si la lista estaba vacia
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
     *  Elimina un elemento de la lista con su posicion proporcionada.
     * Unicamente si la lista no estaba vacia
     * @param position Posicion del nodo
     * @return Elemento eliminado, null si la lista estaba vacia
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
     * Elimina todos los nodos que se encuentran en la lista
     */
    public void deleteAll() {
        while (first != null) {
            first = first.getNext();
        }
    }

    /**
     * Despliega todos los datos en la lista, iniciando con el first
     * y terminando con el valor last en la lista
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