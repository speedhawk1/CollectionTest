import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by Administrator on 2017/4/3.
 */
public class Guest {

    public static void main(String[] args) {
        List names = new ArrayList();
        collectNameTo(names);
        // to collect objects into "names"
        out.println("VisitorNames");
        printUpperCase(names);
    }

    public static void collectNameTo(List names) {

        Scanner console = new Scanner(System.in);
        while (true) {
            out.print("VisitorName:");
            String name = console.nextLine();
            if (name.equals("quit")) {
                break;
            }
            names.add(name);
        }
    }

    static void printUpperCase(List names){
        for (int i = 0; i < names.size() ; i++) {
            String name = (String) names.get(i);
            out.println(name.toUpperCase());
        }
    }
}


