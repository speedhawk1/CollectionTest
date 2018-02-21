package Utils;

/**
 * Created by Administrator on 2018/1/7.
 */
public class BNode<Key extends Comparable<Key>,Value> {
    Key key;
    Value value;
    BNode bLeft;
    TNode tLeft;
    BNode bRight;
    TNode tRight;
    int N;

    public BNode(Key key,Value value,int N){
        this.key = key;
        this.value = value;
        this.N = N;
    }
}
