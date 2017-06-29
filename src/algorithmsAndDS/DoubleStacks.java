package algorithmsAndDS;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * Created by Administrator on 2017/6/27.
 */
public class DoubleStacks {

    public static void main(String[] args) {
        Stack<Double> var = new Stack<>();
        Stack<String> ops = new Stack<>();
        while (!(StdIn.isEmpty())) {
            //把输入字符串读取至v;
            String v = StdIn.readString();
            //忽略左括号
            if (v.equals("("));
            // 若输入运算符号及sqrt函数时，将之压入ops栈；
            else if (v.equals("+")){
                ops.push(v);
//                StdOut.print(ops.size());
            }
            else if (v.equals("-")){
                ops.push(v);
            }
            else if (v.equals("*")){
                ops.push(v);
            }
            else if (v.equals("/")){
                ops.push(v);
            }
            else if (v.equals("sqrt")){
                ops.push(v);
            }
            // 若输入右括号，则将取出最近2个操作数及1个运算符计算后压入var栈；
            else if (v.equals(")")) {
                Double va = var.pop();
                String op = ops.pop();
                if (op.equals("+")) {
                    va += var.pop();
                } else if (op.equals("-")) {
                    va = var.pop() - va;
                } else if (op.equals("*")) {
                    va = var.pop() * va;
                } else if (op.equals("/")) {
                    va = var.pop() * va;
                } else if (op.equals("sqrt")) {
                    va = Math.sqrt(va);
                }
                var.push(va);
            }else{
                var.push(Double.valueOf(v));
//                StdOut.print(var.size());
            }
        }
        StdOut.print(var.pop());
    }
}
