package algorithmsAndDS;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdDraw;

/**
 * Created by Administrator on 2017/4/30.
 */
public class JavaRequest {

    public static void main(String[] args) {
        StdDraw.line(0.1,0.1,0.2,0.2);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(0.3,0.3,0.4,0.4);
        int[] a = {45,23,333,1233,353,534};
        BinarySearch.indexOf(a,334);
    }
}
