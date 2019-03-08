package math;
/*
    user ji
    data 2019/3/6
    time 6:37 PM
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int arr[] = {2,2,3,4};
        System.out.println(new Subset().subsets(arr).toString());
    }
    private List<List<Integer>> listList;

    public List<List<Integer>> subsets(int[] nums) {
        listList = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            subSets(nums, new ArrayList<>(), i);
        }
        HashSet<List<Integer>> hashSet = new HashSet<>();
        for (List<Integer> l :listList
             ) {
            hashSet.add(l);
        }
        return new ArrayList<>(hashSet);

    }

    private void subSets(int[] nums, List<Integer> list, int n){
        /*
        可以考虑集合的个数
         */
        if(list.size() == n){
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i]) || (!list.isEmpty() && list.get(list.size() - 1) > nums[i])){
                continue;
            }
            list.add(nums[i]);
            subSets(nums, list, n);
            list.remove(list.size() - 1);
        }
    }
}
