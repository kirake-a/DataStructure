package DoublyLinkedList;

public class DoublyLinkedTest {
    public static void main(String[] args) {
    DoublyLinkedList<Integer> theList = new DoublyLinkedList<>();
    theList.insertFirst(22); 
    theList.insertFirst(44);
    theList.insertFirst(66);
    theList.insertLast(11); 
    theList.insertLast(33);
    theList.insertLast(70);
    theList.displayForward();
    theList.insertInOrder(0, 67);
    theList.displayForward();
    theList.deletePosition(7);
    theList.displayForward();
    int size = theList.sizeList();
    System.out.println(size);
    theList.updateNode(22, 13);
    theList.updateWithPosition(2, 120);
    theList.deletePosition(1);
    theList.deleteKey(11);
    theList.displayForward(); 
    theList.searchItem(11);
   
    theList.displayBackward(); 
    theList.deleteFirst(); 
    theList.deleteLast(); 
    theList.deleteKey(11); 
    theList.displayForward(); 
    theList.insertAfter(22, 77); 
    theList.insertAfter(33, 88); 
    theList.deleteAll();
    theList.displayForward(); 
    
    }

}