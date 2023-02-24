package Link;

public class Link<T> {
    private T dData;
    private Link<T> next; 

    public Link(T dd) {
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

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    

}