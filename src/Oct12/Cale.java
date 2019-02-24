package Oct12;

import java.util.Scanner;

public class Cale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //获取总数
        int n = sc.nextInt();
        String result[] = new String[n];
        for (int i = 0; i < n; i++) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            result[i]=pan(year,month,day);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
        return;
    }
    public static String  pan(int year,int month,int day){
        String result = "YES";
        String result1 = "NO";
        if (month==9&&day==30)
            return result;
        else if (month==1&&day==30)
            return result;
        else if ((month+day)%2==0)
            return result;
        else
            return result1;
    }

}
