package algorithmsAndDS;

/**
 * Created by Administrator on 2017/11/18.
 */
public class Shuffle {

    private static Comparable[] aux;

    public static void sort(Comparable[] a){

    }

    public static void partition(Comparable[] a,int lo,int hi){  //切分
        Comparable chanlo = a[lo];
        for (int i = 0; i < hi; i++) {
            if(chanlo.compareTo(a[i]) < 0){
                for (int j = hi; j > i; j--) {
                    if(chanlo.compareTo(a[j]) > 0){
                        Comparable chanhi = a[i];
                        a[i] = a[j];
                        a[j] = chanhi;   // 先将a[i]与a[j]调换；
                        a[i-1] = a[i];
                        a[i] = chanlo;
                        hi = j;
                        break;
                    }else{
                        a[i-1] = a[i];
                        a[i] = chanlo;
                    }
                }
            }
        }
    }
}
