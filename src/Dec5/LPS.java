package Dec5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LPS {
    public static void main(String[] args) {
        String str = "aaabaaca";
        System.out.println(new LPS().longestPalindromeSubseq(str));
    }

    public int longestPalindromeSubseq(String s) {
        if (null == s || s.length() == 0)
            return 0;
        int len = s.length();
        int arr[][] = new int[len][len];
        for (int j = 0; j < len; j++) {
            arr[j][j] = 1;
            for (int i = j-1; i >=0 ; i--) {
                if(s.charAt(i)==s.charAt(j))
                    arr[i][j] = arr[i+1][j-1]+2;
                else
                    arr[i][j] = Math.max(arr[i+1][j],arr[i][j-1]);
            }
        }
        return arr[0][len-1];
    }
    //计算最长子序列的斐波那契数列的长度
    public int lenLongestFibSubseq(int[] A) {
        if(null==A||A.length<=2)
            return 0;

        int res = 0 ;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i],1);
        }
        for (int i = 0; i <A.length ; i++) {
            for (int j = i+1; j < A.length; j++) {
                int x= A[j],y = A[j];
                int len = 2;
                while(map.containsKey(x+y)){
                    int tmp = y;
                    y+=x;
                    x = tmp;
                    len++;
                    res = Math.max(res,len);

                }
            }
        }
        return res;
    }
}
