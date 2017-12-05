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

    static <T extends Comparable<T>> void exch(T[] a,int x,int y){T t = a[x];a[x] = a[y];a[y] = t;}

    static <T extends Comparable<T>> boolean less(T[] a,int x,int y) {return a[x].compareTo(a[y]) < 0;}

    public void insert(T t){}

    public boolean isEmpty(){return n == 0;}

    public int size(){return n;}

    public void sort(T[] a,int n){
        for (int i = n/2; i >= 1 ; i--) {
            sink(a,i,n);
        }
//        for (int i = n; i > 1 ; i--) {  //循环技巧：边界的标准：须确定循环边界值是否仍参与循环执行。
//            exch(a[1],a[i]);
//            sink(a,1,n);
//        }
    }

    void sink(T[] a,int k,int n){
        while(k <= n){
            int j = 2*k;
            if(j < n && !less(a,j,j+1)) ++j;//当n为偶数时if中的条件判断尤为重要。此时最后一个堆中，父节点只有一个子节点。
            if(j > n || !less(a,k,j)) break;
            exch(a,k,j);
            k = j;
        }
    }

    public static void main(String[] args) {
        String[] strings = "first,s,o,r,t,e,x,a,m,p,l,e".split(",");
        /*for (int i = 0; i < strings.length; i++) {
            StdOut.println(strings[i]);
        }*/
        HeapSort<String> hs = new HeapSort<>(strings);
//        for (int i = 0; i < hs.a.length; i++) {
//            StdOut.print(hs.a[i] + " ");
//        }
//        int k = 2;int n = strings.length - 1;  // n = 11;
//        while(k <= n){
//            int j = 2*k;
//            if(j < n && strings[j].compareTo(strings[j+1]) < 0){
//                ++j;
//                StdOut.print(j);
//            }
//            if(j > n || !(strings[k].compareTo(strings[j]) < 0)) break;  // 越界。。尼玛比。。
//            String s = strings[j];strings[j] = strings[k];strings[k] = s;
//            k = j;
//            StdOut.print(k);
//        }
//        hs.sort(hs.a,hs.a.length - 1);
        hs.sink(hs.a,5,hs.a.length - 1);
        for (int i = 0; i < hs.a.length; i++) {
            StdOut.print(hs.a[i] + " ");
        }
    }
}
