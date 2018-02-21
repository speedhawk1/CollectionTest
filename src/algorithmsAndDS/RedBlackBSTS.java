package algorithmsAndDS;

import java.util.Scanner;

/**
 * 红黑树算法：
 */
public class RedBlackBSTS<Key extends Comparable<Key>,Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    private class Node{
        Key key;
        Value value;
        Node left,right;
        int N;
        boolean color;

        Node(Key key,Value value,int N,boolean color){
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }

    }

    public RedBlackBSTS(){}

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null) return 0;
        return x.N;
    }
    private boolean isRed(Node x){   // 颜色判定
        if(x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h){  //左旋转：本质1、改变父节点和子节点的关系 2、改变父节点和子节点之间子树的从属关系
        Node x = h.right;   // 改变原有的链接；
        h.right = x.left;
        x.left = h;
        x.color = h.color;  // 改变颜色；
        h.color = RED;
        x.N = h.N;   // 整理计数器；
        h.N = size(h.right) + size(h.left) + 1;
        return x;
    }

    private Node rotateRight(Node h){ //右旋转
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h){  // 颜色变换（专门针对根节点）
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node x,Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return get(x.left,key);
        else if(cmp > 0) return get(x.right,key);
        else return x.value;
    }

    public Node put(Key key,Value value){
        root = put(root,key,value);
//        System.out.print(root.color);
        root.color = BLACK;
        return root;
    }

    private Node put(Node x,Key key,Value value){  // 将一个键值对插入红黑树中
        if (x == null) return new Node(key, value, 1, RED);
//        if(isRed(x.left) && isRed(x.right)) flipColors(x);
        int cmp = key.compareTo(x.key);    // 1、逐层递归至正确的节点；
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
//            System.out.println(value);
        // 2、对相应节点做变换：
        if (isRed(x.right) && !isRed(x.left)) x = rotateLeft(x); // 左旋转
        if (isRed(x.left) && isRed(x.left.left)) x = rotateRight(x); // 右旋转
        if (isRed(x.left) && isRed(x.right)) flipColors(x);  //若将此代码移动到put方法第二个注释处即可得向下变换的方法？
        // 3、更新计数器：
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Node deleteMin(){
        return deleteMin(root);
    }

    public Node deleteMin(Node x){  // 删除红黑树中最小键
        //1、 向下遍历；
	/*Node h = x.left;
	if(h.left == null) return;
	h == deleteMin(h.left);
	*/ // 此处若不如此处理可能报NPE；
        if(x == null) return null;
        if(x.left == null) return x;
        x.left = deleteMin(x.left);

        //2、 删除操作；
        // Node n = x.left;  这TM是一个失误；
        if(x.left.color == RED){  // 1、当被删除节点为红树；
            x.left = null;
        }
        if(x.left.color != RED && x.right.left.color == RED){ // 2、当被删除节点为黑树，且其兄弟节点为红树（3-节点变换）；
            Node h = x;
            x = h.right.left;
            // I、更新颜色；
            x.color = h.color;
            // II、更新结构；
            x.left = h;
            x.right = h.right;
            // III 更新计数器；
            x.left.N = 0;
            x.right.N = 0;
            // IV 删除节点；
            x.left.left = null;
        }
        if(x.left.color != RED && x.right.left.color != RED){ // 3、当被删除节点与其兄弟节点均为黑树（4-节点变换）；
            Node h = x;
            h.color = RED;
            x = h.right;
            x.left = h;
            h.left = null;
            h.right =null;
            x.left.N = 0;
            x.left.left = null;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public static void main(String[] args) {
        RedBlackBSTS<String,Integer> rbb = new RedBlackBSTS<>();
        int value = 0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            String string = scanner.next();
            if(!string.equals("exit")){
                rbb.put(string, value++);
            }else break;
            System.out.println(rbb.get(string));
            System.out.println(rbb.size());
//            System.out.print(value);
        }
        System.out.println(rbb.deleteMin().getClass());
    }
}
