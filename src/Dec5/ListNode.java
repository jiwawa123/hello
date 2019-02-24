package Dec5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    public int[] diStringMatch(String S) {
        int n = S.length()+1;
        //boolean flag[] = new boolean[n];
        int arr[] = new int[n];
        int left = 0 ,right = n-1;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)=='I'){
                arr[i] = left;
                //flag[left] = true;
                left++;
            }else{
                arr[i] = right;
                //flag[right] = true;
                right--;
            }
        }
        arr[n-1] = left;
        return arr;
    }
    public int minDeletionSize(String[] A) {
        int count = 0;
        if(null==A||A.length<=1)
            return 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length; j++) {
               if(A[j].charAt(i)>A[j+1].charAt(i)){
                   count++;
                   break;
               }
            }
        }
        return count;
    }
}
