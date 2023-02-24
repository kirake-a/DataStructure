package modelo;

import misExcepciones.StackException;

class PilaGenerica<E> {
    private E[] stackArray;
    private int nDatos;
    private int tope;
     
    @SuppressWarnings("unchecked")
    public PilaGenerica(int size){
        nDatos = size;
        tope = -1;
        stackArray = (E[]) new Object[size];
        
    }

    public void push(E j) throws StackException {
        if (isFull()) {
            throw new StackException("Stack overflow");
        }
        
        stackArray[++tope] = j;
    }
    
    public E pop() throws StackException {
        E item;

        if (isEmpty()) {
            throw new StackException("Stack underflow");
        }
        
        item = stackArray[tope--];

        return item;
    }
     
    public E peek() {
        return stackArray[tope]; 
    }
    
    public boolean isEmpty() {
        return (tope == -1); 
    }
     
    public boolean isFull() {
        return (tope == (nDatos - 1));
    }
    
}

