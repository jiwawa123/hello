package Exam;


import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        long MOD=1000000007;
        long dp[][] = new long[1005][1005];
        for(int i=1;i<=9;i++){
            if(i==3)
                continue;
            dp[1][i%d]++;
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<=9;j++){
                if(j==3)
                    continue;
                for(int k=0;k<d;k++){
                    if(dp[i-1][k]==0)
                        continue;
                    dp[i][(k*10+j)%d]=(dp[i][(k*10+j)%d]+dp[i-1][k])%MOD;
                }
            }
        }
        System.out.println(dp[n][0]);
    }
}
