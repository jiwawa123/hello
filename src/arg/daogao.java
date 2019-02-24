package arg;

import java.util.Scanner;

public class daogao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans=(int)(Math.log((double)n)/Math.log((double)2))+1;
        int tot = 0;
        int f[][][] = new int[11][1005][1005];
        f[1][1][1]=1;
        for(int i=1;i<ans;i++)
            for(int j=i;j<=(1<<(i-1));j++)
                for(int k=i;k<=((1<<i)-1);k++)
                    if(f[i][j][k]!=0)
                        for(int p=j+1;p<=k+1;p++){
                            if(p+k<=n)//如果加起来在范围内
                                f[i+1][p][k+p]+=f[i][j][k];
                            else//加起来不在范围内
                                f[i+1][p][n]+=f[i][j][k];
                        }
        for(int i=1;i<=n;i++)
            tot+=f[ans][i][n];

        System.out.println(ans+" "+tot);;

    }

}
