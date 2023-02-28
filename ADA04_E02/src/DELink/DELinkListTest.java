package DELink;

import DELink.modelo.*;

public class DELinkListTest<T> {
    
    public static void main(String[] args){
        DELinkList<Double> list = new DELinkList<>(); 
        list.insertFirst(2.99);
        list.insertFirst(4.99);
        list.insertFirst(18.99);
        list.insertFirst(8.99);
        list.displayList();
        list.insertInOrder(0, 2.00);
        list.displayList();
        list.deletePosition(3);
        list.displayList();
        list.showFirst();
        list.showLast();
        list.sizeList(); 
        list.deleteItem(6.99);
        list.displayList();
        list.searchItem(6.99);
        list.deleteLast();
        list.deleteFirst();
        list.deleteFirst();    
        list.deleteAll();
        list.displayList(); 
        
/*         System.out.println();
        System.out.println("Mi DEList - Ruben");
        DELinkList<String> myDEList = new DELinkList<>();
        myDEList.isEmpty();
        myDEList.insertFirst("Alan");
        myDEList.insertFirst("Ximena");
        myDEList.insertFirst("Sebastian");
        myDEList.insertFirst("Bianca");
        myDEList.insertFirst("Zoe");
        myDEList.insertFirst("Jorge");
        myDEList.insertFirst("Ruben");

        myDEList.insertLast("Prueba");
        myDEList.insertLast("2Prueba");
        myDEList.insertLast("PruebaAgain");
        myDEList.displayList();
        myDEList.updateWithPrevNode("Bianca", "Holanda");
        System.out.println("the list");
        myDEList.updateWithPosition(2, "Harry");
        // myList.deleteAll();
        myDEList.displayList();
      */
    }
}