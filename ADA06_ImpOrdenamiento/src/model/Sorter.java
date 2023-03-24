package model;
@SuppressWarnings("unused")
/*
 * Este metodo es que el esta encargado de llamar al
 * metodo de ordenamiento que sea requerido. 
 * Considerar si se necesitaran excepciones para las llamadas
 * y si sera excepciones propias o ya de java
 */
public class Sorter {
    private DoublyLinkedList<Country> list;

    public Sorter(DoublyLinkedList<Country> list){
        this.list = list;
    }

    /**
     * Ordena la lista dada previamente en el constructor del objeto, segun el metodo de ordenamiento
     * seleccionado por la key dada en el argumento.
     * @param key Selecciona el tipo de algoritmo a usar para ordenar la lista de datos
     * @throws Exception El digito de la variable key no es un metodo de ordenamiento
     */
    public void sorting(int key) throws Exception{
        /*
         * Escoge el metodo de ordenamiento de la lista, en teoria esta
         * clase debera devolver la lista ordenada para su futuro procesamiento
         */
        switch (key) {
            case 0:
                
                break;
        
            default:
                throw new Exception();
        }
    }

    /**
     * 
     * Ordena la lista dada previamente en el constructor del objeto, segun el metodo de ordenamiento
     * seleccionado por la key dada en el argumento.
     * @param key Selecciona el tipo de algoritmo a usar para ordenar la lista de datos
     * @param list La lista doblemente ligada que se quiere ordenar
     * @throws Exception El digito de la variable key no es un metodo de ordenamiento
     */
    public void sorting(int key, DoublyLinkedList<Country> list) throws Exception{
        /*
         * Escoge el metodo de ordenamiento de la lista, en teoria esta
         * clase debera devolver la lista ordenada para su futuro procesamiento
         */
        switch (key) {
            case 0:
                
                break;
        
            default:
                throw new Exception();
        }
    }

}
