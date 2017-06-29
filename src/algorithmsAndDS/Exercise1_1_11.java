package algorithmsAndDS;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Administrator on 2017/5/3.
 * ??为啥改完元素，第22个还是*？
 */
public class Exercise1_1_11 {
    public static void main(String[] args) {

        Boolean[][] b = new Boolean[5][5];
        // 莫名其妙。。。MDZZ
        b[2][2] = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (b[i][j] = true) {
                    StdOut.printf("*"+i+j);
                }else{
                    StdOut.printf(" "+i+j);
                }
            }
            StdOut.printf("\n");
        }
    }
}
