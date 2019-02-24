public class quick {
    public static void main(String[] args) {
        quick quick = new quick();
        int[] array = {6,5,4,3,2,1};

        quick.insert(array,0,array.length-1);
        for(int a : array)
            System.out.println(a);
    }
    public void insert(int[] a,int start,int end){
        if(start>end){
            return ;
        }
        int temp = a[start];
        int i=start,j = end;
        while(i<j) {
            while (  a[j] > temp&&i<j) {
                j--;
            }
            a[i] = a[j];

            while(a[i] < temp&&i<j){
                i++;
            }
            a[j] = a[i];
        }
        a[i] = temp;
        insert(a,start,i-1);
        insert(a,i+1,end);
    }
}
