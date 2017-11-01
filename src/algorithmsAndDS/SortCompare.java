package algorithmsAndDS;

import edu.princeton.cs.algs4.*;

/**
 * Created by Administrator on 2017/11/1.
 */
public class SortCompare {

    public static double time(String alg, Comparable[] a){
        Stopwatch timer = new Stopwatch(); // 计时；
        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Selection")) Selection.sort(a);
        if(alg.equals("Shell")) Shell.sort(a);
        if(alg.equals("Merge")) Merge.sort(a);
        if(alg.equals("Quick")) Quick.sort(a);
        if(alg.equals("Heap")) Heap.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomImput(String alg,int N,int TEST){
        Double total = 0.0;   // 使用具体算法给随机数组排序
        Double[] as = new Double[N];
        for (int i = 0; i < TEST ; i++) {  // 执行测生成的数组
            for (int j = 0; j < N; j++) {
                as[j] = StdRandom.uniform();
            }
            total += time(alg,as);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Selection";
        int N = 2000;
        int T = 110;
        double t1 = timeRandomImput(alg1,N,T);
        double t2 = timeRandomImput(alg2,N,T);
        StdOut.printf("For %d random Doubles\n   %s is",N,alg1);
        StdOut.printf("%.1f times faster than %s\n",t2/t1,alg2);
        /*Double a = StdRandom.uniform();
        Double b = StdRandom.uniform();
        StdOut.print(a.compareTo(b) > 0);*/
    }
}
