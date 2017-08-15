package javaLanguageLearning;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * Created by Administrator on 2017/7/30.
 */
public class ReadTest {
    public static void main(String[] args) {
        Stack<String> test = new Stack<>();
        while(!StdIn.isEmpty()) {
            if(StdIn.readString().equals("+")){

                test.push(StdIn.readString());
                System.out.println(test.pop());
            }
        }
    }
}
