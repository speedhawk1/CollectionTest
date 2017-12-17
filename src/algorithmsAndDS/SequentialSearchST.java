package algorithmsAndDS;

/**
 * 基于链表实现的顺序查找字典
 */
public class SequentialSearchST<Key extends Comparable<Key>,Value extends Comparable<Value>> {

    class Node {

        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node first;

    public Value get(Key key){
        for(Node x = first;x != null;x = x.next){
            if(key.compareTo(x.key) == 0){
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key,Value value){
        for (Node x = first;x != null; x = x.next) {
            if(key.compareTo(x.key) == 0){
                x.value = value;
                return;}
        }
        first = new Node(key,value,first);
    }
}
