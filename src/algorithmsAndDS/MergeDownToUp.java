package algorithmsAndDS;

/**
 * 自底向上的归并排序
 */
public class MergeDownToUp {

    private static Comparable[] aux;

    private static void sort(Comparable[] a){

        int N = a.length;
        aux = new Comparable[N];   // 确定数组空间
        for (int len = 1; len < N; len += len) {// 确定每一层的数组大小len;
            for (int lo = 0; lo < N - len; lo++) { // 建立索引，并对每2个子数组两两归并排序。
                Merge.merge(a,lo,lo+len-1,Math.min(lo+len-1+len,N));
            }
        }
    }
}
