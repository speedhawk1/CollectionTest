package algorithmsAndDS;

/**
 * 希尔排序：
 * 思想：将数组划分为任意个h数组，分别对每个h数组排序；
 * h的含义：相当于数组元素的间距。对于变化中的h，我们用递增序列对其命名。
 * 算法过程：对原数组中间距为h的元素组成的新数组（即一个h数组）进行插入排序，随着循环的推进，h将逐渐缩小，
 * 直至为1（即最终对原数组进行插入排序）。而此时，原数组已经非常接近顺序数组。
 * 代码如下：
 */
public class ShellSort {

    public static void sort(Comparable[] a){
        int t = a.length; int h = 1; // 确定数组的长度和h；
        while(h<t/3) h = h*3 + 1;  //
        while(h>=1){
            for (int i = 0; i < t; i+=h) {
                for (int j = i; j > 0 && less(a[i],a[i-h]) ; j-=h) {
                    exch(a,i,i-h);
                }
            }
            h = h/3;
        }
    }

    public static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }

    public static void exch(Comparable[] a, int x, int y){
        Comparable t = a[x];a[x] = a[y];a[y] = t;
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length ; i++) {
            if(a[i].compareTo(a[i-1]) < 0) return false;
        }
        return true;
    }

    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        String[] a = {"f", "o", "r", "e", "x", "a", "m", "p", "l", "e"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
