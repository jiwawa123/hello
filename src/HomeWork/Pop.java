package HomeWork;

import java.util.Scanner;

public class Pop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        if(num<5){
            System.out.println(0);
            return;
        }
        long res = 0;
        while(num>=5){
            long tmp = num/5;
            num = num - tmp*5+(tmp*2);
            res+=tmp;
        }
        System.out.println(res);
    }
}
