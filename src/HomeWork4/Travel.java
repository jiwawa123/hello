package HomeWork4;

import java.util.Scanner;

public class Travel {
    static boolean flag[];
    static int n,m,v;
    static int a[],b[],t[];
    static int chafen[];
    static boolean exist[];
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();
         v = sc.nextInt();
        a = new int[20];
        b = new int[20];
        t = new int[20];
        chafen = new int[20];
        flag = new boolean[20];
        exist = new boolean[20];
        for (int i = 1; i <=m ; i++) {
            a[i] =sc.nextInt();
            b[i] =sc.nextInt();
            t[i] =sc.nextInt();
        }
        dfs(1);
        System.out.println(result);
    }
    public static boolean check(){
        int total=0;
        for(int i=1;i<=n;i++){
            total+=chafen[i];
            if(total>v)
                return false;
        }
        return true;
    }
    public static void dfs(int dep){
        if(dep==m+1){
            for(int i=1;i<=n;i++) chafen[i]=0;//初始化
            int temp=0;
            for(int i=1;i<=m;i++)
                if(exist[i]){
                    chafen[a[i]]+=t[i];//构造括号序列
                    chafen[b[i]]-=t[i];
                    temp+=(b[i]-a[i])*t[i];//计算当前方案总价钱
                }
            if(check())result=Math.max(result,temp);//统计最大价钱
            return;
        }
        dfs(dep+1);
        exist[dep]=true;//1代表上
        dfs(dep+1);
        exist[dep]=false;//0代表不上
    }
}
