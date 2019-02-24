package arg;

import java.util.Scanner;

public class gedeba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 2; i < n; i++) {
            if(isPrime(i)&&isPrime(n-i)) {
                System.out.print(i+" ");
                System.out.println(n-i);
                return;
            }
        }
    }
    public static boolean isPrime(int n) {
        if(n < 2) return false;
        if(n == 2) return true;
        if(n%2==0) return false;
        for(int i = 3; i*i <= n; i += 2)
            if(n%i == 0) return false;
        return true;
    }
}
