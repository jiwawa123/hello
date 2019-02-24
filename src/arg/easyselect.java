package arg;

import java.util.Scanner;

public class easyselect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int arr = sc.nextInt(); // 获取每次的长度
            int flag = sc.nextInt(); // 判断是哪个人的选材
            int array[] = new int[arr]; //定义一个数组用来查看谁能赢
            for (int j = 0; j < arr; j++)
                array[j] = sc.nextInt();
            if(flag==0)
                System.out.println("wind");
            else
                System.out.println("lolanv");
        }
    }
}
