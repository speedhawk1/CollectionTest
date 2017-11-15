package algorithmsAndDS;

/**
 * 自顶向下的归并排序：
 * 算法过程：
 * 算法优化方案：
 * 1、对小规模数组改为插入-归并排序；
 * 2、添加mid <= mid +1 判定代码；为真则跳过merge步骤（已证明做如此改动则算法变为线性级别；
 * 3、取消辅助数组的使用，删除复制数组的步骤。
 */
public class MergeFromUpToDown {

    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length - 1);
    }

    public static void sort(Comparable[] a,int lo,int hi){
//        try{
//            boolean b = lo <= hi;
//        }catch (Exception e){
//            throw e;
//        }finally {
//            lo = 0;hi = 10;
//        }
        if(hi<=lo) return;

        int mid = lo + (hi - lo)/2;
        sort(a,lo,mid);    //  将原数组逐层缩减
        sort(a,mid+1,hi);
        if(mid <= mid+1) return;   // 这里数量级为线性级别？？证明？
        else {
            Merge.merge(a, lo, mid, hi);
        }
    }
}
