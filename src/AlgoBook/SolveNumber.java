package AlgoBook;

public class SolveNumber {
    static int total = 0;
    public static void main(String[] args) {
        solve(4);
        System.out.println(total);
    }
    //通过递归实现求整数的分解式子
    public static void solve (int n)
    {
        if (n==1)
            total++;
        else//实行从小到大开始遍历
            for (int i=2; i<=n; i++)
                if (n%i==0)
                    solve (n/i);
    }
}
