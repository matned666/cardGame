import java.util.LinkedList;
import java.util.List;

public class Stock<E> {

    private Element top;

    public Stock() {
    }

    public Stock(E value) {
        this.top = new Element(value, null);
    }

    public Element getTop() {
        return this.top;
    }

    public List<E> leaveOnlyTop(){
        E pop1 = this.pop();
        List<E> temp= new LinkedList<>();
        while(!this.isEmpty()){
            E pop = this.pop();
            temp.add(pop);
        }
        push(pop1);
        return temp;
    }

    public int getStockSize(){
        int counter = 1;
        Element actual = this.top;
        while(actual.previous != null){
            actual = actual.previous;
            counter++;

        }
        return counter;
    }

    public void push(E value){
        if(isEmpty() == true){
            Element elementToPush = new Element(value, null);
            this.top = elementToPush;
        }
        else {
            Element elementToPush = new Element(value, this.top);
            this.top = elementToPush;
        }
    }

    public E pop(){
        Element temp = this.top;
        this.top = this.top.previous;
        return (E) temp.value;
    }

    public E peek(){
        return (E) this.top.value;
    }

    public boolean isEmpty(){
        return this.top == null;
    }

    public void print(){
        String prev;
        if(this.top.previous == null) prev = "null";
        else prev = this.top.previous.value.toString();
        System.out.println("top value:"+this.top.value+" prev:"+prev);
    }

    public Stock reverseStock(){
        E pop1 = this.pop();
        Stock<E> temp= new Stock(pop1);
        while(!this.isEmpty()){
            E pop = this.pop();
            temp.push(pop);
        }
        return temp;
    }


    class Element<E> {

        E value;
        Element previous;

        public Element(E value, Element previous) {
            this.value = value;
            this.previous = previous;
        }
    }


}
