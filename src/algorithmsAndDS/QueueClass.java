package algorithmsAndDS;

/**
 * Created by Administrator on 2017/7/20.
 */
public class QueueClass<Integer> {

    private class Node {
        Integer strs;
        Node next;
    }

    private Node first;
    private Node last;
    private int n;

    public QueueClass(Integer str1, Integer str2) {
        first = new Node();
        last = new Node();
        first.strs = str1;
        last.strs = str2;
        first.next = this.last;
    }

    public void add(Integer str) {
        Node oldLast = last;
        last = new Node();
        last.strs = str;
        last.next = null;
        oldLast.next = last;
        n++;
    }

    public Integer pop() {
        Integer str = first.strs;
        first = first.next;
        return str;
    }

    public int size() {
        return n;
    }

    ;

    public boolean isEmpty() {
        return n == 0;  // return first == null;
    }

    public static void main(String[] args) {
//
//        QueueClass<String> qc = new QueueClass<>("start", "from");
//        System.out.println(qc.first.strs);
//        System.out.println(qc.last.strs);
        QueueClass<String> qc = new QueueClass<>("start", "from");
        // qc.add("from");
//        System.out.println(qc.first.strs);
//        System.out.println(qc.last.strs);
        qc.add("here");
//        System.out.println(qc.first.strs);
        qc.add("now");
        System.out.println(qc.first.strs);
        qc.pop();
        System.out.println(qc.first.strs);
        System.out.println(qc.isEmpty());
        while (qc.first.next != null) {
            System.out.println(qc.first.strs);
            qc.first = qc.first.next;
        }
    }
}




