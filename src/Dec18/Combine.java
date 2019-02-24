package Dec18;

import java.util.*;

public class Combine {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrace(res, list, candidates, target, target, 0);
        return res;
    }

    public void backTrace(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int remain, int start) {
        if (remain < 0)
            return;
        if (remain == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                backTrace(res, list, nums, target, remain - nums[i], i);
                list.remove(list.size() - 1);
            }
        }
    }

    public int backTraceAll(List<Integer> list, int[] nums, int target, int remain, int end) {
        if (remain < 0)
            return -1;
        if (remain == 0)
            return list.size();
        else {
            for (int i = end; i >= 0; i--) {
                list.add(nums[i]);
                int tmp = backTraceAll(list, nums, target, remain - nums[i], i);
                if (tmp != -1)
                    return tmp;
                else
                    list.remove(list.size() - 1);
            }
        }
        return -1;
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        List<Integer> l = new ArrayList();
        int tmp = backTraceAll(l, coins, amount, 0, coins.length);
        return tmp;
    }

    public static void main(String[] args) {
        double b = 451175*1.0 / (145237 * 8823);
        System.out.println(String.format("%.7f", b));

    }

    public int[] findRedundantConnection(int[][] edges) {
        int res[] = new int[2];
        List<Map<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int f = edges[i][0];
            int s = edges[i][1];
            int start = -1;
            int end = -1;
            for (int j = 0; j < list.size(); j++) {
                Map<Integer, Integer> map = list.get(j);
                if (map.containsKey(f))
                    start = j;
                if (map.containsKey(s))
                    end = j;
            }
            if (start == end && start == -1) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(f, 1);
                map.put(s, 1);
                list.add(map);
            } else if (start == end) {
                res[0] = start;
                res[1] = end;
                return res;
            } else if (start == -1) {
                Map<Integer, Integer> m1 = list.get(end);
                m1.put(f, 1);
                list.set(end, m1);
            } else if (end == -1) {
                Map<Integer, Integer> m1 = list.get(start);
                m1.put(s, 1);
                list.set(start, m1);
            } else {
                Map<Integer, Integer> m1 = list.get(start);
                Map<Integer, Integer> m2 = list.get(end);
                for (int k : m2.keySet()
                        ) {
                    m1.put(k, 1);
                }
                list.set(start, m1);
                list.remove(end);
            }
        }
        return res;
    }

    //使用数组进行链接
    public int[] findRedundantConnectionByArray(int[][] edges){
        int arr[] = new int[edges.length];
        int rank[] = new int[edges.length];
        Arrays.fill(rank,0);
        int res[] = new int[2];
        Arrays.fill(arr,-1);
        for (int i = 0; i < edges.length; i++) {
            int f = edges[i][0];
            int s = edges[i][1];
            int start = findRoot(arr,f-1);
            int end = findRoot(arr,s-1);
            if(start==end){
                res[0] = f;
                res[1] = s;
                return res;
            }else{
                if(rank[start]>rank[end]){
                    arr[end] = f-1;
                }
                else if(rank[start]<rank[end])
                    arr[start] = s-1;
                else{
                    arr[end] = f-1;
                    rank[end]++;
                }
            }
        }
        return res;
    }
    public int findRoot(int arr[],int child){


        while(arr[child]!=-1){
            child = arr[child];

        }

        return child;
    }

}
