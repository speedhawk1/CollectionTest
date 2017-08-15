package algorithmsAndDS;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Administrator on 2017/7/29.
 */
public class SequenceExpRepairer {
    public static void main(String[] args) {
        Stack<String> numbers = new Stack<>();
        Stack<String> commas = new Stack<>();  // 创建数字栈、符号栈;
        while (!StdIn.isEmpty()) {
            if(StdIn.readString().equals(")")){    // 若输入为右括号，则将前两个数字和前一个字符提取出栈，并添加完整的括号作为新的字符串重新压入shuzizhan中；
                String number = numbers.pop();
                String newnumber = ")" + number + commas.pop() + numbers.pop() + "(";
//                StdOut.print(newnumber);
                numbers.push(newnumber);

//                StdOut.print(numbers.pop());
            }else if(StdIn.readString().equals("+")){   //若输入为符号，则将其压入符号栈中；
                commas.push(StdIn.readString());
                StdOut.print(commas.pop());
            }else{
                numbers.push(StdIn.readString());   // 将数字压入数字栈中
                StdOut.print(numbers.pop());
            }
        }
        String repair = null;
        for (int i = numbers.size(); i > 0; i--) {
            repair += numbers.pop();
        }
        System.out.println(repair);
    }

}
