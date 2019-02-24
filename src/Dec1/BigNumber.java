package Dec1;

import java.util.*;

public class BigNumber {
    public static void main(String[] args) {
        int arr[] = {12,0,9,10,93,98,981};
        System.out.println(new BigNumber().largestNumber(arr));
    }
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            list.add(""+nums[i]);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return isBig(o2,o1);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (String str:list
             ) {
            sb.append(str);
        }
        return sb.toString();
    }
    public int isBig(String a,String b){
        long t1 = Long.parseLong(a+b);
        long t2 = Long.parseLong(b+a);
        if(t1>t2)
            return 1;
        else
            return -1;
    }
}
