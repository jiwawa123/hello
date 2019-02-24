package Oct18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        int array[] = {0,0,0,0,0,0,0,0,1};
        System.out.println(findTargetSumWays(array,1));
    }
    public static int findTargetSumWays(int[] nums, int S) {
        if(nums.length==0)
            return 0;
        List<Map<Integer,Integer>> list = new ArrayList<>();
        Map<Integer,Integer> temp = new HashMap<>();
        temp.put(0,1);
        list.add(temp);
        for (int i = 0; i < nums.length; i++) {
            Map<Integer,Integer> te = list.get(i);
            Map<Integer,Integer> map = new HashMap<>();
            for (Integer k: te.keySet()){
                if(map.containsKey(k+nums[i])){
                    map.put(k+nums[i],map.get(k+nums[i])+te.get(k));
                }else{
                    map.put(k+nums[i],te.get(k));
                }
                if(map.containsKey(k-nums[i])){
                    map.put(k-nums[i],map.get(k-nums[i])+te.get(k));
                }else{
                    map.put(k-nums[i],te.get(k));
                }
            }
            list.add(map);
        }
        Map<Integer,Integer> mmap = list.get(nums.length);
        return mmap.getOrDefault(S,0);
    }
}
