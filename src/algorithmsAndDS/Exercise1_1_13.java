package algorithmsAndDS;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Administrator on 2017/5/3.
 * 如果矩阵不是方阵怎么做？
 */
public class Exercise1_1_13 {
    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] a = new int [3][3];
        // 开始对数组循环换位，已经换位过的不会重复换位
        for (int i = a.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int p = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = p;
                // 这个地方，对象p的内存会自动释放吗？
            }
        }

       /* for (int[] i : a) {
            for (int j : i){
                StdOut.print(i[j]);
            }
            StdOut.print("\n");
        }*/
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                StdOut.print(a[i][j]);
            }
            StdOut.print("\n");
        }
    }
}
