package arg;

import java.util.Scanner;

public class jishu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(pan(n));
    }
    public static int pan(int n){
        double count = 1;
        for(int i = 2;i < Integer.MAX_VALUE;i++){
            count +=(double) 1/i;
            if(n<count){
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}
