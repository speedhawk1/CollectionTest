import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/4.
 */
public class SetTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter words,please...");
        // 输入单词
        Set words = tokenSet(scanner.nextLine());
        // tokenSet方法
        System.out.printf("unrepeat words are %d :%s%n" , words.size(), words);
    }

    static Set tokenSet(String line){
        String[] tokens = line.split(" ");
        return new HashSet(Arrays.asList(tokens));
    }
}
