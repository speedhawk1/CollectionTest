package algorithmsAndDS;

import edu.princeton.cs.algs4.StdOut;

/**
 * 堆排序：算法步骤：1、构造堆；2、下沉排序；
 */
public class HeapSort<T extends Comparable<T>> {

    private T[] a;
    private int n;

    public HeapSort(int len){a = (T[]) new Comparable[len+1];}

    public HeapSort(T[] a){this.a = a;}

    void sink(T[] a,int k,int n){
        while(k <= n){
            int j = 2*k;
            if(j < n && !less(a[j],a[j+1])) ++j;//当n为偶数时if中的条件判断尤为重要。此时最后一个堆中，父节点只有一个子节点。
            if(!less(a[k],a[j])) break;
            exch(a[k],a[j]);
            k = j;
        }
    }

    void exch(T x,T y){T t = x;x = y;y = t;}

    boolean less(T x,T y){
        return x.compareTo(y) < 0;
    }

    public void insert(T t){}

    public boolean isEmpty(){return n == 0;}

    public int size(){return n;}

    public void sort(T[] a,int n){
        for (int i = n/2; i >= 1 ; i--) {
            sink(a,i,n);
        }
        for (int i = n; i > 1 ; i--) {  //循环技巧：边界的标准：须确定循环边界值是否仍参与循环执行。
            exch(a[1],a[i]);
            sink(a,1,n);
        }
    }

    public static void main(String[] args) {
        String[] strings = "s,o,r,t,e,x,a,m,p,l,e".split(",");
        /*for (int i = 0; i < strings.length; i++) {
            StdOut.println(strings[i]);
        }*/
        HeapSort<String> hs = new HeapSort<>(strings.length);
        hs.a[0] = "try";
        StdOut.print(hs.a[0]);
//        hs.sort(hs.a,hs.a.length - 1);
//        for (int i = 0; i < strings.length; i++) {
//            strings[i] = hs.a[i+1];
//            StdOut.print(strings[i] + " ");
//        }
    }
}
