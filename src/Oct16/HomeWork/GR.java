package Oct16.HomeWork;

import java.util.Arrays;
import java.util.Scanner;

public class GR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 105;
        int max = 10005;
        int tot = 0;
        int v[] = new int[max];
        int f[] = new int[max];
        int len = sc.nextInt(), s = sc.nextInt(), t = sc.nextInt(), m = sc.nextInt();
        int a[] = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        if (s == t) {
            int ans = 0;
            for (int i = 0; i < m; i++)
                if (a[i] % s == 0)
                    ans++;
            System.out.println(ans);
            return;
        }
        Arrays.sort(a);
        v[tot = a[0] % 90] = 1;
        for (int i = 1; i < m; i++)
            v[tot += (a[i] - a[i - 1]) % 90] = 1;
        for (int i = tot; i >= 0; i--) {
            f[i] = 100;
            for (int j = s; j <= t; j++)
                f[i] = Math.min(f[i], f[i + j] + v[i]);
        }
        System.out.println(f[0]);
        return ;
    }
}
