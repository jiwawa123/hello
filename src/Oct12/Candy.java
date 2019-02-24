package Oct12;

import java.util.Scanner;

public class Candy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            String f = sc.next();
            String s = sc.next();
            char fa = f.charAt(f.length()-1);
            char sa = s.charAt(s.length()-1);
            if((fa=='2'||fa=='3'||fa=='7'||fa=='8')&&(sa=='2'||sa=='3'||sa=='7'||sa=='8'))
                System.out.println("Shadow");
            else
                System.out.println("Matrix67");
        }
    }

}
