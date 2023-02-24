package modelo;

import misExcepciones.StackException;

public class Pila {
    private Nodo tope; // Tope de la pila
    private int nDatos; // Cantidad de datos en la pila

    // Constructor
    public Pila() {
        tope = null;
        nDatos = 0;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    // Se puede prescindir de este metodo
    public int getNDatos() {
        return nDatos;
    }

    // Obtener el eleento tope de la pila sin alterarla
    public Object top() {
        return (isEmpty()) ? null : tope.elemento;
    }

    //Extrae y devuelve el ultimo elemento de la pila
    public Object pop() throws StackException {

        if (isEmpty()) {
            throw new StackException("Stack underflow");
        }

        Object dato = tope.elemento;
        tope = tope.sigElemento;
        nDatos--;

        return dato;
    }
    
    public void push(Object x) {
        tope = new Nodo(x, tope);
        nDatos++;
    }

}
