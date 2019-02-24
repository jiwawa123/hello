package Oct9;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] array = {{1,2,0},{2,3,4},{0,2,3}};
        setZero(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void setZero(int[][] matrix){
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if(matrix[i][j]==0)
                {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(row.contains(i)||col.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}
