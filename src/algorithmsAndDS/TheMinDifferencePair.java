package algorithmsAndDS;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/22.
 */
public class TheMinDifferencePair {

    //    private int[] a;
//    private int[] b;
//    private int n;
//
//    public TheMinDifferencePair(int n){
//
//        this.n = n;
//        a = new int[n];
//        b = new int[n];
//    }

    public static void count(int[] a) {
        int len1 = a.length;
        int[] b = new int[len1 - 1];
        Arrays.sort(a);
        for (int i = 0; i + 1 < len1; i++) {
            int min = Math.abs(a[i] - a[i + 1]); // 对于有序数组内任意整形值，与其差的绝对值最小的整形值为其相邻的整形值。
            b[i] = min;
        }
        Arrays.sort(b);
        for (int i = 0; i < len1; i++) {
            if (Math.abs(a[i] - a[i+1])==b[0]) {
                int m = a[i];
                int n = a[i+1];
                StdOut.print("The right pair is " + m + "with" + n);
                break;
            }
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        TheMinDifferencePair.count(a);
    }
}
