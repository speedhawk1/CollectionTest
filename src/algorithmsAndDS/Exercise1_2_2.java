package algorithmsAndDS;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**
 * Created by Administrator on 2017/5/16.
 */
public class Exercise1_2_2 {
    public static void main(String[] args) {
        // 创建间隔数组
        int n = 10;
        Interval1D[] segs = new Interval1D[n];
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.setPenRadius(.03);
        for (int i = 0; i < n ; i++)
            try {
                double lo = StdRandom.random();
                double hi = StdRandom.random();
                Interval1D seg = new Interval1D(lo, hi);
                segs[i] = seg;
            } catch (Exception e) {e.printStackTrace();}
//            finally {
//                double lo = .3;
//                double hi = .6;
//                Interval1D seg = new Interval1D(lo, hi);
//                segs[i] = seg;
//            }

        // 判断是否相交
        int count = 0;
        for (int i = 0; i < n - 1 ; i++) {
            for (int j = 0; j < n; j++) {
                if (j <= i) {
                    continue;
                } else {
                    ;
                    if (segs[i].intersects(segs[j])) {
                        ++count;
                        StdOut.println(segs[i].toString()+segs[j].toString());
                    }
                }
            }
        }

    }
}
