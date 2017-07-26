package algorithmsAndDS;

import java.util.Iterator;
import java.util.Spliterator;

/**
 * Created by Administrator on 2017/7/23.
 */
public class BagClass<Integer> implements Iterable<Integer>{

    private class Node{
        Integer integers;
        Node next;
    }
    private class ListIterator implements Iterator<Integer>{
        private Node current = first;  // 记录当前节点；

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public Integer next() {
            Integer integer = first.integers;
            current = current.next;
            return integer;  //返回当前节点值并指向下一节点
        }
    }
    private int n;
    private Node first;
    public BagClass(Integer integer){
        first = new Node();
        first.integers = integer;
        first.next = null;
    }

    public void add(Integer integer){
        Node oldfirst = first.next;
        oldfirst.integers = integer;
        Node first = new Node();
        first.next = oldfirst;
        ++n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator();
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return null;
    }

}
