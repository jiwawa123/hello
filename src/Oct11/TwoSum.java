package Oct11;

import alter.Two;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        System.out.println(ts.lengthOfLongestSubstring("abcabcbb"));
        //System.out.println("abcabcbb".substring(2,5));
    }
    public int[] twoSum(int[] nums, int target) {
        int t = Integer.MAX_VALUE;
        int[] array = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                array[0] = map.get(target - nums[i]);
                array[1] = i;
            }else{
                map.put(nums[i],i);
            }
        }
        return array;
    }
    public boolean isCon(String a,String b){
        for (int i = 0; i <b.length() ; i++) {
            if(a.charAt(i)!=b.charAt(i))
                return false;
        }
        return true;
    }
    public boolean isConArray(String strs[],String a){
        for (String s:strs) {
            if(!isCon(s,a))
                return false;
        }
        return  true;
    }
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()&&!map.containsKey(s.charAt(i)))
                return false;
            if(map.containsKey(s.charAt(i)))
                stack.push(s.charAt(i));
            if(!map.containsKey(s.charAt(i))&&!stack.isEmpty()){
                if(map.get(stack.pop())!=s.charAt(i))
                    return false;
            }
        }
        return  stack.isEmpty();
    }
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.equals("")) return 0;
        if(s.length()==1) return 1;
        int array[] = new int[s.length()];
        array[0] = 1;
        for(int i = 1;i<s.length();i++){
            array[i] = len(s.substring(i-array[i-1],i),s.charAt(i))+1;
        }
        int k = 0 ;
        for(int i= 0 ;i<array.length;i++)
            if(k<array[i])
                k= array[i];
        return k;
    }
    public int len(String a,Character c){
        int k = 0 ;
        for (int i = a.length() - 1; i >=0 ; i--) {
            if(a.charAt(i) == c)
                break;
            k++;
        }
        return k ;
    }
}
