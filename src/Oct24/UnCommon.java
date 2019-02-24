package Oct24;

import java.util.*;

public class UnCommon {
    public static void main(String[] args) {
        String a = "this is a";
        String b = "this is c";
        System.out.println(new UnCommon().findCommon(a,b).toString());
    }
    public String[] findCommon(String a,String b){
        String A[] = a.split(" ");
        String B[] = b.split(" ");
        Map<String,Integer> mapA = new HashMap();
        Map<String,Integer> mapB = new HashMap();
        Set<String> set = new TreeSet();
        for (int i = 0; i < A.length; i++) {
            mapA.put(A[i], mapA.getOrDefault(A[i],0)+1);
        }
        for (int i = 0; i < B.length; i++) {
            mapB.put(B[i], mapB.getOrDefault(B[i],0)+1);
        }
        for (String str:mapA.keySet()
             ) {
            if(mapA.get(str)==1&&!mapB.containsKey(str))
                set.add(str);
        }
        for (String str:mapB.keySet()
                ) {
            if(mapB.get(str)==1&&!mapA.containsKey(str))
                set.add(str);
        }
        String result[] = new String[set.size()];
        int i = 0;
        for (String str: set
             ) {
            result[i++] = str;
        }
        return result;
    }
    public int missingNumber(int[] nums) {
        int array[] = new int[nums.length+1];
        Arrays.fill(array,-1);
        for (int i = 0; i < nums.length; i++) {
            array[nums[i]]=1;
        }
        for (int i = 0; i <array.length ; i++) {
            if(array[i]!=1)
                return i;
        }
        return 0;
    }
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                int k = i+1;
                while(k<nums.length&&nums[k]==0){
                   k++;
                }
                if(k<nums.length){
                    int temp = nums[k];
                    nums[k] = 0;
                    nums[i] = temp;
                }
            }
        }
    }
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            count += count(J.charAt(i),S);
        }
        return count;
    }
    public int count(Character a ,String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==a)
                count++;
        }
        return count;
    }
}
