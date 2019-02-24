package Oct22;

public class LCA {
    public static void main(String[] args) {
        int array1[] = {1, 2, 3, 4, 6, 8, 7, 8, 20};
        int array2[] = {1, 2, 3, 8, 8, 20};
        System.out.println(findLAS(array1, array2));
    }
    public static int findLAS(int array1[], int array2[]) {
        int m = array1.length + 1, n = array2.length + 1;
        int array[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            array[i][0] = 0;
        for (int i = 0; i < n; i++)
            array[0][i] = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (array1[i - 1] == array2[j - 1]) {
                    array[i][j] = array[i-1][j-1]+1;
                } else {
                    array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
                }
            }
        }
        return array[m - 1][n - 1];
    }
}
