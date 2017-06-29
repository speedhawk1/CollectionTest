package javaLanguageLearning;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/11.
 */
public class InterableTesting {

    static void foreach(Iterable<String> iterable){

        Iterator iterator = iterable.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        foreach(set);
        StdOut.println("over");
    }
}
