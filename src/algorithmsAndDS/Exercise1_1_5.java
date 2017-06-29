package algorithmsAndDS;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/2.
 * 个人认为更好的方法是：
 * 若判定更多个数的浮点数，先放进一个数组，然后对数组排序；
 * 分别二分查找0和1，找到为false，找不到为true.
 */
public class Exercise1_1_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double a = scanner.nextDouble();
        Double b = scanner.nextDouble();
        // 这个判断太暴力。。
        if (a>0 & b>0 & a<1 & b<1) {
            StdOut.print(true);
        }else{
            StdOut.print(false);
        }
    }
}
