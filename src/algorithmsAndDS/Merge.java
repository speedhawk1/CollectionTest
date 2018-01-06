package algorithmsAndDS;

import edu.princeton.cs.algs4.StdOut;

/**
 * 这种归并并非十分严谨，因为：1、对于子数组遗留的元素无法进一步排序。2、有越界异常的可能（Row16的设计就是防止越界异常）。
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
                 /*关于此时为何会出现越界异常
                 * if...else if...语句执行流程为：遇到条件为真的语句就执行对应的语句，之后
                 * 跳过之后的其他条件并退出，在这之前会一直寻找条件为真的语句。在此程序中，当
                 * j达到数组最后一个元素时（此时下标为9），进行j++操作时会使
                 * j越界（操作后j=10)，而最初设定hi = 10（即数组长度），所以j越界后并未满足r24
                 * 中j>hi的判定条件（此时j=hi)。故程序会继续
                 * 向下检索r26的判定条件，这里的aux[j]即会出现越界异常。*/
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

    public static void sort(Comparable[] a) {
    }
}
