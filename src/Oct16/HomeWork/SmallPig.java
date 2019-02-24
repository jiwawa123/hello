package Oct16.HomeWork;

import java.util.Scanner;

public class SmallPig {
    public static int arr[][] = new int[1001][1001];
    public static int array[][] = new int[1001][1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        array[1][1] = arr[1][1];
        for(int i=2;i<=n;i++)//一层一层往上推
        {
            for(int j=2;j<i;j++)//先求出从上一层推出来的最小值
                array[i][j]=Math.min(array[i-1][j],array[i-1][j-1])+arr[i][j];
            array[i][1]=Math.min(array[i-1][1],array[i-1][i-1])+arr[i][1];//特殊边界点处理
            array[i][i]=Math.min(array[i-1][i-1],array[i-1][1])+arr[i][i];//特殊边界点处理
            //同一层更新最优解
            for(int k=i-1;k>0;k--)//从右往左推 从右往左走的情况更新
                array[i][k]=Math.min(array[i][k],array[i][k+1]+arr[i][k]);
            array[i][i]=Math.min(array[i][i],array[i][1]+arr[i][i]);

            for(int l=2;l<=i;l++)//从左往右推 从左往右走的情况更新
                array[i][l]=Math.min(array[i][l],array[i][l-1]+arr[i][l]);
            array[i][1]=Math.min(array[i][1],array[i][i]+arr[i][1]);

            for(int k=i-1;k>0;k--)//再推一遍从右往左推 从右往左走的情况更新
                array[i][k]=Math.min(array[i][k],array[i][k+1]+arr[i][k]);
            array[i][i]=Math.min(array[i][i],array[i][1]+arr[i][i]);

            for(int l=2;l<=i;l++)//再推一遍从左往右推 从左往右走的情况更新
                array[i][l]=Math.min(array[i][l],array[i][l-1]+arr[i][l]);
            array[i][1]=Math.min(array[i][1],array[i][i]+arr[i][1]);
        }
        System.out.println(array[n][1]);
        return ;
    }
}
