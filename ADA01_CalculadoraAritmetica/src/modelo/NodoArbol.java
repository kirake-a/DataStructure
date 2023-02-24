package modelo;

public class NodoArbol {
    public Object valor; // Valor que almacenado en el nodo
    public NodoArbol izquierda;
    public NodoArbol derecha;

    public NodoArbol() { // Nodo por defecto, valores nulos
        this(null, null, null);
    }

    public NodoArbol(Object valor) { // Inicializa al nodo con su valor
        this(null, valor, null);
    }

    public NodoArbol(NodoArbol iz, Object v, NodoArbol der) { // Se crea el nodo con sus tres parametros
        this.valor = v;
        this.izquierda = iz;
        this.derecha = der;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

}
