package DoublyLinkedList;

public class DoublyLink<T> {
    private T dData; 
    private DoublyLink<T> next; 
    private DoublyLink<T> previous; 

    public DoublyLink(T d) { 
        dData = d; 
    }

    public void displayLink() {
        System.out.print(dData + ",");
    }

    public T getdData() {
        return dData;
    }

    public void setdData(T dData) {
        this.dData = dData;
    }

    public DoublyLink<T> getNext() {
        return next;
    }

    public void setNext(DoublyLink<T> next) {
        this.next = next;
    }

    public DoublyLink<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLink<T> previous) {
        this.previous = previous;
    }
    
    
} 