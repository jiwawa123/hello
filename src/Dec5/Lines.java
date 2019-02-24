package Dec5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lines {
    public static void main(String[] args) {
        System.out.println("discuss.leetcode.com".substring(8,"discuss.leetcode.com".length()));
//        String str[] = {"9001 discuss.leetcode.com"};
//        new Lines().subdomainVisits(str);
    }

    public int[] numberOfLines(int[] widths, String S) {
        int line = 1;
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (count + widths[S.charAt(i) - 'a'] <= 100) {
                count += widths[S.charAt(i) - 'a'];
            } else {
                line++;
                count = 0;
                count += widths[S.charAt(i) - 'a'];
            }
        }
        int arr[] = new int[2];
        arr[0] = line;
        arr[1] = count;
        return arr;
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (null == grid || grid.length == 0)
            return 0;
        int r[] = new int[grid.length];
        int l[] = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                r[i] = Math.max(r[i], grid[i][j]);
            }
        }
        for (int i = 0; i < grid[i].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                l[i] = Math.max(l[i], grid[i][j]);
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int temp = Math.min(r[i], l[j]);
                count +=temp - grid[i][j];
            }
        }
        return count;
    }
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String,Integer> map= new HashMap<>();
        if(cpdomains.length==0){
            return list;
        }
        for (int i = 0; i < cpdomains.length; i++) {
            String str[] = cpdomains[i].split(" ");
            int temp = Integer.valueOf(str[0]);
            String tmp = str[1];
            while(tmp.contains(".")){
                map.put(str[1],map.getOrDefault(tmp,0)+temp);
                //System.out.println(str[1].indexOf('.'));
                tmp = tmp.substring(tmp.indexOf('.')+1,tmp.length());
                //System.out.println(str[1]);
            }
        }
        for (String str:map.keySet()
             ) {
            list.add(str+" "+map.get(str));
        }
        return list;
    }
}
