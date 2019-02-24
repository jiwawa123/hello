package alter;

public class Quick {
    public static void main(String[] args) {
        int array[] = {0,0,0,0,0,0};
        quick(0,array.length-1,array);
        for(int k :array)
            System.out.println(k);
    }
    public static void quick(int start,int end ,int[] array){
        if(start>=end){
            return;
        }
        int i = start,j=end;
        int temp = array[i];
        while(i<j){
            while(array[j]>=temp&&i<j)
                j--;
            array[i] = array[j];
            while(array[i]<=temp&&i<j)
                i++;
            array[j] = array[i];
        }
        array[i] =temp;
        quick(start,i-1,array);
        quick(i+1,end,array);
    }
}
