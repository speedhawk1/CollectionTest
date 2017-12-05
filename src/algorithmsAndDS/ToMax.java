package algorithmsAndDS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Administrator on 2017/12/5.
 */
public class ToMax {

    private String[] strs;
    private int i = 0;
    private int l;

    public ToMax(int leng){strs = new String[leng+1];}

    public void add(String str){
        if(i == 0){
            strs[++i] = str;
        }else{
            strs[++i] = str;
            swam(1,i);
        }

    }  //增加一个元素并选出最大元素置于栈顶；

    public String removeMax(){
        String str = strs[1];
        exchange(1,i--);
        sink(1,i);
        return str;
    }  // 删除最大元素；

    public void swam(int x,int y){
        while(y > x){
            if(!lessThan(strs,y,y/2)) exchange(y,y/2);
            y = y/2;
        }
    }

    public void sink(int x,int y){
        while(2*x <= y){
            int k = 2*x;
            if(k < y && lessThan(strs,k,k+1)) k++;
            exchange(x,k);
            if(2*k > y || !lessThan(strs,k,2*k)) break;
            x = k;
        }
    }

    public boolean lessThan(String[] a,int x,int y){return a[x].compareTo(a[y]) < 0;}  // 比较

    public void exchange(int x,int y){String str = strs[x];strs[x] = strs[y];strs[y] = str;}  // 交换

    public static void main(String[] args) throws IOException {
        ToMax tm = new ToMax(30);
        BufferedReader br = new BufferedReader(new FileReader("F:/readtest.txt"));
        String str = "";
        while(!(str.equals("damn"))){   // 为何while((str = br.readLine()) != null)总是隔一个输出？
            str = br.readLine();
            if(str.equals("*")){
                System.out.println(tm.removeMax());
            }else {
                tm.add(str);
//                System.out.println(tm.i + tm.strs[tm.i]);
            }
        }
        br.close();
    }
}
