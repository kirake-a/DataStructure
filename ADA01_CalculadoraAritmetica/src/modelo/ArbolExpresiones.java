package modelo;

import java.util.*;
import misExcepciones.StackException;

public class ArbolExpresiones {
    Pila stackOperandos; // Pila de operandos
    Pila stackOperadores; // Pila de operadores

    final String blanco; // Cadena de espacios en blanco
    final String operadores; // Cadena con operadores para expresiones

    String post = "";

    public ArbolExpresiones() {
        stackOperandos = new Pila();
        stackOperadores = new Pila();
        blanco = " \t";
        operadores = ")+-*%/^("; // acomodados por precedencia;
    }
    //ay que suenio hay 
    public NodoArbol construirArbol(String expresion) throws StackException {
        StringTokenizer tokenizer;
        String token;
        NodoArbol raiz = null;

        tokenizer = new StringTokenizer(expresion, blanco + operadores, true);

        while (tokenizer.hasMoreTokens()) {

            token = tokenizer.nextToken();

            if (blanco.indexOf(token) >= 0)
                ; // Es un espacio en blanco, se ignora
            else if (operadores.indexOf(token) < 0) {
                stackOperandos.push(new NodoArbol(token)); // Es operando y lo guarda como nodo del arbol

            } else if (token.equals(")")) { // Saca elementos hasta encontrar (
                while (!stackOperadores.isEmpty() && !stackOperadores.top().equals("(")) {
                    guardarSubArbol();
                }
                stackOperadores.pop(); // Saca el parentesis izquierdo
            } else {
                if (!token.equals("(") && !stackOperadores.isEmpty()) {
                    // operador diferente de cualquier parentesis
                    String op = (String) stackOperadores.top();

                    while (!op.equals("(") && !stackOperadores.isEmpty()
                            && operadores.indexOf(op) >= operadores.indexOf(token)) {
                        guardarSubArbol();

                        if (!stackOperadores.isEmpty())
                            op = (String) stackOperadores.top();
                    }
                }
                stackOperadores.push(token); // Guarda el operador
            }
        }
        // Sacar todo lo que queda
        raiz = (NodoArbol) stackOperandos.top();

        while (!stackOperadores.isEmpty()) {
            if (stackOperadores.top().equals("(")) {
                stackOperadores.pop();
            } else {
                guardarSubArbol();
                raiz = (NodoArbol) stackOperandos.top();
            }
        }

        return raiz;
    }

    // Metodo privado para almacenar en la pila un subarbol
    private void guardarSubArbol() {
        NodoArbol op2;

        try {
            op2 = (NodoArbol) stackOperandos.pop();
            NodoArbol op1 = (NodoArbol) stackOperandos.pop();

            stackOperandos.push(new NodoArbol(op1, stackOperadores.pop(), op2));
        } catch (StackException exception) {
            exception.printStackTrace();
        }

    }

    public void imprime(NodoArbol n) {
        if (n != null) {
            imprime(n.izquierda);
            System.out.print(n.valor + " ");
            imprime(n.derecha);
        }
    }

    public void imprimePos(NodoArbol n) {
        if (n != null) {
            imprimePos(n.izquierda);
            imprimePos(n.derecha);
            System.out.print(n.valor + " ");
        }
    }

    public String crearStringPos(NodoArbol nodo) {

        if (nodo == null) {
            return " ";
        } else {
            crearStringPos(nodo.izquierda);
            crearStringPos(nodo.derecha);
            post = post + String.valueOf((Object) nodo.valor) + " "; // Aqui esta el problema de la concatenacion
        }

        return post;
    }

    public void setPostClean() {
        this.post = "";
    }
}
