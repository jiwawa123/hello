package arg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(query(array));
    }
    public static int query(int[] array){
        int len = array.length;
        int[] copy = new int[len];
        for (int i = 0; i <len ; i++)
            copy[i] = array[i];
        int count = requry(array, copy, 0, len - 1);
        return count;
    }
    public static int requry(int[] array, int[] copy, int begin, int end) {
        if(begin == end)
            return 0;
        int mid = (begin + end) / 2;

        int left = requry(copy, array, begin, mid);
        int right = requry(copy, array, mid + 1, end);

        int i = mid, j = end, pos = end;
        int count = 0;
        while(i >= begin && j >= mid + 1)
        {
            if(array[i] > array[j]) {
                copy[pos--] = array[i--];
                count += j - mid;
            } else
                copy[pos--] = array[j--];
        }
        while(i >= begin)
            copy[pos--] = array[i--];
        while(j >= mid + 1)
            copy[pos--] = array[j--];
        return left + right + count;
    }
}
