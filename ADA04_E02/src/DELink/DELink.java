package DELink;

public class DELink<T> {
    private T dData;
    private DELink<T> next; 

    public DELink( T dd) {
        dData = dd;
    }

    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }

    public T getdData() {
        return dData;
    }

    public void setdData(T dData) {
        this.dData = dData;
    }

    public DELink<T> getNext() {
        return next;
    }

    public void setNext(DELink<T> next) {
        this.next = next;
    }

    
}