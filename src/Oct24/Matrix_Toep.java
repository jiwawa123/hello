package Oct24;

import java.util.HashMap;
import java.util.Map;

public class Matrix_Toep {
    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
    }
    public boolean isToep(int[][] array){
        int n = array.length;
        int m = array[0].length;
        int t = Math.min(m,n);
        for (int i = 0; i < n; i++) {
            int temp = array[i][0];
            int k=i,h = 0;
            while(h<t&k<t){
                if(array[k][h]!=temp)
                    return false;
                k++;
                h++;
            }
        }
        for (int i = 0; i < m; i++) {
            int temp = array[0][m];
            int k=0,h = i;
            while(h<t&k<t){
                if(array[k][h]!=temp)
                    return false;
                k++;
                h++;
            }
        }
        return true;
    }
    public char findTheDifference(String s, String t) {
        if(s.length() >t.length()){
            String temp = s;
            s = t;
            t = temp;
        }
        Map<Character,Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < t.length() ; i++) {
            if(!map.containsKey(t.charAt(i))||(map.get(t.charAt(i))==0)){
                return t.charAt(i);
            }else{
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
            }
        }
        return s.charAt(0);
    }
}
