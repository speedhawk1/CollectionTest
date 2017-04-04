/**
 * Created by Administrator on 2017/4/3.
 */
public class SimpleLinkedListTest {
    private class Node{
        public Node(Object o) {
            this.o = o;
        }
        Object o;
        Node next;
    }

    private Node first;
    public void add(Object elem){
        Node node = new Node(elem);
        if (first == null) {
            first = node;
        } else {
            append(node);
        }
    }

    private void append(Node node){
        Node last = first;
        while(last.next != null){
            last = last.next;
        }
        last.next = node;
    }

}
