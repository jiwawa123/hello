package Dec5;

import java.util.*;

public class Cour {
    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String bank[] = {"AACCGGTA"};
        System.out.println(new Cour().minMutation(start,end,bank));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean flag[] = new boolean[numCourses];
        Arrays.fill(flag,false);
        int arr[] = new int[numCourses];
        List<Integer> l = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if(map.containsKey(prerequisites[i][0])){
                List<Integer> ll = map.get(prerequisites[i][0]);
                ll.add(prerequisites[i][1]);
                map.put(prerequisites[i][0],ll);
            }else{
                List<Integer> ll =new ArrayList<>();
                ll.add(prerequisites[i][1]);
                map.put(prerequisites[i][0],ll);
            }
            arr[prerequisites[i][0]]+=1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                l.add(i);
                flag[i] = true;
            }
        }
        while(l.size()<numCourses){
            boolean ff = false;
            for (int i = 0; i < arr.length; i++) {
                if(flag[i])
                    continue;
                List<Integer> list = map.get(i);
                boolean f = true;
                for (int j = 0; j < list.size(); j++) {
                    if(!flag[list.get(j)]){
                        f = false;
                        break;
                    }
                }
                if(f){
                    flag[i] = true;
                    l.add(i);
                    ff = true;
                }
            }
            if(!ff){
                break;
            }
        }
        if(l.size()!=numCourses){
            return new int[0];
        }else{
            int res[] = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = l.get(i);
            }
            return res;
        }

    }

    public int maximalSquare(char[][] matrix) {
        if(null==matrix||matrix.length==0)
            return 0;
        int dp[][] = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0]=='1')
                dp[i][0] = 1;
            else
                dp[i][0] = 0;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i]=='1')
                dp[0][i] = 1;
            else
                dp[i][0] = 0;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j]=='0')
                    continue;
                int tmp = dp[i-1][j-1];
                if(dp[i][j-1]==tmp&&dp[i-1][j]==tmp){
                    dp[i][j-1] = tmp+1;
                }else{
                    int min = Math.min(tmp,dp[i][j-1]);
                    min = Math.min(min,dp[i-1][j]);
                    dp[i][j-1] = min+1;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res*res;
    }

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='X'){
                    if(i==0&&j==0){
                        count++;
                        continue;
                    }
                    if(i>0){
                        if(board[i-1][j]=='X')
                            continue;
                    }
                    if(j>0){
                        if(board[i][j-1]=='X')
                            continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }
    boolean ff[];
    int result =Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        int res = StringCon(bank,end);
        if(res==-1)
            return -1;
        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if(start.charAt(i)!=end.charAt(i))
                count++;
        }
        if(count==1)
            return 1;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < bank.length; i++) {
            for (int j = i+1; j < bank.length; j++) {
                if(canChange(bank[i],bank[j])){
                    if(map.containsKey(i)){
                        List<Integer> l = map.get(i);
                        l.add(j);
                        map.put(i,l);
                    }else{
                        List<Integer> l = new ArrayList<>();
                        l.add(j);
                        map.put(i,l);
                    }
                    if(map.containsKey(j)){
                        List<Integer> l = map.get(j);
                        l.add(i);
                        map.put(j,l);
                    }else{
                        List<Integer> l = new ArrayList<>();
                        l.add(i);
                        map.put(j,l);
                    }
                }
            }
        }
        ff = new boolean[bank.length];
        for (int i = 0; i < bank.length; i++) {
            if(canChange(start,bank[i])){
                Contains(map,i,res,1);
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
    public void Contains(Map<Integer,List<Integer>> map,int k,int temp,int nu){
        if(!map.containsKey(k)||ff[k]){
            return ;
        }
        ff[k] = true;
        List<Integer> l = map.get(k);
        if(l.indexOf(temp)!=-1){
            result =Math.min(result,nu+1);
        }
        for (int i = 0; i < l.size(); i++) {
            Contains(map,i,temp,nu+1);
        }

    }
    public int StringCon(String [] str,String con){
        if(null==str||str.length==0)
            return -1;
        for (int i = 0; i < str.length; i++) {
            if(str[i].equals(con))
                return i;
        }
        return -1;
    }
    public boolean canChange(String a,String b){
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i)!=b.charAt(i))
                    count++;
                if(count>2)
                    return false;

        }
        return count==1;
    }

}
