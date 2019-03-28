package sort;/*
    user ji
    data 2019/3/25
    time 8:24 AM
*/

import java.util.Arrays;

public class Heap_sort {
    public static void main(String[] args) {
        int arr[] = {100,-1,1,2,5,6,10,3,5};
        build_tree(arr,arr.length-1);
        for (int i = arr.length-1; i >=0 ; i--) {
            swap(arr,0,i);
            build_tree(arr,i);
        }
        System.out.println(Arrays.toString(arr));
    }

    /*
    完成两个数之间的交换
     */
    public static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /*
    构建一棵树
     */
    public static void build_tree(int arr[], int len) {
        int end = (len - 1) % 2;
        for (int i = end; i >= 0; i--) {
            happify(arr, i, len);
        }
    }

    /*
    在第一次排序的过程中，不仅要找出第一个根，
    同时需要满足整棵树都必须满足堆结构，顾使用递归
    递归实现依次交换
     */
    private static void happify(int[] arr, int i, int len) {
        if (i >= len)
            return;
        int max = i;
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        if (c1 < len && arr[max] < arr[c1])
            max = c1;
        if (c2 < len && arr[max] < arr[c2])
            max = c2;
        if(i!=max){//开始做交换
            swap(arr,i,max);
            //开始递归寻找
            happify(arr,max,len);
        }

    }

}
