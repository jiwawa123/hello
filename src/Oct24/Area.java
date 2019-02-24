package Oct24;

import java.util.Arrays;

public class Area {
    public static void main(String[] args) {

    }
    public int findMostArea(char[][] array){
        int result = 0;
        int m = array.length;
        int n = array[0].length;
        int height[] = new int[n];
        int left[] = new int[n];
        int right[] = new int[n];
        Arrays.fill(right,n);
        for (int i = 0; i < m; i++) {
            int curLeft = 0,curRight = n;
            for (int j = 0; j < n; j++) {
                if(array[i][j]=='1'){
                    height[j]++;
                    left[j] = Math.max(curLeft,left[j]);
                }else{
                    left[j] = 0;
                    curLeft = j+1;
                    height[j] = 0;
                }
            }
            for (int j = n-1; j >=0 ; j++) {
                if(array[i][j]=='1'){
                    right[j] = Math.min(curRight,right[j]);
                }else{
                    right[j] = n;
                    curRight = j;
                }
            }
            for (int j = 0; j <n ; j++) {
                result = Math.max(result,height[j]*(right[j]-left[j]));
            }
        }
        return result;
    }
}
