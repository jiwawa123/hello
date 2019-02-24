package HomeWork4;

import java.util.Scanner;

public class God {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 4) {
            System.out.println(0);
            return;
        }
        int count = 0, f = 0, c = 0;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = f; j < i; j++) {
                if (arr[i] == arr[j]) {
                    c++;
                    arr[i] = arr[j] = 0;
                    if (c == 2) {
                        count++;
                        c = 0;
                        f = i;
                    }
                    break;
                }
            }

        }
        System.out.println(count);
        return;
    }
}
