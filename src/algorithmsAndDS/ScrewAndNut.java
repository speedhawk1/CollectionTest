/*
*˼·��1������һ����ñ���ݶ������з֣�
		2�������ݶ����з�ֵ����ñ�з֣���ʱ�ݶ�����ñ�ֱ𱻷ֳ�2�����飻
		3�����ݶ�����ñ��2�������ٷֱ��ظ�1��2���衣
*/

public class ScrewAndNut{
	
	private static final int N = 10	;

	public static int partitation(Comparable[] a,Comparable[] b,int lo,int hi){
		// �Ľ��зַ�1��
		Comparable v = b[lo];
		int parter;
		int i = lo + 1; 
		int j = hi;  // һ��Ϊa.length - 1;
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
		// �Ľ��зַ�2��
		int parter;
		int i = lo + 1; 
		int j = hi;  // һ��Ϊa.length - 1;
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
		 // ͨ����ñ���ݶ��з֣�
		int k = partitation(a,b,lo,hi); 
		// ͨ���ݶ�����ñ�з֣�
		partitation(b,a[k],lo,hi);
		sort(a,b,lo,k-1);
		sort(a,b,k+1,hi);
	}
	
	public static void main(String args[]){
		Comparable[] screw = new Comparable[N];
		Comparable[] nut = new Comparable[N];
		for(int i = 0;i < N;i++){
		// ��ι���һ�����ظ�������飿
			a[i] = 100*Math.random();
			b[i] = 100*Math.random();
		}
		sort(a,b,0,N-1);
		for(int i = 0;i < N;i++){
			System.out.println(a[i] + "," + b[i]);
		}
	}
}