package javaLanguageLearning;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
public class Judgement {
    public static void main(String[] args) {
        String[] words = {"RADAR","WARTER START","MILK KLIM","RESERVERED","IWI","ACCA"};
        for (int i = 0; i < words.length; i++) {
            // 分割words中的字符串
            List<String> list = Arrays.asList(words[i].split(""));
//            Deque<String> queue = new LinkedList<>(Arrays.asList(words[i]));
//            StdOut.println(list.size());

            // 将words中的字符串填入Deque中
            Deque<String> queue = new ArrayDeque<>();
            list.forEach(queue::offer);
            while(queue.pollFirst().equals(queue.pollLast())){
                if(queue.size()%2 == 0){
                    if(queue.size()==2){
                        if(queue.pollFirst().equals(queue.pollLast())){
                            StdOut.println(words[i]);
                            break;
                        }
                    }
                }else if(queue.size()%2 == 1){
                    if(queue.size()==1){
                        StdOut.println(words[i]);
                    }
                }
            }
            }
        }
    }






