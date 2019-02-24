package Oct12;

import java.util.Scanner;

public class OJLD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            if(m<n){
                int t = n;
                n = m;
                m = t;
            }
            int f=1;//表示Stan赢
            while(m/n==1&&m%n!=0)//在一开始就是AdivB=1的情况
            {
                int t=m%n;
                m=n;
                n=t;
                f=-f;
            }
            if(f==1)
                System.out.println("Stan wins");
            else
                System.out.println("Ollie wins");
        }
    }
}
