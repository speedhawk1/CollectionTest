package algorithmsAndDS;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/7/31.
 */
public class  ArrrayQueueOfStrings<Integer> implements Iterable {
    private int n;
    private Integer[] strs;
    private class ArrayQueueIterator implements Iterator<Integer>{
        private int i = n;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Integer next() {
            return strs[--n];
        }
    }

    public ArrrayQueueOfStrings(int size){
        strs = (Integer[]) new Object[size];
    }
    public int size(){return n;}
    public boolean isEmpty(){return n == 0;}
    public void push(Integer str){
        if(strs.length == n){
            Integer[] newstrs = (Integer[]) new Object[2*strs.length];
            for (int i = 0; i < strs.length; i++) {
                newstrs[i] = strs[i];
            }
            strs = newstrs;
            strs[n++] = str;
        }else{
            strs[n++] = str;
        }
    }
    public Integer pop(){
        Integer str = strs[0];
        this.copy();
        n--;
        return str;
    }

    public void copy(){
        Integer[] newstrs;
        if(n <= strs.length/2){
            newstrs = (Integer[]) new Object[strs.length/2];
        }else {
            newstrs = (Integer[]) new Object[strs.length];
        }
        for (int i = 1; i < n; i++) {
            newstrs[i-1] = strs[i];
        }
        strs = newstrs;
    }
    @Override
    public Iterator iterator() {
        return new ArrayQueueIterator();
    }

    public static void main(String[] args) {
        ArrrayQueueOfStrings<String> arrrayQueueOfStrings = new ArrrayQueueOfStrings<>(1);
        arrrayQueueOfStrings.push("aaa");
        arrrayQueueOfStrings.push("bbb");
        arrrayQueueOfStrings.push("ccc");
        arrrayQueueOfStrings.push("ddd");
        System.out.println(arrrayQueueOfStrings.pop());
        System.out.println(arrrayQueueOfStrings.pop());
    }
}

//这是我做的最完美的一道题！！