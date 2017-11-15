package algorithmsAndDS;

/**
 * Created by Administrator on 2017/11/13.
 */
public class SortTest {

    static Comparable[] test;

    public static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
    }

    public static void main(String[] args) {
        test = new Comparable[]{"a", "b", "c", "f", "e", "d"};

    }

}
