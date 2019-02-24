package Oct15;

public class Backpack {
    public static void main(String[] args) {
        int weight = 12;
        int v[] = {8,10,6,3,7,2};
        int w[] = {4,6,2,2,5,1};
        findLar(v,w,weight);

    }
    public static int findLar(int v[],int w[],int weight){
        int m = weight;
        int n = w.length+1;
        int array[][] = new int[n][m];
        for (int i = 1; i < n ; i++) {
            for (int j = 1; j < m; j++) {
                if(j>=w[i-1])
                    array[i][j] = Math.max(array[i-1][j-w[i-1]]+v[i-1],array[i-1][j]);
                else
                    array[i][j] = array[i-1][j];
            }
        }
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        return array[n-1][m-1];
    }
}
