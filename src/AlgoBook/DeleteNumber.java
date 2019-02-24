package AlgoBook;

import java.util.Arrays;

public class DeleteNumber {
    public static void main(String[] args) {
        int arr[] = {9,2,3,4,7,9};
        System.out.println(Arrays.toString(new DeleteNumber().deleteLarge(arr,3)));
    }
    //设计思路：在不同的格子里面寻找最小的格子，然后开始相应的处理
    public int[] deleteLarge(int arr[] ,int k){
        int tmp = arr.length - k;
        int res[] = new int[tmp];
        int i = 0;
        int index = -1;
        while(i<tmp){
            int max = Integer.MAX_VALUE;
            for (int j = index+1; j < index+k+i+1&&j<arr.length; j++) {
                if(arr[j]<max){
                    index = j;
                    max = arr[j];
                }
            }
            System.out.println(max+" "+index);
            res[i++] = max;
        }
        return res;
    }
}
