import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Media {
    public static void main(String[] args) {
        Media media = new Media();
        int m1[] = {1,2};
        int m2[] = {3,4};
        System.out.print(media.findMedianSortedArrays(m1,m2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        int i=0,j = 0;
        int n = nums1.length + nums2.length;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<=nums2[j]){
                list.add(nums1[i]);
                i++;
            }else{
                list.add(nums2[j]);
                j++;
            }
        }
        while(i< nums1.length){
            list.add(nums1[i]);
            i++;
        }
        while(j<nums2.length){
            list.add(nums2[j]);
            j++;
        }
        if(n%2!=0)
            return (double)list.get(n/2);
        return (double) (list.get(n/2-1)+list.get(n/2))/2;

    }
    public int numJewelsInStones(String J, String S) {
        Map<Character,Integer> map = new HashMap();
        int count = 0;
        for(int i = 0;i<J.length();i++)
            map.put(J.charAt(i),1);
        for(int j = 0;j<S.length();j++)
            if(map.containsKey(S.charAt(j)))
                count++;
        return count;
    }
    public String toLowerCase(String str) {
        char[] ch = str.toCharArray();
        StringBuffer sbf = new StringBuffer();
        for(Character c : ch)
            sbf.append(charToLowerCase(c));
        return sbf.toString();
    }
    private char charToLowerCase(char ch){
        if(ch <= 90 && ch >= 65){
            ch += 32;
        }
        return ch;
    }
}
