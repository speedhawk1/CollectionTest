package algorithmsAndDS;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.ThreeSum;

/**
 * Created by Administrator on 2017/8/7.
 */
public class TimeCounter {

    private final long start;
    public TimeCounter(){
        start = System.currentTimeMillis();
    }

    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now - start)/1000.0;
    }
    public static void main(String[] args) {
        int N = 10;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000000,1000000);
        }
        TimeCounter timer = new TimeCounter();
        int cnt = ThreeSum.count(a);
        double time = timer.elapsedTime();
        StdOut.print(cnt + "triples" + time + "seconds");
    }
}
