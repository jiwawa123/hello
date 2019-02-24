package Dec1;

import java.util.*;

public class YWF {
    public static void main(String[] args) {
       int arr[] = {8,6,7,7,810,1};
       Arrays.sort(arr);
        for (int k:arr
             ) {
            System.out.println(k);
        }
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list =new ArrayList<>();
        for (int i = 0; i < s.length()-p.length()+1; i++) {
            if(isYWF(s.substring(i,i+p.length()),p))
                list.add(i);
        }
        return list;
    }
    public boolean isYWF(String s,String p){
        Map<Character,Integer> map =new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i <p.length() ; i++) {
            if(map.getOrDefault(p.charAt(i),0)==0)
                return false;
            else
                map.put(p.charAt(i),map.get(p.charAt(i))-1);
        }
        return true;
    }
    public int[][] flipAndInvertImage(int[][] A) {
        if(A==null)
            return A;
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            int start = 0,end = n-1;
            while(start<end){
               int temp =  A[i][start];
               A[i][start] = A[i][end];
               A[i][end] = temp;
               start++;
               end++;
            }
            for (int j = 0; j < n; j++) {
                A[i][j] = A[i][j]^1;
            }
        }
        return A;
    }
    public  boolean pattern(String a,String b){
        if(a.length()!=b.length())
            return false;
        Map<Character,Character> map =new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            if(map.containsKey(b.charAt(i))){
                if(map.get(b.charAt(i))!=a.charAt(i))
                    return false;
            }else
                map.put(b.charAt(i),a.charAt(i));
        }

        return true;

    }
    public int numMagicSquaresInside(int[][] grid) {
        if(grid==null)
            return 0;
        int count = 0;
        int i = 0,j = 0;
        int n = grid.length,m = grid[0].length;
        while(i+3<=n){
            while(j+3<=m){

                if(grid[i][j+1]+grid[i][j+2]+grid[i][j]!=15){

                    j++;
                    continue;
                }
                if(grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2]!=15)
                {

                    j++;
                    continue;
                }
                if(grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+1]!=15)
                {

                    j++;
                    continue;
                }
                if(grid[i][j]+grid[i+1][j]+grid[i+2][j]!=15) {

                    j++;
                    continue;
                }
                if(grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1]!=15)
                {
                    j++;
                    continue;
                }
                if(grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2]!=15) {
                    j++;
                    continue;
                }
                if(grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2]!=15) {
                    j++;
                    continue;
                }
                if(grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j]!=15) {
                    j++;
                    continue;
                }
                j++;
                count++;
            }
            i++;
        }
        return count;
    }
    public int findRadius(int[] houses, int[] heaters) {
        int array[] = new int[houses.length];
        Arrays.fill(array,Integer.MAX_VALUE);
        int re = 0;
        for (int i = 0; i < houses.length; i++) {
            for (int j = 0; j < houses.length; j++) {
                array[i] = Math.min(array[i],Math.abs(houses[i]-heaters[j]));
            }
            re = Math.max(array[i],re);
        }
        return re;
    }

}
