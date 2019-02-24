package Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B {
    static int re = 0;
    static int L = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
         L = sc.nextInt();
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        subsets(arr);
        System.out.println(re);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        dfsCore(res, 0, tmp, nums);
        return res;
    }

    private static void dfsCore(List<List<Integer>> res, int curIdx, List<Integer> tmp, int[] nums) {
        if (curIdx <= nums.length) {
            int count = 0;
            for (int k:tmp
                 ) {
                count+=k;
            }
            if(count<=L){
                re++;
            }
        }
        // 下标从curIdx开始
        for (int i = curIdx; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfsCore(res, i + 1, tmp, nums);
            tmp.remove(tmp.size() - 1);
        }

    }
}
