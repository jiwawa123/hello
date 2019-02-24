package arg;

import java.util.Scanner;

public class zheng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = n; i <= 2000; i++) {
            if(num(i)==n){
                count ++;
                System.out.println(i);
            }
        }
        if(count==0)
            System.out.println("NO SOLUTION");
    }
    public static int num(int n){ //返回的是因子总数
        int count=2;
        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(n%i==0){
                if(i==(int)Math.sqrt(n) && n/i==i){ //如果两因子相同，则只加1
                    count++;
                }
                else count+=2;
            }
        }
        return count;
    }
}
