package javaLanguageLearning;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Administrator on 2017/6/15.
 */
public class IterableString {
    public static void main(String[] args) {
//        List<String> list = new LinkedList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        list.forEach(System.out::println);


        Queue<String> queue = new ArrayDeque<>();
        queue.add("aaa");
        queue.add("bbb");
        queue.add("ccc");
        queue.add("ddd");
        for (String ignored :queue) {
            System.out.println(queue.poll());
        }
        System.out.println(queue.size());
    }
}
