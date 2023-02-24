package Link;

public class LinkListTest<T> {
    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<Integer>();
        list.isEmpty();
        list.showLast();
        list.insertFirst(90);
        list.insertFirst(98);
        list.insertFirst(89);
        list.insertFirst(45);
        list.insertFirst(64);
        list.insertLast(34);
        list.insertLast(21);
        list.displayList();
        list.deletePosition(6);
        list.displayList();
        list.deleteItem(98);
        list.displayList();
        int qpd = list.searchItem(89);
        System.out.println(qpd);

        list.deleteFirst();
        list.deleteLast();
      
        list.showLast();
       
        list.displayList();
        list.showFirst();
        list.sizeList();
        list.deleteAll();
        list.displayList();

     /*    System.out.println();
        System.out.println("Mis pruebas - Ruben");
        LinkList<String> myList = new LinkList<String>();
        myList.isEmpty();
        myList.insertFirst("Alan");
        myList.insertFirst("Ximena");
        myList.insertFirst("Sebastian");
        myList.insertFirst("Bianca");
        myList.insertFirst("Zoe");
        myList.insertFirst("Jorge");
        myList.insertFirst("Ruben");
        myList.insertLast("Prueba");
        myList.insertLast("2Prueba");
        myList.insertLast("PruebaAgain");
        myList.displayList();
        myList.updateWithPrevNode("Bianca", "Holanda");
        System.out.println("the list");
        myList.updateWithPosition(2, "Harry");
        myList.updateNode("Prueba", "Completad");
        //myList.deleteAll();
        myList.displayList(); */
    }
}
