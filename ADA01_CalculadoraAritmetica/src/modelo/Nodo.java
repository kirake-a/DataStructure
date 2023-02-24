package modelo;

public class Nodo {
    public Object elemento; // Valor almacenado en el nodo
    public Nodo sigElemento; // Referencia al siguiente elemento

    public Nodo(Object valor) { // Nodo con elemento igual a valor y que apunta al vacio
        this(valor, null);
    }

    public Nodo(Object valor, Nodo n) { // Valor: valor del nodo; n: nodo al que apunta el creado
        elemento = valor;
        sigElemento = n;
    }

}
