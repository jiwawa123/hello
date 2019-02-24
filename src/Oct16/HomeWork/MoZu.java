package Oct16.HomeWork;

import java.util.Scanner;

public class MoZu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String array[] = new String[n];
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
            array[i] = sc.next();
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (judge(array[i], array[j])) {
                    arr[i] = arr[j] + 1;
                    break;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, arr[i]);
        }
        System.out.println(result);
    }

    public static boolean judge(String s1, String s2) {
        boolean flag = true;
        int len = s2.length();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                flag = !flag;
                break;
            }
        }
        return flag;
    }
}
