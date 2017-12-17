package algorithmsAndDS;

/**
 * 二叉查找树符号表：
 */
public class BSTS<Key extends Comparable<Key>,Value> {

    Node root;
    class Node{

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

    public int size(){  // 返回符号表的总节点数
        return size(root);
    }

    public int size(Node x){return x.N;}

    public Value get(Key key){return get(root,key);}// 由键获取到对应的值；

    public Value get(Node x,Key key){//具体代码：
        if(x == null)  return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            get(x.left,key);
        }else if(cmp > 0){
            get(x.right,key);
        }else return x.value;
        return x.value;
    }

    public Node put(Key key,Value value){  // 添加一个键为key，值为value的元素；
        return put(root,key,value);
    }

    public Node put(Node x,Key key,Value value){  // 具体方法是返回一个添加一个元素（其键为key值为value）后的链表；
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = put(x.left,key,value);
        }else if(cmp > 0){
            x.right = put(x.right,key,value);
        }else x.value = value;
        x.N = size(x.left) + size(x.right) + 1;  // 更新新增或更改操作后的x对应的节点个数；
        return x;
    }

    public Key min(Key key){
        return min(root).key;
    }
    private Node min(Node x){  // 代码思路：若key值小于根节点，则链表最小键必定为其左子树中最小键。这是一种递归思想。
        if(x == null) return x;
        return min(x.left);
    }

    public Key max(Key key){
        return max(root).key;
    }
    private Node max(Node x){  // 同理可得，若key值大于根节点的key值，则链表中最大键必然是右子树中最大键。
        if(x == null) return x;
        return max(x.right);
    }


    public Key floor(Key key){  //此函数的作用时返回小于等于key的个数
        return floor(root,key).key;  // 若x为空，则返回空值；
    }
    private Node floor(Node x,Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);  // 若x为非空，则比较key与x.key，1、若相等则返回x；
        if(cmp == 0) return x;
        else if(cmp < 0){  // 2、若cmp < 0，则返回其左子树；
            return floor(x.left,key);
        }else{  // 3、若cmp > 0，则当右子树为空则返回本身，否则返回右子树；
            Node t = floor(x.right,key);
            if(t!= null) return t;
            else return x;
        }
    }

    public Key ceiling(Key key){ //此函数作用是返回大于等于key的最小键；与floor同理：
        return ceiling(root,key).key;
    }
    private Node ceiling(Node x,Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        else if(cmp > 0) return floor(x.right,key);
        else{
            Node t = ceiling(x.left,key);
            if(t != null) return t;
            else return x;
        }
    }

    public Key select(int k){   // 根据给定排名返回对应的键；
        return select(root,k).key;
    }

    private Node select(Node x, int k){
        if(x==null) return null;  // x为空，则返回空值；
        int sizeLeft = size(x.left);  // x不为空
        if(k < sizeLeft) return select(x.left,k);  // 1、若k小于左子树节点数则返回左子树查询
        else if(k > sizeLeft) return select(x.right,k - sizeLeft - 1);  //2、若k大于左子树节点数则返回右子树对除左size和根节点剩余的右size查询
        else return x; //3、k等于则返回x；
    }

    public int rank(Key key){  // 根据给定的键返回其排名
        int cmp = key.compareTo(root.key);
        if(cmp < 0) return size(rank(root,key));
        else if(cmp > 0) return size(root.left) + size(rank(root,key)) + 1;
        else return size(root.left);
    }
    private Node rank(Node x,Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return rank(x.left,key);
        else if(cmp > 0) return rank(x.right,key);
        else return x;
    }

}
