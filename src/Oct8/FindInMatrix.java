package Oct8;
/*
如何使用在矩阵中查找相应的数据
 */
public class FindInMatrix {
    public static void main(String[] args) {
        int array[][] = {{1,2,3},{4,5,6},{6,8,9}};
        System.out.println(findInMatrix(array,7));
    }
    public static boolean  findInMatrix(int[][] a,int k){
        int i =0;
        int j =a[0].length-1;
        while(j>=0&&i<a.length){
            if(a[i][j]==k)
                return true;
            else if(a[i][j]<k)
                i++;
            else if(a[i][j]>k)
                j--;
        }
        return false;
    }
}
