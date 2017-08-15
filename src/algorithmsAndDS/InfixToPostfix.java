package algorithmsAndDS;

import edu.princeton.cs.algs4.StdIn;

import java.util.Objects;
import java.util.Stack;

/**
 * Created by Administrator on 2017/7/30.
 */
public class InfixToPostfix {
    // ((4+3)*((3-1)*(2+1)))
    // 43+31-21+**
    public static void main(String[] args) {
        Stack<String> numbers = new Stack<>();
        Stack<String> commas = new Stack<>();  //建立数字栈、符号栈；
        while(!StdIn.isEmpty()){
            String str = StdIn.readString();
            if(Objects.equals(str, "(")){ // 若输入左括号则无视

            }else if(Objects.equals(str, "+") || Objects.equals(str, "-") ||Objects.equals(str, "*") ||Objects.equals(str, "/") ){   // 若输入运算符则压入符号栈
                commas.push(str);
            }else if(Objects.equals(str, ")")){ // 若输入右括号则修改相关算式，并将新算式整体压入数字栈，需注意反序排列
                String a = numbers.pop();
                String b = commas.pop() + a + numbers.pop();
                numbers.push(b);
            }else{   // 将数字压入数字栈
                numbers.push(str);
            }
        }
        String postfix = null;
        for (int i = 0; i < numbers.size(); i++) {
            postfix += numbers.pop();
        }
        assert postfix != null;
        for (int i = postfix.length() - 1; i > 0; --i) { // 需注意反序输出
            System.out.print(postfix.charAt(i));
        }
//        System.out.print(postfix.charAt(3));
//        System.out.print(postfix.charAt(2));
//        System.out.print(postfix.charAt(3));
//        System.out.print(postfix.charAt(4));
//        还有习题1.3.11也可以抽空做一下，不过意思差不多
    }
}
