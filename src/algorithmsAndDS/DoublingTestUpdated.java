package algorithmsAndDS;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

/**
 * Created by Administrator on 2017/8/19.
 */
public class DoublingTestUpdated {
    private static final int MAXIMUM_INTEGER = 1000000;
    private DoublingTestUpdated() { }
    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }



    public static void main(String[] args) {
        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %5.1f\n", n, time);
        }
//        Double x1 = 0.3;
//        Double x2 = 0.4;
//        Double y1 = 0.6;
//        Double y2 = 0.8;
//        StdDraw.line(x1,y1,x2,y2);b

    }
}
