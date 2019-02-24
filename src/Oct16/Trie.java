package Oct16;

import Oct15.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Trie {
    List<String> list = new ArrayList<>();

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        list.add(word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (list.indexOf(word) != -1)
            return true;
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        for (String str : list
                ) {
            if (str.length() < prefix.length())
                continue;
            else {
                if (str.substring(0, prefix.length()).equals(prefix))
                    return true;
            }
        }
        return false;
    }

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0)
            return false;
        List<Integer> list = new ArrayList<>();
        for (int k : hand
                ) {
            list.add(k);
        }
        Collections.sort(list);
        while (list.size() > 0) {
            int k = 1;
            int temp = list.get(0);
            list.remove(0);
            while (k < W) {
                if (list.indexOf(temp + 1) == -1) {
                    return false;
                } else {
                    list.remove(list.indexOf(temp + 1));
                    temp++;
                    k++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2,5};
        new Trie().canPartition(arr);
    }

    public boolean canPartition(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }
        if(count%2!=0)
            return false;
        int mean = count/2;
        int arr[][] = new int[nums.length+1][mean+1];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 0;
        }
        for (int i = 0; i < arr[0].length; i++) {
            arr[0][i] = 0;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if(j>=nums[i-1]){
                    arr[i][j] = Math.max(arr[i-1][j-nums[i-1]]+nums[i-1],arr[i-1][j]);
                }else{
                    arr[i][j] = arr[i-1][j];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        return arr[arr.length-1][arr[0].length-1] == mean;

    }
    public int partitionDisjoint(int[] A) {
        int left = 1;
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
           if(max<A[0])
               continue;
           else
               left++;
        }
        return left;
    }
    public int minSubArrayLen(int s, int[] nums) {
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int count = nums[i];
            if(count>s)
                continue;
            for (int j = i+1; j < nums.length; j++) {
                count+=nums[j];
                if(count==s){
                    len = Math.min(len,j-i);
                    break;
                }else if(count>s)
                    break;
            }
        }
        return len;
    }
}
