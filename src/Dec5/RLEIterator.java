package Dec5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RLEIterator {
    class point {
        int p;
        int num;

        public point(int p, int num) {
            this.p = p;
            this.num = num;
        }
    }

    List<point> l;

    public RLEIterator(int[] A) {
        l = new ArrayList<>();
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] > 0)
                l.add(new point(A[i + 1], A[i]));
        }
    }

    public int next(int n) {
        while (n > 0 && !l.isEmpty()) {
            point tmp = l.get(0);
            if (n < tmp.num) {
                tmp.num -= n;
                l.set(0, tmp);
                return tmp.p;
            } else if (n == tmp.num) {
                l.remove(0);
                return tmp.p;
            } else {
                n -= tmp.num;
                l.remove(0);
            }
        }

        return -1;

    }

    public double knightProbability(int N, int K, int r, int c) {
        return knightNext(N,K,r,c,1.0);
    }
    public double knightNext(int N, int K, int r, int c,double last) {
        //System.out.println(r+" "+c+" "+last);
        if(r<0||r>N-1||c<0||c>N-1)
            return 0.0;
        if(K==0){
            System.out.println("last"+last);
            return last;
        }


        double tmp = 0.0;
        tmp+=knightNext(N,K-1,r-2,c-1,last*(1.0/8));
        tmp+=knightNext(N,K-1,r-1,c-2,last*(1.0/8));
        tmp+=knightNext(N,K-1,r+2,c-1,last*(1.0/8));
        tmp+=knightNext(N,K-1,r+1,c-2,last*(1.0/8));
        tmp+=knightNext(N,K-1,r-2,c+1,last*(1.0/8));
        tmp+=knightNext(N,K-1,r-1,c+2,last*(1.0/8));
        tmp+=knightNext(N,K-1,r+2,c+1,last*(1.0/8));
        tmp+=knightNext(N,K-1,r+1,c+2,last*(1.0/8));

        return tmp;
    }

    public static void main(String[] args) {
        int arr[] = {1,2};
        System.out.println(new RLEIterator(arr).knightProbability(3,2,0,0));
    }
}
