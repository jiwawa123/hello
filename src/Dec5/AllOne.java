package Dec5;

import java.util.*;

public class AllOne {
    Map<String, Integer> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public AllOne() {

    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (map.containsKey(key))
            map.put(key, map.get(key) - 1);
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        if (map.isEmpty())
            return "";
        int max = Integer.MIN_VALUE;
        String tmp = "";
        for (String str : map.keySet()
                ) {
            if (max < map.get(str)) {
                max = map.get(str);
                tmp = str;
            }
        }
        return tmp;
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        if (map.isEmpty())
            return "";
        int max = Integer.MAX_VALUE;
        String tmp = "";
        for (String str : map.keySet()
                ) {
            if (max > map.get(str)) {
                max = map.get(str);
                tmp = str;
            }
        }
        return tmp;
    }

    public int findLength(int[] A, int[] B) {
        int dp[][] = new int[A.length][B.length];
        int res = 0;
        for (int i = 0; i<1; i++) {
            for (int j = 0; j <B.length ; j++) {
                if(A[i]==B[j]){
                    dp[i][j] =1;
                    res = 1;
                }
            }
        }
        for (int i = 0; i <1; i++) {
            for (int j = 0; j < A.length; j++) {
                if(A[j]==B[i])
                {
                    dp[j][i] = 1;
                    res = 1;
                }
            }
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if(A[i]==B[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res;
    }

}
