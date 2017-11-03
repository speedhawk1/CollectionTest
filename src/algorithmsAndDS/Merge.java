package algorithmsAndDS;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Administrator on 2017/11/3.
 */
public class Merge {

    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }

    public static void merge(Comparable[] a,int lo,int mid,int hi){
        Comparable[] aux = new Comparable[a.length+1];
        aux[a.length] = "zzzzzzzzzzzzzzzzz";
        for (int k = lo; k < hi ; k++) {
            aux[k] = a[k];
        }
        int i = lo;int j = mid + 1;
        for (int k = lo; k < hi; k++) {
             if(i>mid){
                a[k] = aux[j++];
            } else if(j>hi){
                a[k] = aux[i++];
            } else if(less(aux[j],aux[i])){
                a[k] = aux[j++];
            } else{
                a[k] = aux[i++];
            }
        }
    }

    public static void show(Comparable[] a){
        for (int i = 0; i < a.length ; i++) {
            StdOut.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        String[] test = {"f","o","r","e","x","a","m","p","l","e"};
        int mid = test.length/2 - 1;
        merge(test,0,mid,test.length);
        show(test);
    }
}
