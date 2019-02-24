package alter;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int count =0;
        for (int i = 3; i < n; i++) {
            if(Com(i))
                count+=i;
        }
        System.out.println(count);
    }
    public static  boolean Com(int n){
        if(n<=3) {
            return false;
        }
        for (int i = 2; i < n/2; i++) {
            if(n%i==0){
                return true;
            }
        }
        return false;
    }
}
