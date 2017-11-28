package algorithmsAndDS;

/*
*思路：对快速排序算法稍加改动。
*       1、先用一个螺帽对螺钉进行切分；
		2、再用螺钉的切分值对螺帽切分；此时螺钉和螺帽分别被分成2个数组；
		3、对螺钉和螺帽的2个数组再分别重复1和2步骤。
* */
public class ScrewAndNut{
	
	private static final int N = 10	;

	public static int partitation(Comparable[] a,Comparable[] b,int lo,int hi){
        /* 改进切分法1； */
		Comparable v = b[lo];
		int parter = 0;
		int i = lo + 1; 
		int j = hi;  // 一般为a.length - 1;
		while(true){
			while(v.compareTo(a[++i]) <= 0) if(a[i] == v) parter = i++; if(i >= hi) break;
			while(v.compareTo(a[--j]) >= 0) if(a[j] == v) parter = j--; if(j <= lo) break;
			if(i>=j) break;
			exchange(a,i,j);
		}
		exchange(a,parter,j);
		return j;
	}
	
	public static void partitation(Comparable[] a,Comparable v,int lo,int hi){
        // 改进切分法2；
		int parter = 0;
		int i = lo + 1; 
		int j = hi;
		while(true){
			while(v.compareTo(a[++i]) <= 0) if(a[i] == v) parter = i++; if(i >= hi) break;
			while(v.compareTo(a[--j]) >= 0) if(a[j] == v) parter = j--; if(j <= lo) break;
			if(i>=j) break;
			exchange(a,i,j);
		}
		exchange(a,parter,j);
	}
	
	public static void exchange(Comparable[] a,int i,int j){
		Comparable exch = a[i];a[i] = a[j];a[j] = exch;
	}
	
	public static void sort(Comparable[] a,Comparable[] b,int lo,int hi){
		if(hi <= lo) return;
        // 通过螺帽对螺钉切分；
		int k = partitation(a,b,lo,hi);
        // 通过螺钉对螺帽切分；
		partitation(b,a[k],lo,hi);
		sort(a,b,lo,k-1);  //递归调用
		sort(a,b,k+1,hi);
	}
	
	public static void main(String args[]){
		Comparable[] screw = new Comparable[N];
		Comparable[] nut = new Comparable[N];
		for(int i = 0;i < N;i++){
            // 如何构造一个无重复项的数组？
			screw[i] = 100*Math.random();
			nut[i] = 100*Math.random();
		}
		sort(screw,nut,0,N-1);
		for(int i = 0;i < N;i++){
			System.out.println(screw[i] + "," + nut[i]);
		}
	}
}