package HomeWork4;

import java.util.Arrays;

public class Zz {
    public static void main(String[] args) {
        System.out.println(convert("PAYPA",3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows)
            return s;
        String a = "";
        int col = (s.length() + (numRows - 1) * 2) / ((numRows - 1) * 2) * (numRows - 1);
        //int col = s.length();
        char arr[][] = new char[numRows][col];
        for (int k = 0; k < numRows; k++) {
            for (int l = 0; l < col; l++) {
                arr[k][l] = '0';
            }
        }
        int i = 0;
        int r = 0, j = 0;
        while (i < s.length()) {
            if (r == 0) {
                while (r < numRows) {
                    if(i == s.length())
                        break;
                    arr[r++][j] = s.charAt(i++);
                }
                if(r==numRows){
                    r-=2;
                    j ++;
                }
            }else{
                while(r>0){
                    if(i == s.length())
                        break;
                    arr[r--][j++] = s.charAt(i++);
                }
            }
        }
        for (int k = 0; k < numRows; k++) {
            for (int l = 0; l < col; l++) {
                System.out.print(arr[k][l]+" ");
                if(arr[k][l]!='0')
                    a+=arr[k][l];
            }
            System.out.println();
        }
        return a;

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null==matrix||matrix.length==0)
            return false;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if(target==matrix[i][j])
//                    return true;
//            }
//        }
        int i = 0 , j = matrix[0].length-1;
        while(i<matrix.length&&j>=0){
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]<target)
                i++;
            else
                j--;
        }
        return true;
    }
}
