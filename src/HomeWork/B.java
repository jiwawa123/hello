package HomeWork;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int dp[][] = new int[n][n];
        int sum[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
            sum[i][i] = arr[i];
            for (int j = i + 1; j < n; j++)
                sum[i][j] = sum[i][j - 1] + arr[j];
        }
        for (int len = 2; len < n; len++)//归并的石子长度
        {
            for (int i = 0; i < n - len + 1; i++)//i为起点，j为终点
            {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    if (dp[i][j] > dp[i][k] + dp[k + 1][j] + sum[i][j])
                        dp[i][j] = dp[i][k] + dp[k + 1][j] + sum[i][j];
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
}
