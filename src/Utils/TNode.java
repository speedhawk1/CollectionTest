package Utils;

/**
 * Created by Administrator on 2018/1/7.
 */
public class TNode<Key extends Comparable<Key>,Value>  {
    Key key1;
    Key key2;
    Value value;
    BNode bLeft;
    TNode tLeft;
    BNode bMid;
    TNode tMid;
    BNode bRight;
    TNode tRight;
    int N;

    public TNode(Key key1,Key key2,Value value,int N){
            this.key1 = key1;
            this.key2 = key2;
            this.value = value;
            if(N == 2) this.N = N;
            else {
                System.out.print("The original value of N must be 2!");
                this.N = 2;
                throw new IllegalArgumentException();
            }

    }

    public static void main(String[] args) {
        TNode<String,Integer> tn = new TNode<>("a","b",1,3);
        System.out.print(tn.N);
    }
}
