package Oct15;

import alter.Quick;

import java.util.Queue;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {1,2,2,1,2,34,3,6,7,8,5,10,0};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSo(array,0,array.length-1);
        for (int k:array
             ) {
            System.out.println(k);
        }
    }
    public void quickSo(int[] array,int start ,int end){
        if(start>=end)
            return;
        int temp = array[start];
        int i = start,j = end;
        while(i<j){
            while(temp<=array[j]&&i<j)
                j--;
            array[i] = array[j];
            while(temp>=array[i]&&i<j)
                i++;
            array[j] = array[i];
        }
        array[i] = temp;
        quickSo(array,start,i-1);
        quickSo(array,i+1,end);
    }
}
