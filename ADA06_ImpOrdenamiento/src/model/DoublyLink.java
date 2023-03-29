package model;

/**
 * Genera nodos de tipo Doubly con tipo de dato generico
 * @author Monica Garcilazo 
 * @author Ruben Alvarado
 * @version 21/02/2023
 */
public class DoublyLink<T> {
    private T dData; 
    private DoublyLink<T> next; 
    private DoublyLink<T> previous;

    /**
     * Crea un nuevo nodo Doubly, con su tipo de dato
     * en estado generico
     * @param d Dato que contendra el nodo
     */
    public DoublyLink(T d) {
        dData = d;
    }

    /**
     * Despliega el valor del nodo
     */
    public void displayLink() {
        System.out.print(dData + ",");
    }

    /**
     * Obtener el valor del dato del nodo actual
     * @return Dato que contiene el nodo actual
     */
    public T getdData() {
        return dData;
    }

    /**
     * Cambia el valor del dato que contiene el nodo actual
     * @param dData El nuevo dato con el que se quiere sustituir el actual
     */
    public void setdData(T dData) {
        this.dData = dData;
    }

    /**
     * Obtener el nodo siguiente
     * @return El objeto nodo siguiente, al que apunta el nodo actual
     */
    public DoublyLink<T> getNext() {
        return next;
    }

    /**
     * Cambiar el tipo de dato del nodo siguiente al actual
     * @param next Dato con el que se quiere sustituir al dato actual
     * del nodo ligado siguiente
     */
    public void setNext(DoublyLink<T> next) {
        this.next = next;
    }

    /**
     * Obtener al nodo anterior
     * @return El objeto nodo anterior, al que apunta el nodo actual
     */
    public DoublyLink<T> getPrevious() {
        return previous;
    }

    /**
     * Cambia el valor del dato del nodo anterior
     * @param previous el nuevo dato que sustituye al dato actual
     */
    public void setPrevious(DoublyLink<T> previous) {
        this.previous = previous;
    }
    
    
} 