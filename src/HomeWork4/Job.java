package HomeWork4;

import java.util.Scanner;

public class Job {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d[] = new int[555];
        int w[] = new int[555];
        boolean done[] = new boolean[555];
        int count = 0;
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (w[j] < w[j + 1]) {
                    int t = w[j];
                    w[j] = w[j + 1];
                    w[j + 1] = t;
                    t = d[j];
                    d[j] = d[j + 1];
                    d[j + 1] = t;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (j = d[i]; j > 0; j--) {
                if (!done[j]) {
                    done[j] = true;
                    break;
                }

            }
            if (j == 0) {
                count += w[i];
            }
        }
        System.out.println(count);
    }

}
