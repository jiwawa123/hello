package Dec1;

import java.util.*;

public class Path {

    public static void main(String[] args) {
        int arr[][] = {{3,7},{1,4},{2,8},{1,6},{7,9},{6,10},{1,7},{2,3},{8,9},{5,9}};
        System.out.println(new Path().findRedundantConnection(arr));
    }

    int n;
    List<List<Integer>> list;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        list = new ArrayList<>();
        List<Integer> l;

        for (int i = 0; i < graph[0].length; i++) {
            l = new ArrayList<>();
            l.add(0);
            add(l, graph, graph[0][i]);
        }
        return list;
    }

    public void add(List<Integer> l, int[][] graph, int k) {
        if (k == n - 1) {
            l.add(k);
            list.add(l);
            return;
        }
        l.add(k);
        int arr[] = graph[k];
        if (null == arr || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (isHuan(l, arr[i], k)) {
                add(l, graph, arr[i]);
            }
        }
    }

    public boolean isHuan(List<Integer> l, int a, int b) {
        for (int i = 0; i < list.size() - 2; i++) {
            System.out.println(list.size() + " " + i + " ");
            int aa = l.get(i);
            int bb = l.get(i + 1);
            if (a == aa && b == bb)
                return false;

        }
        return true;
    }

    public String shiftingLetters(String S, int[] shifts) {
        int arr[] = new int[shifts.length];
        int temp = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            temp += shifts[i] % 26;
            temp %= 26;
            arr[i] = temp;
        }
        char a[] = S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            a[i] = (char) (a[i] + arr[i]);
            if (a[i] > 'z') {
                a[i] = (char) ('a' + a[i] - 'z');
            }
        }
        return String.valueOf(a);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int arr[] = new int[nums.length];
        int ff[] = new int[nums.length];
        Arrays.fill(arr, 0);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] < k) {
                    int count = 1;
                    int temp = nums[i];
                    for (int j = i + 1; j < nums.length; j++) {
                        temp *= nums[j];
                        if (temp < k) {
                            count++;
                        } else {
                            ff[i] = temp/nums[j];
                            break;
                        }
                    }
                    arr[i] = count;
                }
            }else{
                if(arr[i-1]>2){
                    int count = arr[i-1] - 1;
                    int temp = ff[i-1]/nums[i-1];
                    for (int j = i-1+arr[i-1]; j < nums.length; j++) {
                        temp *= nums[j];
                        if (temp < k) {
                            count++;
                        } else {
                            ff[i] = temp/nums[j];
                            break;
                        }
                    }
                    arr[i] = count;
                }else{
                    if (nums[i] < k) {
                        int count = 1;
                        int temp = nums[i];
                        for (int j = i + 1; j < nums.length; j++) {
                            temp *= nums[j];
                            if (temp < k) {
                                count++;
                            } else {
                                ff[i] = temp/nums[j];
                                break;
                            }
                        }
                        arr[i] = count;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            ans+=arr[i];
        }
        return ans;
    }


    public int numberOfArithmeticSlices(int[] A) {
        int ans = 0;
        if(A.length<3)
            return ans;
        for (int i = 0; i < A.length-2; i++) {
            if(A[i+2]-A[i+1]==A[i+1]-A[i]){
                ans++;
                for (int j = i+3; j <A.length ; j++) {
                    if(A[j]-A[j-1]==A[j-1]-A[j-2]){
                        ans++;
                    }else{
                        break;
                    }
                }
            }

        }
        return ans;
    }
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            boolean flag = true;
            int cou = 0;
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='.'){
                    flag = true;
                }else{
                    cou++;
                }
            }
            if(flag)
                count = Math.max(count,cou);
        }
        for (int i = 0; i < board[0].length; i++) {
            boolean flag = true;
            int cou = 0;
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]=='.'){
                    flag = true;
                }else{
                    cou++;
                }
            }
            if(flag)
                count = Math.max(count,cou);
        }
        return count;
    }
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int a[] = edges[i];
            if(map.containsKey(a[0])&&map.containsKey(a[1]))
                return a;
            else{
                map.put(a[0],1);
                map.put(a[1],1);
            }
        }
        return null;
    }
}
