package algorithmsAndDS;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**
 * Created by Administrator on 2017/5/16.
 */
public class Exercise1_2_1 {
    public static void main(String[] args) {
        int n = 10;
        /*found the points Array*/
        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            double x = StdRandom.random();
            double y = StdRandom.random();
            Point2D point = new Point2D(x,y);
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.setPenRadius(.01);
            point.draw();
            points[i] = point;
        }
        /*cacculation of the director*/

        Double mindir = .0;
        for (int i = 0; i + 2 < n ; i++) {
            for (int j = 0; j + 1 < n ; j++) {
                if (j <= i) {
                    continue;
                } else {
                    Double dir = points[i].distanceTo(points[i+1])-points[i].distanceTo(points[j+1]);
                    if ((dir >0) == false) {
                        mindir = points[i].distanceTo(points[i+1]);
                    }
                }
            }
        }
        StdOut.println(mindir);
    }
}
