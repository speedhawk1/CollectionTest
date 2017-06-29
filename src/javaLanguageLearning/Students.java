package javaLanguageLearning;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/8.
 */
public class Students {
    private String name;
    private int age;

    public Students(String name,int age){
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Students stu1 = new Students("zhangsan",19);
        Students stu2 = new Students("lisi",20);
        Students stu3 = new Students("zhangsan",19);
        Set set = new HashSet();
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);
        System.out.print(set);
    }
}
