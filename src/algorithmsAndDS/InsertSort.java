package algorithmsAndDS;

/**
 * Created by Administrator on 2017/11/1.
 */
public class InsertSort {

    /*private Integer[] a;

    public InsertSort(int n){
        a = new Integer[n];
        }*/
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && lessThan(a[j],a[j-1]) ; j--) {
                exch(a,j,j-1);
            }
        }

    }

    public static boolean lessThan(Comparable a,Comparable b){
        return a.compareTo(b) < 0;         //确定主键为：按照升序排序，若a.compareTo(b)>0则为降序；
    }

    public static void exch(Comparable[] a1,int a,int b){
        Comparable t = a1[a]; a1[a] = a1[b];a1[b] = t;        //交换
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length ; i++) {
            return !(a[i].compareTo(a[i-1])<0);
        }
        return false;
    }

    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        String[] a = {"f","o","r","e","x","a","m","p","l","e"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
