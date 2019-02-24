package Dec1;
//矩阵快速幂
public class Main4_copy {
    public static long[][] multiply(long [][]a,long[][]b){
        long[][]arr=new long[a.length][b[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b[0].length;j++){
                for(int k=0;k<a[0].length;k++){
                    arr[i][j]+=a[i][k]*b[k][j];
                    arr[i][j] %= 7777777;
                }
            }
        }
        return arr;
    }
    public static long[][] multiplyPower(long[][]a,long n){
        long[][] res=new long[a.length][a[0].length];
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                if(i==j)
                    res[i][j]=1;
                else
                    res[i][j]=0;
            }

        }
        while(n!=0){
            if((n&1)==1)
                res=multiply(res,a);
            n>>=1;
            a=multiply(a,a);
        }
        return res;
    }
    public static void main(String[] args) {
        long [][]arr={{1,1},{1,0}};
        long[][]arr1=multiplyPower(arr,100);
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[0].length;j++){
                System.out.print(arr1[i][j]+"   ");
            }
            System.out.println();
        }
    }
}

