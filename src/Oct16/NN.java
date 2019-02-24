package Oct16;

public class NN{
    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(My_numSquares(8));
    }
    public static int numSquares(int n) {
        int array[]  = new int[n+1];
        array[0] = 0;
        for (int i = 1; i < array.length; i++)
            array[i] = Integer.MAX_VALUE;

        for (int i = 0; i <= n; ++i) {
            for (int j = 1; i + j * j <= n; ++j) {
                array[i + j * j] = Math.min(array[i + j * j], array[i] + 1);
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(i+" "+array[i]);
        }
        return array[n];
    }
    public static int My_numSquares(int n) {
        int array[] = new int[n+1];
        array[0] = 0;
        for (int i = 1; i < array.length; i++) {
            array[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <=n ; i++) {
            for (int j = 1; i+j*j <=n; j++) {
                array[i+j*j] = Math.min(array[i+j*j],array[i]+1);
            }
        }
        return array[n];
    }
}
