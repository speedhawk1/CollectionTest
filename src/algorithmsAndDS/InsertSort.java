package algorithmsAndDS;

/**
 * 插入排序：
 * 思想：如洗桥牌的插入式排序。与选择排序不同，插入排序是对索引元素左边的元素进行排序。
 * 算法过程：将数组索引元素与之前的元素相比较，若存在索引元素小于其左边元素的情况，就将其插入到左边元素的序列中。
 * 而当索引到达最右边时，排序也刚好结束。
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
