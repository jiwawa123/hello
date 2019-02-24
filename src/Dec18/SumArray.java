package Dec18;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SumArray {
    public static void main(String[] args) {
        String str  ="ewafeffewafewf";
        SumArray sumArray = new SumArray();
        System.out.println(sumArray.isContains("aewfafwafjlwajflwajflwafj",str));
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<2)
            return false;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                tmp+=nums[j];
                if(tmp%k==0)
                    return true;
            }
        }
        return false;
    }
    public String findLongestWord(String s, List<String> d) {
        if(s==null||d==null)
            return "";
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o2.length()==o1.length()){
                    return isFirst(o1,o2);
                }
                return o2.length()-o1.length();
            }
        });
        for (int i = 0; i < d.size(); i++) {
            if(isContains(s,d.get(i)))
                return d.get(i);
        }
        return "";
    }
    public int isFirst(String a,String b){
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i)<b.charAt(i))
                return -1;
            if(a.charAt(i)>b.charAt(i))
                return 1;
        }
        return 0;
    }
    public boolean isContains(String s,String target){
        int i = 0;
        int j = 0;
        while(i<s.length()&&j<target.length()){
            if(s.charAt(i)!=target.charAt(j))
                i++;
            else{
                i++;
                j++;
            }
        }
        return j==target.length();
    }
}
