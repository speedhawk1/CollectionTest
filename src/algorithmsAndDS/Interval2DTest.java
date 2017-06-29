package algorithmsAndDS;

import edu.princeton.cs.algs4.*;

/**
 * Created by Administrator on 2017/5/11.
 * An instance of digital class
 */
public class Interval2DTest {

    public static void main(String[] args) {

//        StdOut.println(args.length);

        // make a rectangle
//        Double x1 = Double.parseDouble(args[0]);
//        Double x2 = Double.parseDouble(args[1]);
//        Double y1 = Double.parseDouble(args[2]);
//        Double y2 = Double.parseDouble(args[3]);

        Double x1 = .2;
        Double x2 = .4;
        Double y1 = .5;
        Double y2 = .8;

        Interval1D intx = new Interval1D(x1,x2);
        Interval1D inty = new Interval1D(y1,y2);
        Interval2D intxy = new Interval2D(intx,inty);

        // foundation of the random judgement parament;

//        Integer T = Integer.parseInt(args[4]);
        Integer T = 10000;
        Counter count = new Counter("counts");
        for (int i = 0; i < T ; i++) {
            Double x = Math.random();
            Double y = Math.random();
            Point2D xy = new Point2D(x,y);
            if (intxy.contains(xy)) {
                count.increment();
            } else {
                xy.draw();
            }
        }

        StdOut.println(count);
        StdOut.println(intxy.area());
        Out out = new Out(String.valueOf(count));
    }
}