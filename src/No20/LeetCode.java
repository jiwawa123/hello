package No20;

import java.util.*;

public class LeetCode {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int arr[] = {3,2,2,1};

        System.out.println(new LeetCode().numRescueBoats(arr,3));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.indexOf(s)!=-1)
            return  true;
        for(String str:wordDict){
            min = Math.min(min,str.length());
            max = Math.max(max,str.length());
        }
        if(s.length()<min)
            return false;
        if(s.length()==min&&wordDict.indexOf(s)==-1)
            return false;
        boolean flag = false;
        for (int i = min; i <= max; i++) {
            if(i>s.length())
                break;
            System.out.println(s.substring(0,i));
            if(wordDict.indexOf(s.substring(0,i))!=-1){

                flag = word(s.substring(i,s.length()),wordDict);
                if(flag)
                    break;
            }else{
                continue;
            }
        }
        return flag;

    }
    public boolean word(String s, List<String> wordDict) {
        if(s.equals(""))
            return true;
        if(s.length()<min)
            return false;
        if(s.length()==min&&wordDict.indexOf(s)==-1)
            return false;
        boolean flag = false;
        for (int i = min; i <= max; i++) {
            if(i>s.length())
                break;
            if(wordDict.indexOf(s.substring(0,i))!=-1){
                flag = word(s.substring(i,s.length()),wordDict);
                if(flag)
                    break;
            }else{
                continue;
            }
        }
        return flag;
    }
    public String reverseWords(String s) {
        if(null==s||s.equals(""))
            return s;
        s = s.trim();
        String str[] = s.split(" ");
        String re = "";
        for(int i = str.length-1;i>0;i--){
            if(!str[i].equals(" ")&&!str[i].equals("")){
                re+=str[i]+" ";
            }
        }
        if(!str[0].equals(" "))
            re+=str[0];
        return re;
    }
    public int compareVersion(String version1, String version2) {
        String str1[] = version1.split("\\.");
        String str2[] = version2.split("\\.");
        int i = 0 , j = 0 ;
        while(i<str1.length&&j<str2.length){
            if(Integer.valueOf(str1[i])>Integer.valueOf(str2[j])){
                return 1;
            }
            if(Integer.valueOf(str1[i])<Integer.valueOf(str2[j]))
                return -1;
            i++;
            j++;
        }
        while(i<str1.length)
        {
            if(Integer.valueOf(str1[i++])>0)
                return  1;
        }
        while(j<str2.length)
        {
            if(Integer.valueOf(str1[j++])>0)
                return  1;
        }
        return 0;
    }
    public int longestPalindrome(String s) {
        int arr[] = new int[60];
        Arrays.fill(arr,0);
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'A']+=1;
        }
        int count = 0 , f = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2==0)
                count+=arr[i];
            else
            {
                count+=arr[i]-1;
                f++;
            }
        }
        return  (f>0)?count+1:count;
    }
    public boolean isLongPressedName(String name, String typed) {
        if(name.equals(typed))
            return true;
        if(name.length()>typed.length())
            return false;
        int i = 0, j = 0;
        int temp = 0;
        while(i<name.length()&&j<typed.length()){
            if(temp==0){
                if(name.charAt(i)!=typed.charAt(j))
                    return false;
                while(j<typed.length()&&name.charAt(i)==typed.charAt(j)){
                    j++;
                    temp++;
                }
                i++;
            }else{
                while(name.charAt(i)==name.charAt(i-1)){
                    temp--;
                    if(temp<0)
                        return false;
                    i++;
                }
                if(name.charAt(i)==typed.charAt(j)){
                    temp = 0;
                    while(j<typed.length()&&name.charAt(i)==typed.charAt(j)){
                        j++;
                        temp++;
                    }
                    i++;
                }else{
                    return false;
                }

            }
        }
        while(i<name.length()){
            if(temp>0&&name.charAt(i)==typed.charAt(typed.length()-1)){
                i++;
            }else{
                return false;
            }
        }
        return i==name.length()&&j==typed.length();
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        int temp = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if(timeSeries[i]<temp-1){
                temp +=timeSeries[i];
                count+=duration + (timeSeries[i] - temp);
            }else{
                count+=duration;
                temp = timeSeries[i]+duration -1;
            }
        }
        return count;
    }

    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        if(people.length<=1)
            return people.length;
        Arrays.sort(people);
        int i = 0,j=people.length -1;
        while(i<j){
            if(people[j]==limit){
                count++;
                j--;
            }else if(people[j]+people[i]<=limit){
                count++;
                j--;
                i++;
            }else{
                count++;
                j--;
            }
        }
        return count;
    }

    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        if(piles.length==H){
            return piles[piles.length-1];
        }
        for (int i = 1; i <= piles[piles.length-1]; i++) {
            int count = 0;
            for (int j = 0; j <piles.length ; j++) {
                count += (j%i==0)?(j/i):(j/i)+1;
            }
            if(count<=H)
                return i;
        }
        return 0;
    }
}
