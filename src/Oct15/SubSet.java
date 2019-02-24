package Oct15;

import Oct27.Sub;
import alter.Subset;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        SubSet ss = new SubSet();
        System.out.println(ss.countSubstrings("aaa"));
    }
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i; j < s.length(); j++)
            {
                if (isP(s.substring(i, j + 1)))
                {
                    count++;
                }
            }
        }

        return count;
    }
    public boolean isP(String s){
        if(s.equals("")||null==s)
            return false;
        int i = 0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        }
        return true;
    }
}
