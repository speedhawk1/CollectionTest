package algorithmsAndDS;

import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by Administrator on 2017/7/26.
 */
public class Parentheses {

    private class ArraysStack<Integer> implements Iterable<Integer>{
        private class ArrayLikeIterator implements Iterator<Integer>{
            int i = n;
            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Integer next() {
                return ints[--i];
            }
        }
        private int n;
        private Integer[] ints;
        public ArraysStack(int size){
            ints = (Integer[]) new Object[size];
        }
        public boolean isEmpty(){
            return n == 0;
        }
        public int size(){return n;}
        public void push(Integer inte){
            if(n >= ints.length){
                Integer[] newints = (Integer[]) new Object[2*ints.length];
                for (int i = 0; i < ints.length ; i++) {
                    newints[i] = ints[i];
                }
                ints = newints;
                ints[n++] = inte;
            }else{
                ints[n++] = inte;
            }
        }

        public Integer pop(){
            if(n < ints.length / 2){
                Integer[] newints = (Integer[]) new Object[ints.length / 2];
                for (int i = 0; i < ints.length / 2; i++) {
                    newints[i] = ints[i];
                }
                ints = newints;
                Integer in = ints[--n];
                return in;
            }else{
                Integer in = ints[--n];
                return in;
            }
        }

        @Override
        public Iterator iterator() {
            return new ArrayLikeIterator() ;
        }
    }

    public boolean isFinish(String string){
        Stack<String> commas = new Stack<>();
        String[] strings = string.split("");
        for (int i = 0; i < string.length(); i++) {
            if (Objects.equals(strings[i], "(")) {
                commas.push(strings[i]);
            }if (Objects.equals(strings[i], "[")) {
                commas.push(strings[i]);
            }if (Objects.equals(strings[i], "{")) {
                commas.push(strings[i]);
            }
            else if(Objects.equals(strings[i], ")")){
                commas.pop();
            }else if(Objects.equals(strings[i], "]")){
                commas.pop();
            }else if(Objects.equals(strings[i], "}")){
                commas.pop();
            }
        }
        return commas.isEmpty();
    }
    public static Stack<Integer> copy(Stack<Integer> stack){
        return stack;
    }
    public static void main(String[] args) {
        /*Stack<String> stack = new Stack<>();
        String str = "(aa[{]";
        String[] string = str.split("");
        for (int i = 0; i < string.length ; i++) {
            if (Objects.equals(string[i], "(")) {
                stack.push(string[i]);
            }if (Objects.equals(string[i], "[")) {
                stack.push(string[i]);
            }
        }
        stack.pop();
        stack.pop();
        System.out.print(stack.isEmpty());*/
        /*String str = "{[a*(b-c)]*(d-e)}";
        String[] strs = str.split("");
        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i]+"\t");
        }*/
        Parentheses parentheses = new Parentheses();
        System.out.print(parentheses.isFinish("()["));
    }


}

//自身问题：1、编程经验不足，例如体现于“==”和equals()方法的编译器问题。
//        2、编程习惯欠佳，在编写用例前应当合理规划API并照之执行。
//        2、对问题观察和剖析不到位，例如括号完整性的诸多情况等等。
