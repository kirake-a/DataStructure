package DELink;

/**
 * Double Ending Link. Genera un nodo para una lista con doble terminacion
 * @author Monica Garcilazo
 * @author Ruben Alvarado
 * @version 22/02/2023
 */
public class DELink<T> {
    private T dData;
    private DELink<T> next;

    /**
     * Construye un nuevo nodo con su dato a almacenar
     * @param dd Dato que almacenara el nodo a crear
     */
    public DELink(T dd) {
        dData = dd;
    }

    /**
     * Despliega el valor del dato contenido en el nodo
     */
    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }

    /**
     * Obtener el valor del dato contenido en el nodo
     * @return El valor del dato del nodo
     */
    public T getdData() {
        return dData;
    }

    /**
     * Cambiar el valor del dato del nodo
     * @param dData Valor que se quiere ingresar para sustituir al valor actual del nodo
     */
    public void setdData(T dData) {
        this.dData = dData;
    }

    /**
     * Obtene al nodo ligado como siguiente
     * @return El objeto nodo siguiente
     */
    public DELink<T> getNext() {
        return next;
    }

    /**
     * Cambiar el valor del dato del nodo siguiente
     * @param next Valor que se quiere ingresar para sustiuir al valor actual del nodo siguiente
     */
    public void setNext(DELink<T> next) {
        this.next = next;
    }

    
}