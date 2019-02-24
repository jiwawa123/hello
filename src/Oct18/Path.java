package Oct18;

public class Path {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {

        int array[][] = new int[m][n];
        for (int i = 1; i < array.length; i++)
            array[i][0] = 1;
        for (int i = 1; i < array[0].length; i++)
            array[0][i] = 1;
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }
        return array[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;
        int array[][] = new int[m][n];
        array[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                array[i][0] = array[i - 1][0];
            } else {
                array[i][0] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0)
                array[0][i] = array[i - 1][0];
            else
                array[0][i] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 0)
                    array[i][j] = array[i - 1][j] + array[i][j - 1];
                else
                    array[i][j] = 0;
            }
        }
        return array[m-1][n-1];
    }
}
