package algorithmsAndDS;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/7/7.
 */
// 下压堆栈：
public class LinkedStackClass<Double> implements Iterable{
    @Override
    public Iterator iterator() {
        return null;
    }

    private class Node{
        private Double start;
        private Node next;
    }
    Node first;
    private int n;
    public LinkedStackClass(Double dub){
        first.start = dub;
    }
    public boolean isEmpty(){return n == 0;} // or first == null;
    public int size(){return n;}
    public void push(Double dub){
        Node oldFirst = first;
        first = new Node();
        first.start = dub;
        first.next = oldFirst;
        ++n;
    }
    public Double pop(){
        Double dub = first.start;
        first = first.next;
        --n;
        return dub;
    }
}

