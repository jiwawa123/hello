package Dec18;

public class MaxLen {
    public static void main(String[] args) {
        System.out.println(new MaxLen().allSum(6, 6));

    }

    public int allSum(int n, int m) {
        if (n == 1 || m == 1)
            return 1;
        else if (n < m)
            return allSum(n, n);
        else if(n==m)
            return 1+allSum(n,n-1);
        else return allSum(n, m - 1) + allSum(n - m, m);
    }

}
