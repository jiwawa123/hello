package StringMy;
import java.util.Scanner;
public class LongestPalindrome {

    /*
     * 最长回文子串(动态规划解决方法)
     * 思路:pal数组标记位于j~i之间串是否为回文子串
     * 若判断j~i间是否为回文子串，需依赖于 j+1 ~ i-1间子串类型，依此类推
     * 直到依赖项为x或者xy,(x,y未知)(仔细体会为什么是这样)
     * i-j<2 :用于判断x或者xy的情况,当然不要忽略&&的短路效应
     */
    public static int longestPalindrome(String str){
        int n=str.length();
        boolean[][] pal=new boolean[n][n];
        int maxLen=0;
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(str.charAt(i)==str.charAt(j) && (i-j<2 || pal[j+1][i-1]==true)){
                    pal[j][i]=true;
                    maxLen=Math.max(maxLen, i-j+1);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // Is PAT&TAP symmetric?
        //result:11
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(longestPalindrome(str));
    }
}
