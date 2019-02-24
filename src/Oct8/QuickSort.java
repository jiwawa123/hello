package Oct8;

public class QuickSort {
    public static void main(String[] args) {
        int array[] = {2,2,2,3,4,1,1,6,5,4,7,8,7};
        quickSort(array,0,array.length-1);
        System.out.println(array);
    }
    public static void quickSort(int[] array, int start,int end){
        if(start>=end)
            return;
        int temp = array[start];
        int i = start,j=end;
        while(i<j){
            if(i<j&&array[j]>=temp)
                j--;
            array[i] = array[j];
            if(i<j&&array[i]<=temp)
                i++;
            array[j] = array[i];
        }
        array[i] = temp;
        quickSort(array,start,i);
        quickSort(array,i+1,end);

    }
}
