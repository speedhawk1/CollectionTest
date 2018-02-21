package algorithmsAndDS;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

/**
 * 二叉查找树符号表：
 * 需要训练自己的思维链（加长），而且自己的学习方法貌似还跟别人有点区别：
 * 别人是傻傻地不断实践，而我是先了解成功的最终形态，再将这种形态实例化。
 */
public class BSTS<Key extends Comparable<Key>,Value> {

    public Node root;
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

    class TriNode{
        Key key1;
        Key key2;
        Value value;
        Node left;
        Node mid;
        Node right;
        int N;

        public TriNode(Key key1,Key key2,Value value,int N){
            this.key1 = key1;
            this.key2 = key2;
            this.value = value;
            this.N = N;
        }
    }

    public int size(){  // 返回符号表的总节点数
        return size(root);
    }

    public int size(Node x){
        if(x == null) return 0;
        else return x.N;
    }

    public Value get(Key key){return get(root,key);}// 由键获取到对应的值；

    public Value get(Node x,Key key){//具体代码：
        if(x == null)  return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            return get(x.left,key);
        }else if(cmp > 0){
           return get(x.right,key);
        }else return x.value;
    }

    public Node put(Key key,Value value){  // 添加一个键为key，值为value的元素；
        return put(root,key,value);
    }  // 添加一个键值对；

    public Node put(Node x,Key key,Value value){  // 具体方法是返回一个添加一个元素（其键为key值为value）后的链表；
//        assert key != null : "key is null";
//        assert root.key != null : "root.key is null";
        if(x == null) return new Node(key,value,1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = put(x.left,key,value);
        }else if(cmp > 0){
            x.right = put(x.right,key,value);
        }else x.value = value;
        if(x.left == null) x.N = 0 + size(x.right) + 1;
        if(x.right == null) x.N = size(x.left) + 1;
//        StdOut.print(x.N);
        x.N = size(x.left) + size(x.right) + 1;  // 更新新增或更改操作后的x对应的节点个数；
        return x;
    }

    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){  // 代码思路：若key值小于根节点，则链表最小键必定为其左子树中最小键。这是一种递归思想。
        if(x.left == null) return x;
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){  // 同理可得，若key值大于根节点的key值，则链表中最大键必然是右子树中最大键。
        if(x.right == null) return x;
        return max(x.right);
    }


    public Key floor(Key key){  //此函数的作用时返回小于等于key的最大值（向上取整）
        return floor(root,key).key;
    }
    private Node floor(Node x,Key key){
        if(x == null) return null;    // 若x为空，则返回空值；
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
    } // 向下取整；返回大于等于key的最小值
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
    }  //根据给定排名返回对应键

    private Node select(Node x, int k){
        if(x==null) return null;  // x为空，则返回空值；
        int sizeLeft = size(x.left);  // x不为空
        if(k < sizeLeft) return select(x.left,k);  // 1、若k小于左子树节点数则返回左子树查询
        else if(k > sizeLeft) return select(x.right,k - sizeLeft - 1);  //2、若k大于左子树节点数则返回右子树对除左size和根节点剩余的右size查询
        else return x; //3、k等于则返回x；
    }

    public int rank(Key key){  // 根据给定的键返回对应排名；
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

    public Node deleteMin(Node x){  // 删除表中最小键并返回原表；
        if(x.left == null) return x.right;
        else x.left = deleteMin(x.left);  // 不断深入x的左子树中查找，当最终发现x左子树为空时，令x等于其右子树。
        /*递归特性1：
        * 递归调用的执行顺序特性为：
        * I 先递归，后回溯；
        * II 回溯过程中，程序在内存中执行的顺序类似下压栈（后进先出）*/
        x.N = size(x.left) + size(x.right) + 1; //由递归特性1可知，每一级递归后，在函数执行的最终都会有更新计数器的步骤。
        return x;
    }

    public void delete(Key key){
        root = delete(root,key);
    }  // 删除元素

    private Node delete(Node x,Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left =delete(x.left,key);
        /*递归特性2：
        表示递归的语句中，递归关系可根据方法返回值的类型而确定其形式。如在get方法是为了取得
        * key对应的值，故对递归关系可描述为“从x的左子树中获取key
        * 对应的值”，再入本方法中，delete方法要返回一个删除了key对应链的
        * 总链表，那么这里的递归关系可描述为“令链表x的左子树成为删除key对应链
        * 的总链表。*/
        else if(cmp > 0) x.right = delete(x.right,key);
        else {
            if(x.left == null) return x.right;   //当x根节点一边的子树为空时：向递归的前一级返回其另一边的子树。
            if(x.right == null) return x.left;
            //而当x根节点两边的子树都存在时：
            Node t = x;   //1、令t指向x;
            x = min(t.right);   // 2、令x指向t的后继节点；
            x.left = t.left;    // 3、令x的左子树指向t的左子树；
            x.right = deleteMin(t.right); // 4、令x的右子树指向删除最小节点后的t的右子树；
        }
        x.N = size(x.right) + size(x.left) + 1;// 残念...由于递归特性1的存在，更新迭代器的代码总是需要写在被用于递归调用的方法里。
        return x;
    }

    public void printDemo(Node x){  // 中序遍历用例
        if(x == null) return;
        printDemo(x.left);
        StdOut.println(x.key);
        printDemo(x.right);
    }

    public Iterable<Key> keys(){  // 二叉树表的范围查找遍历；
        return keys(min(),max());  // 函数1：对某两个key值之间的键值对遍历；
    }

    public Iterable<Key> keys(Key lo,Key hi){  // 函数2：实现函数1的方法：将某两个值之间的Key压入队列queue；
        Queue<Key> queue = new Queue<>();
        keys(root,queue,lo,hi);
        return queue;
    }

    public void keys(Node x,Queue<Key> queue,Key lo,Key hi){ // 函数3：实现函数2的方法：对二叉树表x进行中序遍历并压入queue；
        if(x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo < 0) keys(x.left,queue,lo,hi);// 若lo值小于x根节点的键，则继续递归至左子树遍历；
        if(cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); //当cmplo或cmphi为零时，将根节点对应key键压入队列queue
        if(cmphi > 0) keys(x.right,queue,lo,hi);// 若hi值大于x根节点的键，则继续递归至右子树遍历；
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BSTS<String,Integer> bsts = new BSTS<>();
//        assert bsts.root.key != null : "root.key is null";
        System.out.print("input your codes");
        while(true){
            int a = 0;
            String str = scanner.next();
//            assert str != null : "str is null";
            if(str.equals("exit")) break;
//            System.out.print(str);
//            System.out.print(bsts.root);
            bsts.root = bsts.put(str,a++);
//            System.out.print(bsts.root);
//            System.out.print(bsts.root.N);
            /*今后编程是只要碰到任何疑似的null都要特别留神空指针异常！！！太可怕了！！！*/
        }
//            System.out.print(bsts.max());
        Queue<String> queue = (Queue<String>) bsts.keys();
        while(!queue.isEmpty()){
            System.out.print(queue.dequeue());
        }
    }
}
