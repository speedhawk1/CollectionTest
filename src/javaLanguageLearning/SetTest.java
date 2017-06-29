package javaLanguageLearning;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/8.
 */
public class SetTest {

    static Set collectBySet(String strTest){
        String[] strTestArray = strTest.split(" ");
        return new HashSet(Arrays.asList(strTestArray));
    }

    public static void main(String[] args) {
        String strTest = "mine is blue and the blue is mine.";
        StdOut.print(collectBySet(strTest) + "and" +"\t"+ collectBySet(strTest).size());
    }


}
