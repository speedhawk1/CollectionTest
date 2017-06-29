package javaLanguageLearning;

import java.util.Set;
import java.util.TreeSet;


/**
 * Created by Administrator on 2017/6/15.
 */
public class MainTest {
    public static void main(String[] args) {
        Set set = new TreeSet();
        set.add(1);
        set.add(2);
        set.add(3);
        for (Object number:set) {
            System.out.println(number);
        }
    }
}
