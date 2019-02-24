package Oct27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sub {
    public static void main(String[] args) {
        int array[] = {2, 2};
        System.out.println(new Sub().findNthDigit(11));
    }

    public boolean subSet(int array[]) {
        if (array.length <= 1)
            return false;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        if (sum % 2 != 0)
            return false;
        sum %= 2;
        int dp[][] = new int[array.length + 1][sum + 1];
        for (int i = 0; i <= array.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {//表示前0个数，所以价值均为0；
                    dp[i][j] = 0;
                } else if (j < array[i - 1]) {//在装第i-1个数时，先判断剩余容量j是否大于array[i-1]
                    dp[i][j] = dp[i - 1][j]; //小于表示空间不够，所以维持不变
                } else {//空间够，就通过比较大小来判断是否该放入第i-1个数
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - array[i - 1]] + array[i - 1]);
                }
            }
        }
        return dp[array.length][sum] == sum;
    }

    public int nthUglyNumber(int n) {
        int ugly[] = new int[n];
        ugly[0] = 1;
        int num_2 = 0;
        int num_3 = 0;
        int num_5 = 0;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(Math.min(ugly[num_2] * 2, ugly[num_3] * 3), ugly[num_5] * 5);
            if (ugly[i] / ugly[num_2] == 2)
                num_2++;
            if (ugly[i] / ugly[num_3] == 3)
                num_3++;
            if (ugly[i] / ugly[num_5] == 5)
                num_5++;
        }
        return ugly[n - 1];
    }

    public boolean isUgly(int n) {
        while (n > 1) {
            if (n % 2 != 0 && n % 3 != 0 && n % 5 != 0) {
                return false;
            } else {
                while (n % 2 == 0)
                    n = n / 2;
                while (n % 3 == 0)
                    n = n / 3;
                while (n % 5 == 0)
                    n = n / 5;
            }
        }
        return true;
    }

    public int[] searchRange(int[] nums, int target) {
        boolean flag = true;
        int result[] = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                if (flag) {
                    result[0] = i;
                    flag = !flag;
                }
                result[1] = Math.max(result[1], i);
            }
        }
        return result;
    }

    public int lastRemaining(int n) {
        boolean flag = true;
        if (n == 1)
            return 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i += 2) {
            list.add(i);
        }
        flag = !flag;
        while (list.size() > 1) {
            List<Integer> l = new ArrayList<>();
            if (flag) {
                for (int i = 1; i < list.size(); i += 2) {
                    l.add(list.get(i));
                }
            } else {
                for (int i = list.size() - 2; i >= 0; i -= 2) {
                    l.add(list.get(i));
                }
                Collections.reverse(l);
            }
            flag = !flag;
            list = l;
        }
        return list.get(0);
    }

    public boolean canJump(int[] nums) {
        boolean flag[] = new boolean[nums.length];
        Arrays.fill(flag, false);
        if (nums.length <= 0)
            return false;
        flag[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                if (i + nums[i] + 1 >= nums.length)
                    return true;
                for (int j = 0; j <= nums[i]; j++) {
                    flag[j + i] = true;
                }
            }
        }
        return flag[nums.length - 1];
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length - k; i++) {
            for (int j = 1; j <= k; j++) {
                if (Math.abs(nums[j + i] - nums[i]) <= t)
                    return true;
            }
        }
        return false;
    }

    public int findNthDigit(int n) {
        String result = "";
        int count = 1;
        if (n < 10)
            return n;
        while (result.length() < n) {
            System.out.println(result);
            result = result+""+count;
            count++;
        }
        return  result.charAt(n - 1)-'0';
    }
}
