package algorithmsAndDS;

/**
 * Created by Administrator on 2018/1/6.
 */
public class Node<Key,Value> {
    Key key;
    Value value;
    Node left;
    Node right;
    int N;

    public Node(Key key,Value value,int N){
        this.key = key;
        this.value = value;
        this.N = N;
    }
}
