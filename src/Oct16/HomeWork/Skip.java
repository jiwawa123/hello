package Oct16.HomeWork;

import java.util.Scanner;

public class Skip {
    static int n, m;
    static int a[][] = new int[501][501];
    static int dp[][] = new int[501][501];
    static int vis[][] = new int[501][501];
    static int ans;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                a[i][j] = sc.nextInt();
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                dfs(i, j);
        System.out.println(ans);
        return;
    }

    public static int dfs(int x, int y) {
        if (vis[x][y] != 0) return dp[x][y];
        vis[x][y] = 1;
        int flag = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 1 || nx > n || ny < 1 || ny > m || a[nx][ny] >= a[x][y]) continue;
            flag = 1;
            dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
        }
        if (flag == 0) dp[x][y] = 1;
        ans = Math.max(ans, dp[x][y]);
        return dp[x][y];
    }


}