package Oct15;

public class Zixulie {
    public static void main(String[] args) {
        int a[] = {70,39,25,40,7},
         b[] = {52,20,67,5,31};
        System.out.println(new Zixulie().findLength(a,b));
    }

    public static int getResult(int[] array) {
        if (array.length == 1)
            return array[0];
        int result = array[0], temp = array[0];
        for (int i = 1; i < array.length; i++) {
            temp = Math.max(array[i], temp + array[i]);
            result = Math.max(result, temp);
        }
        return result;
    }

    public static int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length == 1)
            return result;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - buy > result) {
                result = prices[i] - buy;
            } else if (buy > prices[i])
                buy = prices[i];

        }
        return result;
    }

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int fi = nums[0], se = nums[1];
        int result = Math.max(fi, se);
        for (int i = 2; i < nums.length; i++) {
            if (fi + nums[i] > result) {
                result = fi + nums[i];
                fi = se;
                se = result;
            } else {
                result = se;
                fi = se;
            }
        }
        return result;
    }

    public int minCostClimbingStairs(int[] cost) {
        int result = 0;
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int fi = 0, se = 0;
        int array[] = new int[cost.length + 1];
        array[0] = array[1] = 0;
        for (int i = 2; i < array.length; i++) {
            array[i] = Math.min(cost[i - 1] + array[i - 1], cost[i - 2] + array[i - 2]);
        }
        return array[cost.length];
    }

    public int minPathSum(int[][] grid) {
        if (grid == null)
            return 0;
        for (int i = 1; i < grid[0].length; i++)
            grid[0][i] += grid[0][i - 1];
        for (int i = 1; i < grid.length; i++)
            grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++)
                grid[i][j] += Math.min(grid[i - 1][j], grid[j - 1][i]);

        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0)
            return 0;
        String str1 = "";
        String str2 = "";
        for (int k : A)
            str1 += k;
        for (int k : B)
            str2 += k;
        changeString(str1, str2);
        int result = 0;
        for (int i = 0; i < str2.length() ; i++) {
            if(str1.contains(str2.substring(i,str2.length()))){
                result = str2.length() - i;
                break;
            }
        }
        for (int i = str2.length()-1; i >= 0 ; i--) {
            if(i<result){
                break;
            }
            if(str1.contains(str2.substring(i,str2.length()))){
                result = str2.length() - i;
                break;
            }
        }
        return result;
    }

    public void changeString(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = a;
        }
    }

}
