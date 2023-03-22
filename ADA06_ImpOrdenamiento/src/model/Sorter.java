package model;

/*
 * Este metodo es que el esta encargado de llamar al
 * metodo de ordenamiento que sea requerido. 
 * Considerar si se necesitaran excepciones para las llamadas
 * y si sera excepciones propias o ya de java
 */
public class Sorter {
    DoublyLinkedList<Song> songs;

    public Sorter(DoublyLinkedList<Song> songs) {
        this.songs = songs;
    }

}
