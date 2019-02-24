package Dec26;

import java.util.*;

public class Mar {
    public static void main(String[] args) {
        Mar mar = new Mar();
        mar.maskNumber("1(234)567-890");
    }

    public int[][] kClosest(int[][] points, int K) {
        int res[][] = new int[K][2];
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            tmp.add(points[i]);
        }
        Collections.sort(tmp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1];
            }
        });
        for (int i = 0; i < K; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    public int largestPerimeter(int[] A) {
        int res = 0;
        Arrays.sort(A);
        for (int i = A.length; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                res = Math.max(res, A[i] + A[i - 1] + A[i - 2]);
            }
        }
        return res;
    }

    public static int subarraysDivByK(int[] A, int K) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
            if(sum>=K)sum=sum%K;
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        for (int k: map.keySet()
             ) {
            System.out.println(k+" "+map.get(k));
        }
        for (int k:map.values()
             ) {
            if(k>1){
                res+=k*(k-1)/2;
            }
        }
        return res;
    }


    public String maskPII(String S) {
        if(!S.contains("@")){//deal phone number
            return maskNumber(S);
        }else{//deal  email
            String tmp[] = S.toLowerCase().split("@");
            return tmp[0].charAt(0)+"*****"+tmp[0].charAt(tmp[0].length()-1)+"@"+tmp[1];
        }
    }
    public String maskNumber(String S){
        int n = 0;
        int t = 0;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if(Character.isDigit(S.charAt(i))){
                l.add(S.charAt(i)-'0');
                n++;
            }
        }
        if(n==10){
            String res = "***-***-";
            for (int i = 6; i < 10; i++) {
                res+=l.get(i);
            }
            return res;
        }else{
            String ll[] = S.split("-");
            for (int i = 0; i < ll[0].length(); i++) {
                if(Character.isDigit(ll[0].charAt(i))){
                   t++;
                }
            }
            String res = "+";
            while(t>0){
                res+="*";
            }
            res+="-***-***-";
            for (int i = l.size()-4; i < l.size(); i++) {
                res+=l.get(i);
            }
            return res;
        }
    }
    public void sort(List<Integer> l){

    }
}
