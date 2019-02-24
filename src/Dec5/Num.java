package Dec5;

public class Num {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            int max = A[i];
            if(max<=R&&max>=L)
                res++;
            
            for (int j = i+1; j <A.length ; j++) {
                max = Math.max(max,A[j]);
                if(max<=R&&max>=L)
                    res++;
                if(max>R)
                    break;
            }
        }
        return res;
    }
}
