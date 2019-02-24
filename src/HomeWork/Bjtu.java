package HomeWork;

import java.util.Scanner;

public class Bjtu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int one = 0;
        int two = 0 ;
        for (int i = 0; i < n; i++) {
            if(sc.nextInt()==1)
                one++;
            else
                two++;
        }
        if(one<=two){
            System.out.println(one);
            return;
        }else{
            int res = two+(one-two)/3;
            System.out.println(res);
        }

    }
}
