package Dec5;

import java.util.*;

public class NumMatrix {
    int arr[][] ;
    static class Lr{
        public int r1;
        public int r2;
        public int c1;
        public int c2;
        public Lr(int r1,int r2,int c1,int c2){
            this.r1 = r1;
            this.r2 = r2;
            this.c1 = c1;
            this.c2 = c2;
        }
    }
    static Map<Lr,Integer> map = new HashMap<>();
    public NumMatrix() {

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int count = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2 ; j++) {
                count+=arr[i][j];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        new NumMatrix().medianSlidingWindow(arr,3);
    }
    public int integerBreak(int n) {
        int arr[] = new int[n+1];
        Arrays.fill(arr,0);
        for (int i = 2; i <=n; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] = Math.max(arr[i],arr[j]*arr[i-j]);
                arr[i] = Math.max(j*(i-j),arr[i]);
                arr[i] = Math.max(arr[i],arr[j]*(i-j));
                arr[i] = Math.max(arr[i],arr[i-j]*j);
            }
        }
        return arr[n];
    }
    public static int getMoneyAmount(int n) {
        if(n<=2)
            return 1;
        int i = 1 ,j = n;
        int count = 0;
        int med = 0;
        while(i<j){
            if((j-i+1)%2!=0){
                med = (j+i)/2;
            }else{
                med = (j+1)/2;
                if((j-i+1)%4==0){
                    med++;
                }
            }
            count+=med;
            i = med+1;
        }
        return count;
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> l = new ArrayList();
        double d[] = new double[nums.length-k+1];
        for (int i = 0; i < k; i++) {
            l.add(nums[i]*1.0);
        }
        d[0] = meddle(l);
        for (int i = 1; i < nums.length-k+1; i++) {
            l.remove(l.indexOf(nums[i-1]*1.0));
            d[i] = meddleI(l,nums[i+k-1]*1.0);
        }
        return d;
    }
    public double meddle(List<Double> l){
        Collections.sort(l);
        if(l.size()%2==0){
            return (l.get(l.size()/2)+l.get(l.size()/2-1))/2.0;
        }else{
            return 1.0*l.get(l.size()/2);
        }
    }
    public double meddleI(List<Double> l,double k){
        boolean flag = false;
        for (int i = 0; i < l.size(); i++) {
            if(k<l.get(i)){
                l.add(i,k*1.0);
                flag =true;
                break;
            }
        }
        if(!flag)
            l.add(k);
        if(l.size()%2==0){
            return (l.get(l.size()/2)+l.get(l.size()/2-1))/2.0;
        }else{
            return 1.0*l.get(l.size()/2);
        }
    }
}
