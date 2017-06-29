package algorithmsAndDS;


import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Administrator on 2017/5/2.
 */
public class BinaryInstanceTest {
    public static void main(String[] args) {
        int[] a = {45,23,333,1233,353,534};
        int key = 333;
        StdOut.print(BinarySearch.indexOf(a,key));
    }
}
