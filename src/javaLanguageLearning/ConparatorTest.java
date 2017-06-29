package javaLanguageLearning;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
public class ConparatorTest {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("c","o","m","p","r","a","t","o","r");
        list.sort(String::compareTo);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        StdOut.print(list);
    }
}
