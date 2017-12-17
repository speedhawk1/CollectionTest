package algorithmsAndDS;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by Administrator on 2017/12/7.
 */
public class BinarySearchST<Key extends Comparable<Key>,Value> {

    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Comparable[capacity];
    }

    public int size(){return N;}

    public int rank(Key key){  // 若表中存在键key，则返回其索引（即表中小于其的数量），若不存在，也返回小于它的数量。
        int lo = 0;int hi = N-1;
        while(lo <= hi){
            int mid = lo+(hi -lo)/2;
            int cmd = key.compareTo(keys[mid]);
            if(cmd < mid){
                hi = mid - 1;
            }else if(cmd > mid){
                lo = mid + 1;
            }else{ return mid; }
        }
        return lo;
    }

    /*对rank方法中非递归循环时，lo的值最终总是能等于小于其索引的元素个数的简要证明:
    * 对于不等于mid的key值来说，总是能落到mid的左边或右边，这里不妨先设key总是在mid左边，
    * 这时随着循环，hi不断接近lo直至与其相等或相邻，此时mid即与lo重合，故mid最终为lo（高等数学中的极限夹逼定理）
    * 对于落到mid右边的key，同理可证。*/

    public void put(Key key, Value value){

        // 查找键，命中则更新，反之则存储新元素
        int i = rank(key);   // 返回小于键key的元素数量；
        if(i < N && keys[i].compareTo(key) == 0){  // 若键存在则更新值value;
            values[i] = value;
            return;
        }
        for (int j = N;j > i;j--) {
            keys[j] = keys[j-1]; values[j] = values[j-1];
        }
        keys[i] = key; values[i] = value; //
        N++;
    }

    public void delete(Key key,Value value){
        int i = rank(key);
        for (int j = i; j < N; j++) {
            keys[j] = keys[j+1];values[j] = values[j+1];
            if(j == N-1) keys[j] = null;values[j] = null;
        }
        N--;
    }

    public Key floor(Key key){return key;}

    public Key ceiling(Key key){
        int i = rank(key);
        return keys[i];
    }

    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> q = new Queue<>();
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }
        return q;
    }
}
