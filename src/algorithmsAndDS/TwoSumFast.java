package algorithmsAndDS;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/15.
 */
public class TwoSumFast {
    public static int count(int[] a){
        Arrays.sort(a);  // 归并排序
        int n = a.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (BinarySearch.rank(-a[i],a) > i) {  // 二分查找
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        Long start = System.currentTimeMillis();
        StdOut.println(count(a));
        StdOut.print("It takes about " + (System.currentTimeMillis()-start) + "ms");
    }
}
