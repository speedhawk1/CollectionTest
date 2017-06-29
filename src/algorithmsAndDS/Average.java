package algorithmsAndDS;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Administrator on 2017/4/29.
 */
public class Average {
    public static void main(String[] args) {
        //取平均值
        double sum = 0.0;
        int cnt = 0;
        while(!StdIn.isEmpty()) {
            // 读一个数，计算累加和
            sum += StdIn.readDouble();
            cnt ++;
        }
        // 标准输入的数无法再次读取，最终cnt为3.
        Double avg = sum / cnt;
        StdOut.printf("Averagew is %.5f\n",avg);
    }
}
