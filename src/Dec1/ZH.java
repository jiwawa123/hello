package Dec1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ZH {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        Collections.sort(list);
        System.out.println(new ZH().calculate("1-2"));
    }
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {

                    if(isTran(nums[i],nums[j],nums[k]))
                        count++;
                    if(nums[k]>nums[i]+nums[j])
                        break;
                }
            }
        }
        return count;
    }
    public boolean isTran(int a,int b,int c){
        return a+b>c&&a+c>b&&b+c>a;
    }
    public int calculate(String s) {
        s = s.replaceAll(" ","");
        while(s.contains("*")||s.contains("/")||s.contains("+")||s.substring(1,s.length()).contains("-")){
            while(s.contains("*")||s.contains("/")){
                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i)=='*'||s.charAt(i)=='/'){
                        StringBuffer fi = new StringBuffer();
                        StringBuffer se = new StringBuffer();
                        int j ,k;
                        for (j = i-1; j >=0 ; j--) {
                            if(s.charAt(j)>='0'&&s.charAt(j)<='9')
                                fi.append(s.charAt(j));
                            else
                                break;
                        }
                        for (k = i+1; k <s.length() ; k++) {
                            if(s.charAt(k)>='0'&&s.charAt(k)<='9')
                                se.append(s.charAt(k));
                            else
                                break;
                        }
                        int t1 = Integer.valueOf(fi.reverse().toString());
                        int t2 = Integer.valueOf(se.reverse().toString());
                        int temp = 0;
                        if(s.charAt(i)=='*')
                            temp = t1*t2;
                        else
                            temp = t1/t2;
                        s = s.substring(0,j+1)+""+temp+s.substring(k,s.length());
                        break;
                        }
                    }
                }
            while(s.contains("+")||(s.substring(1,s.length()).contains("-"))){
                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                        StringBuffer fi = new StringBuffer();
                        StringBuffer se = new StringBuffer();
                        int j,k;
                        for (j = i-1; j >=0 ; j--) {
                            if(s.charAt(j)>='0'&&s.charAt(j)<='9')
                                fi.append(s.charAt(j));
                            else
                                break;
                        }
                        for ( k = i+1; k <s.length() ; k++) {
                            if(s.charAt(k)>='0'&&s.charAt(k)<='9')
                                se.append(s.charAt(k));
                            else
                                break;
                        }

                        int t1 = Integer.valueOf(fi.reverse().toString().trim());
                        int t2 = Integer.valueOf(se.reverse().toString().trim());
                        int temp = 0;
                        if(s.charAt(i)=='+')
                            temp = t1+t2;
                        else
                            temp = t1-t2;
                        s = s.substring(0,j+1)+""+temp+s.substring(k,s.length());

                        break;
                    }
                }
            }
            }
           return  Integer.valueOf(s.trim());
        }

}
