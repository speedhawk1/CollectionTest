package algorithmsAndDS;

import edu.princeton.cs.algs4.StdOut;

/**
 * 越界问题：line48的代码中，++i表示对指针先行+1后在进行比较，故if语句中的条件判定须在while中i的值达到6之前先行跳出循环。
 */
public class Shuffle {

    private static Comparable[] aux;

    public static void sort(Comparable[] a){

    }

//    public static void partition(Comparable[] a,int lo,int hi){  //切分
//        Comparable parterlo = a[lo];
//        for (int i = 0; i < hi; i++) {
//            if(parterlo.compareTo(a[i]) < 0){
//                for (int j = hi; j > i; j--) {
//                    if(parterlo.compareTo(a[j]) > 0){
//                        Comparable parterhi = a[i];
//                        a[i] = a[j];
//                        a[j] = parterhi;   // 先将a[i]与a[j]调换；
//                        a[i-1] = a[i];
//                        a[i] = parterlo;
//                        hi = j;
//                        break;
//                    }else{
//                        a[i-1] = a[i];
//                        a[i] = parterlo;
//                    }
//                }
//            }
//        }
//    }

    public static void exan(Comparable[] a,int i,int j){
        Comparable chan = a[i];
        a[i] = a[j];
        a[j] = chan;
    }
    public static int partition(Comparable[] a,int lo,int hi){
        Comparable parter = a[lo];
        int i = lo;
        int j = hi;
        while(true){
            while(parter.compareTo(a[++i]) > 0) if(i >= hi-1) break;   // i指针从左至右检索，直至遇到一个大于a[lo]的元素
            while(parter.compareTo(a[--j]) < 0) if(j <= lo) break;   // j指针从左至右检索，直至遇到一个小于a[lo]的元素
            if(i >= j) break;
            exan(a,i,j);   //交换i和j;
        }
        exan(a,lo,i);  // 当i与j相遇时，交换a[lo]和左侧子数组末端的元素
        return i;
    }

    public static void main(String[] args) {
        String[] a = {"b","a","f","c","e","d"};
        int i = 0;
        int j = 6;
        StdOut.print(a[partition(a,i,j)]);

    }
}
