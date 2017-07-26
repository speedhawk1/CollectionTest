package algorithmsAndDS;

/**
 * Created by Administrator on 2017/7/7.
 */
// 下压堆栈：
public class LinkedStackClass<Double>{


    private class Node{
        private Double start;
        private Node next;
    }
    Node first = new Node();
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

    public static void main(String[] args) {
        LinkedStackClass<String> lsc = new LinkedStackClass<>("aaa");
        System.out.print(lsc.first.start);
    }
}

