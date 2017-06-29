package algorithmsAndDS;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Administrator on 2017/5/4.
 * 如果original数组元素很多怎么办？
 * 为何会有题目中的现象出现？
 * foreach循环有何问题？
 */
public class Exercise1_1_15 {

    private static int[] histogram(int[] a,int m){

        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j] == i) {
                    count++;
                }
            }
            b[i] = count;
            StdOut.println(b[i]);
        }
        StdOut.println("test over");
        return b;
    }

    public static void main(String[] args) {
        StdOut.print("Enter your M:");
        int num = StdIn.readInt();
        int c = 0;
        StdOut.print("Enter your Array:");
        int[] original = StdIn.readAllInts();
        int[] test = Exercise1_1_15.histogram(original,num);
//        for (int i : test) {
//            c = c + test[i];
//            StdOut.println(c);
//        }
        for (int i = 0; i < test.length ; i++) {
           c += test[i];
            StdOut.println(c);
        }
    }
}
