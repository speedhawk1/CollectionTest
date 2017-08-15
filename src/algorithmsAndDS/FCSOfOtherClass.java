package algorithmsAndDS;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by Administrator on 2017/7/6.
 */
public class FCSOfOtherClass<Double> implements Iterable<Double>{
    private int n;
    private Double[] a;

    public FCSOfOtherClass() {
    }

    public FCSOfOtherClass(int cap) {
        a = (Double[]) new Object[cap];
    }

    public void push(Double dou) {
        if (a.length == n) {
            this.resize(2 * a.length);
            a[n++] = dou;
        } else {
            a[n++] = dou;
        }
    }

    private void resize(int max) {
        Double[] newa = (Double[]) new Object[max];
        for (int i = 0; i < n; i++) {
            newa[i] = a[i];
            a = newa;
        }
    }

    public Boolean isEmpty() {
        return n == 0;
    }

    public Double pop() {
        Double dou = a[--n];
        a[n] = null;
        if (n > 0 && n == a.length / 2) {
            resize(a.length / 2);
        }
        return dou;
    }

    public int size() {
        return n;
    }

    public Iterator<Double> iterator() {
        return new RAIterator();
    }

    private class RAIterator implements Iterator<Double> {
        private int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Double next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super Double> action) {

        }

//        @Override
//        public boolean hasNext() {
//            return i > 0;
//        }
//
//        @Override
//        public Double next() {
//            return a[--i];
//        }
//
//        @Override
//        public void foreachRemaining(Consumer action){
//
//        }
    }

//    public static void main(String[] args) {
//        FCSOfOtherClass<String> fcs = new FCSOfOtherClass<>(100);
//        while(!StdIn.isEmpty()){
//            String str = StdIn.readString();
//            if (str.equals("-")) {
//                StdOut.print("The last element " + fcs.pop().toUpperCase() + " is already poped,now only " + fcs.size() + " elements in the stack.");
//            }else{
//                fcs.push(str);
//            }
//        }
//    }

    public static <Double> FCSOfOtherClass<Double> copy(FCSOfOtherClass<Double> fcsOfOtherClass){
        // copy方法功能是运用迭代器将fcsOfOtherClass栈中元素迭代至另一个FCSOfOtherClass<Double>类对象中；
        Iterator<Double> iterator = fcsOfOtherClass.iterator();
        FCSOfOtherClass<Double> result = new FCSOfOtherClass<>();
        FCSOfOtherClass<Double> temp = new FCSOfOtherClass<>();
        while (iterator.hasNext()) {
            temp.push(iterator.next());  //？为何要存在一个temp类，而不直接将原栈中的元素转移到result中并返回？？
        }
        iterator = temp.iterator();
        while(iterator.hasNext()){
            result.push(iterator.next());
        }
        return result;
    }
    public static void main(String[] args) {
        FCSOfOtherClass<Integer> fcs = new FCSOfOtherClass<>(4);
        int i = 0;
        while (!StdIn.isEmpty()) {
            fcs.push(++i);
            StdOut.print(fcs.n);
        }
        for (int j:fcs) {
            StdOut.print(j);
        }
    }
}

