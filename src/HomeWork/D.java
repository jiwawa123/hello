package HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i < 81; i++) {
            int x = (int)(b * (int)Math.pow(i, a) + c + 0.5);
            if(i==S(x))
                l.add(x);
        }
        System.out.println(l.size());
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i));
            if (i!=l.size()-1)
                System.out.print(" ");
        }
    }

    public static int S(long a) {
        int tmp = 0;
        while (a > 0) {
            tmp += a % 10;
            a /= 10;
        }
        return tmp;
    }

}
