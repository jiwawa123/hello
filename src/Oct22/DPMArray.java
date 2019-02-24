package Oct22;

public class DPMArray {
    public static void main(String[] args) {
        int array[] = {2,3,1,2,3,4,5,6,};
        System.out.println(findMl(array));
    }

    public static int findMl(int[] array) {
        if (array.length <= 1)
            return array.length;
        int[] arr = new int[array.length];
        arr[0] = 1;
        int result = 1;
        for (int i = 1; i < array.length; i++) {
            int count = 0;
            arr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    arr[i] = Math.max(arr[j]+1,arr[i]);
                    result = Math.max(result,arr[i]);
                }
            }
        }
        return result;
    }

}
