package Dec5;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {

    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            int s1 = 0, s2 = 0;
            while (s1 < words[i].length() && s2 < words[i + 1].length()) {
                if (map.get(words[i].charAt(s1++)) > map.get(words[i + 1].charAt(s2++)))
                    return false;
            }
            if (s1 < words[i].length())
                return false;
        }
        return true;
    }

    //最小删除
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int dp[][] = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i < len2 + 1; i++) {
            dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
        }
        for (int i = 1; i < len1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
            for (int j = 1; j < len2 + 1; j++) {
                if(s1.charAt(i-1)==s1.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j]+s2.charAt(j),dp[i][j-1]+s1.charAt(i));
                }
            }
        }
        return dp[len1][len2];
    }
    //反转数字达到递增
    //创建两个数组一个存放在此之前0的个数，一个用来存放在此之后1的个数，三次循环就能结束
    public int minFlipsMonoIncr(String S) {
        if(null==S||S.length()<=1)
            return 0;
        int zero[] = new int[S.length()];
        int one[] = new int[S.length()];
        for (int i = 1; i <S.length() ; i++) {
            if(S.charAt(i-1)=='1')
                zero[i] = zero[i-1]+1;
            else
                zero[i] = zero[i-1];
        }
        int count = Integer.MAX_VALUE;
        for (int i = S.length()-2; i >=0 ; i--) {
            if(S.charAt(i+1)=='1')
                zero[i] = zero[i+1]+1;
            else
                zero[i] = zero[i+1];
            count = Math.min(zero[i]+one[i],count);
        }
        return count;
    }
}
