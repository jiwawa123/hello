package DP;

import java.util.*;

public class Combination {
    public static void main(String[] args) {
        Combination combination = new Combination();
        combination.combine(4,2);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(res, temp, n, k, 1);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int n, int k, int m) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = m; i <= n; i++) {
            temp.add(i);
            dfs(res, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    public int[] fairCandySwap(int[] A, int[] B) {
        int a = 0;
        int b = 0;
        int re[] = {0,0};
        Map<Integer,Integer> m2 = new HashMap<>();
        //计算两个人的总和
        for (int k:A
             ) {
            a+=k;
        }
        for (int k:B
             ) {
            b+=k;
            m2.put(k,2);
        }
        if(a==b)
            return re;
        int mean = (a+b)/2;
        for (int i = 0; i < A.length; i++) {
                int k = mean - a + A[i];
                if(m2.containsKey(k)) {
                    re[0] = A[i];
                    re[1] = k;
                    break;
                }
        }
        return re;
    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums==null)
            return null;
        int m = nums.length;
        int n = nums[0].length;
        if(m*n!=r*c)
            return nums;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(nums[i][j]);
            }
        }
        int re[][] = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                re[i][j] = list.get(i*c+j);
            }
        }
        return  re;
    }
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int re = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length -1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i]+nums[j]+nums[k]==target)
                        return target;
                    else{
                        if(Math.abs(nums[i]+nums[j]+nums[k]-target)<min){
                            re = nums[i]+nums[j]+nums[k];
                            min = Math.abs(nums[i]+nums[j]+nums[k]-target);
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return  re;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if(len<4)
            return  list;
        for (int i = 0; i < len -3; i++) {
            for (int j = i+1; j < len -2; j++) {
                int start = j+1 , end = nums.length-1;
                int t = target-nums[i]-nums[j];
                while(start<end){
                    if(nums[start]+nums[end] == target){
                        List<Integer> l = new ArrayList();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[start]);
                        l.add(nums[end]);
                        list.add(l);
                        start ++;
                        end --;
                    }else if(nums[start]+nums[end]>target){
                        end--;
                    }else{
                        start++;
                    }
                }
            }
        }
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }
}
