package Link;

/**
 * Se genera un nodo de tipo generico
 * @author Ruben Alvarado
 * @author Monica Garcilazo
 * @version 23/02/2023
 */
public class Link<T> {
    private T dData;
    private Link<T> next;

    /**
     * Instancia un nuevo Link generico con el
     * dato que albergara
     * @param dd Dato que contendra el nodo a generar
     */
    public Link(T dd) {
        dData = dd;
    }

    /**
     * Muestra en pantalla el valor que contiene el nodo
     */
    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }

    /**
     * Regresa el valor del dato del nodo actual
     * @return El valor del dato del nodo
     */
    public T getdData() {
        return dData;
    }

    /**
     * Cambia el valor del dato del nodo actual
     * @param dData El nuevo valor de dato del nodo
     */
    public void setdData(T dData) {
        this.dData = dData;
    }

    /**
     * Conocer al nodo siguiente al que se apunta
     * @return El nodo siguiente
     */
    public Link<T> getNext() {
        return next;
    }

    /**
     * cambiar el valor del dato del nodo siguiente
     * @param next El nuevo valor de dato del nodo siguiente
     */
    public void setNext(Link<T> next) {
        this.next = next;
    }

    

}