package Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Josephus {
    static int re = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int t = sc.nextInt();
        jsoephus_func(n,t);
        System.out.println(re);
    }

    private static void jsoephus_func(long totalNum, int cycleNum) {
        //定义链表
        List<Integer> list = new ArrayList<Integer>();
        List<Integer>  resultlist = new ArrayList<Integer>();
        for(int i=1;i<=totalNum;i++){
            list.add(i);
        }
        int count = 0;
        for(int j =0;j<totalNum;j++){
            if(list.size()-count<=cycleNum){
                re+=cycleNum/list.size();
                if(cycleNum%list.size()!=0)
                    re++;
            }
            count = (--count+cycleNum)%list.size();
            System.out.println(list.get(count));
            if(list.get(count)==1)
                return;
            resultlist.add(list.remove(count));
        }

    }

}
