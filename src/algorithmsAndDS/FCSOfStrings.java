package algorithmsAndDS;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Administrator on 2017/6/29.
 */
public class FCSOfStrings {

    String[] a;
    int n;
    public FCSOfStrings(int cont){
        a = new String[cont];
    }

    public void push(String str){
        a[n++] = str;
    }

    public String pop(){

        return a[--n];
    }

    public boolean isEmpty(){
        return n==0;
    }

    public int size(){
        return n;
    }

    public static void main(String[] args) {
        FCSOfStrings s = new FCSOfStrings(50);
        while(!StdIn.isEmpty()){
            String s1 = StdIn.readString();
            if (s1.equals("-")) {
                s.pop();
                StdOut.print(s);
            } else if (s1.equals("+")){
                s.push(s1);
                StdOut.print(s);
            } else{
                s.push(s1);
            }
        }

    }
}
