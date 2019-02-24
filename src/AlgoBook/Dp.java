package AlgoBook;

public class Dp {
    public static void main(String[] args) {

    }
    //数位dp
    int f[][] = new int[10][10];
    public void golf(){
        f[0][0]=1;
        for (int i=1;i<10;i++)
        {
            for (int j=0;j<10;j++)
            {
                if (j==4) f[i][j]=0;
                else if (j==6)
                {
                    for (int k=0;k<10;k++)
                        f[i][j]+=f[i-1][k];
                    f[i][j]-=f[i-1][2];
                }
                else
                {
                    for (int k=0;k<10;k++)
                        f[i][j]+=f[i-1][k];
                }
            }
        }
    }
    int a[] = new int[10];
    int solve(int n)
    {
        a[0]=0;
        while (n>0)
        {
            a[++a[0]]=n%10;
            n/=10;
        }
        a[a[0]+1]=0;
        int  ans=0;
        for (int i=a[0];i>=1;i--)
        {
            for (int j=0;j<a[i];j++)
                if (j!=4 && !(a[i+1]==6 && j==2))
                    ans+=f[i][j];
            if (a[i]==4) break;
            if (a[i+1]==6 && a[i]==2) break;
        }
        return ans;
    }

}
