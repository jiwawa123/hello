package _2_15;

import java.util.ArrayList;
import java.util.List;

public class Ar {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> re = new ArrayList<>();
        String tmp = K + "";
        int i = tmp.length() - 1, j = A.length - 1;
        int k = 0;
        while (i >= 0 && j >= 0) {
            int t = (k + (tmp.charAt(i) - '0') + A[j]) % 10;
            k = t / 10;
            re.add(0, t);
            i--;
            j--;
        }
        while (i >= 0) {
            int t = (k + (tmp.charAt(i) - '0')) % 10;
            k = t / 10;
            re.add(0, t);
            i--;
        }
        while (j >= 0) {
            int t = (k + A[j]) % 10;
            k = t / 10;
            re.add(0, t);
            j--;
        }
        return re;
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int re[] = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            A[queries[i][1]] += val;
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] % 2 == 0)
                    sum += A[j];
            }
            re[i] = sum;
        }
        return  re;
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 4};
        System.out.println(new Ar().addToArrayForm(arr, 181));
    }
}
