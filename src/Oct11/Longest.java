package Oct11;

import java.util.ArrayList;
import java.util.List;

public class Longest {
    public static void main(String[] args) {
        Longest longest = new Longest();
        System.out.println(longest.longestPalindrome("babad"));
    }
    public String longestPalindrome(String s) {
        if(s.equals("")||s==null)
            return "";
        List<String> slist = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j>i ; j--) {
                if(j-i<=count){
                    break;
                }
                if(isPal(s.substring(i,j))){
                    slist.add(s.substring(i,j));
                    count = j-i;
                    break;
                }

            }
        }
        String re = "";
        for(String str:slist){
            if(str.length()>re.length())
                re = str;
        }
        return re;
    }
    public boolean isPal(String s){
        int i = 0,j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
