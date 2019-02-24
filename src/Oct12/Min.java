package Oct12;

import java.util.Scanner;

public class Min {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double tmp = sc.nextDouble();
        while(tmp>18.0) tmp/=18.0;
        if(tmp<=9.0)
            System.out.println("181818181818");
        else
            System.out.println("ZBT");
    }
}
