package javaLanguageLearning;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/6/11.
 */
public class GenericsTest<E> {

    private Object[] elems;
    private int next;

    public GenericsTest(int leng){
        elems = new Object[leng];

    }

    public GenericsTest(){
        this(16);
    }

    public void add(E e){
        if (next == elems.length) {
            elems = Arrays.copyOf(elems,elems.length * 2);
        }
        elems[next++] = e;
    }

    public E get(int index){
        return (E) elems[index];
    }

    public int size(){
        return next;
    }
}
