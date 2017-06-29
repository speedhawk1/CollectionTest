/**
 * Created by Administrator on 2017/4/3.
 */
public class SimpleLinkedListTest {
    private class Node{
        private Object o;
        Node(Object o){
            this.o = o;
        }
        Node next;
    }

    //链式添加封装类：

    // 一、建立链首；
    private Node first;

    public void add(Node test){
        // 二、新建一个Node类（此Node类可封装任意类实例）；
        Node node = new Node(test);
        // 三、对first进行判定，若first为空，则令first被node赋值，若不为空，则使用append方法将node加入Node链中，进而
        // 使node中的封装类加入LinkedList链中。
        if (first == null) {
            first = node;
        } else {
            append(node);
        }
    }
    // append方法目的：在默认first非空下，顺次对first中的next类进行检定，如存在空值，则使之被node赋值。
    public void append(Node node){

        Node last = first;
        while(last.next != null){
            last = last.next;
        }
        last.next = node;
    }
}
