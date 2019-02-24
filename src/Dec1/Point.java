package Dec1;

import java.util.*;

public class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }

    public int maxPoints(Point[] points) {
        if (null == points)
            return 0;
        if (points.length <= 2)
            return points.length;
        int max = 2;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int t = 2;
                for (int k = j + 1; k < points.length; k++) {
                   if((long)(points[k].y-points[i].y)*(points[j].x-points[i].x)-(long)(points[j].y-points[i].y)*(points[k].x-points[i].x)==0)
                        t++;
                }
                max = Math.max(max, t);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new Point(1,1).partitionLabels("caedbdedda");
    }
    public int minMoves2(int[] nums) {
        if(null==nums||nums.length<=1)
            return 0;
        Arrays.sort(nums);
        int t = nums.length%2;

        if(t==1){
            int count = 0;
            int k = nums[nums.length/2];
            for (int tt:nums
                 ) {
                count+=Math.abs(tt-k);
            }
            return count;
        }else{
            int k1 = nums[nums.length/2];
            int k2 = nums[nums.length/2-1];
            int c1 = 0;
            int c2 = 0;
            for (int tt:nums
                 ) {
                c1+=Math.abs(tt-k1);
                c2+=Math.abs(tt-k2);
            }
            return Math.min(c1,c2);
        }
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        if(null==S||S.equals(""))
            return list;
        char a = S.charAt(0);
        int l= 0;
        int r = lastIn(S,a);
        while(S!=null&&S.length()>0){
            if(l==r){
                S = S.substring(r+1,S.length());
                list.add(l+1);
            }else{
                for (int i = l+1; i <=r ; i++) {
                    r = Math.max(lastIn(S,S.charAt(i)),r);
                }
                list.add(r - l+1);
                S = S.substring(r+1,S.length());
                if(null!=S&&S.length()>0){
                    l = 0;
                    r = lastIn(S,S.charAt(0));
                }
            }
        }
        return list;
    }
    public int lastIn(String s,char a){
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i)==a)
                return i;
        }
        return 0;
    }

    public int scoreOfParentheses(String S) {
        if(null==S)
            return 0;
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));
        int temp = 0;
        S = S.substring(1,S.length());
        boolean f = false;
        while(!stack.isEmpty()){
            if(S.charAt(0)==')'){
                temp++;
                stack.pop();
            }else{
                stack.push('(');
            }
            S = S.substring(1,S.length());
            if(!S.contains("(")){
                if(f){
                    break;
                }else
                    f = true;
            }

        }
        while(!stack.isEmpty()){
            temp*=2;
            stack.pop();
        }
        return temp;
    }
    public boolean validMountainArray(int[] A) {
        if(null==A||A.length<=2)
            return false;
        boolean h = false;
        int index = 0;
        for (int i = 1; i <A.length ; i++) {
            if(A[i]==A[i-1])
                return  false;
            if(!h){
                if(A[i]<A[i-1]){
                    h = true;
                }else{
                    index++;
                }

            }else{
                if(A[i]>=A[i-1])
                    return false;
            }
        }
        return  h&&index>0;
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num=1, d=n-1, x=(n-d)/2, y=(n-d)/2;
        while (d > 0) {
            for(int i=0; i<d; i++) res[x][y+i] = num++;  //①
            y += d;
            for(int i=0; i<d; i++) res[x+i][y] = num++;  //②
            x += d;
            for(int i=0; i<d; i++) res[x][y-i] = num++;  //③
            y = (n-d) / 2;
            for(int i=0; i<d; i++) res[x-i][y] = num++;  //④
            d -= 2;
            x = (n-d) / 2;
            y = (n-d) / 2;
        }
        if (d==0) res[x][y] = num;  //⑤
        return res;
    }

    public int minAddToMakeValid(String S) {
        if(null==S||S.length()==0)
            return 0;
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)){
                case '(':
                    stack.push('(');
                    break;
                default:
                    if(stack.isEmpty())
                        result++;
                    else
                        stack.pop();
                    break;
            }
        }
        while(!stack.isEmpty()){
            result++;
            stack.pop();
        }
        return  result;
    }
    public int findPairs(int[] nums, int k) {
        if(k==0){
            int ans = 0;
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
            for (int kk :map.values()
                 ) {
                if(kk>=2)
                    ans++;
            }
            return ans;
        }else{
        Arrays.sort(nums);
        int ans = 0;
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i]==nums[i+1])
                    continue;
                for (int j = i+1; j < nums.length; j++) {
                    if(nums[j]-nums[i]==k) {
                        ans++;
                        break;
                    }
                }
            }
        return ans;

        }
    }

}
