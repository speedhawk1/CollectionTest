package algorithmsAndDS;

/**
 * Created by Administrator on 2017/7/20.
 */
public class QueueClass<String> {

    private class Node{
        String strs;
        Node next;
    }

    private Node first;
    private Node last;
    int n;

    public QueueClass(String str){
        first.strs = str;
        first.next = last;
    }

    public void add(String str){
        Node oldLast = last;
        last = new Node();
        last.strs = str;
        oldLast.next = last;
        n++;
    }
    public String pop(){
        String str = first.strs;
        first = first.next;
        return str;
    }

    public int size(){
        return n;
    };

    public boolean isEmpty(){
        return n == 0;  // return first == null;
    }
}
