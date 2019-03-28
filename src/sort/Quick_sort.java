package sort;/*
    user ji
    data 2019/3/25
    time 8:40 AM
*/

import java.util.Arrays;

public class Quick_sort {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 10, 3, 4, 8, 5, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int arr[], int start, int end) {
        if (start >= end)
            return;
        int s = start;
        int e = end;
        int tmp = arr[start];
        while (s < e) {
            //这里的时候很容易出现相等的情况却没有做交换，导致死循环
            while (s < e && arr[e] >= tmp)
                e--;
            arr[s] = arr[e];
            while (s < e && arr[s] <= tmp)
                s++;
            arr[e] = arr[s];
        }
        arr[s] = tmp;
        quickSort(arr, start, s - 1);
        quickSort(arr, s + 1, end);
    }
}
