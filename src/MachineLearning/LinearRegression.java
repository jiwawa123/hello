package MachineLearning;

import java.util.*;

public class LinearRegression {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new TreeSet<>();
        int m = (int) (Math.log(bound * 1.0) / Math.log(x * 1.0));
        if (x == 1)
            m = 1;
        int n = (int) (Math.log(bound * 1.0) / Math.log(y * 1.0));
        if (y == 1)
            n = 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if ((int) Math.pow(x, i) + (int) Math.pow(y, j) <= bound)
                    set.add((int) Math.pow(x, i) + (int) Math.pow(y, j));
                if ((int) Math.pow(x, i) + (int) Math.pow(y, j) > bound)
                    break;
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {

    }

    public int arrayNesting(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean arr[] = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(arr[nums[i]])
                continue;
            int len = 0;
            Map<Integer, Integer> tmp = new HashMap<>();
            int k = nums[i];
            while (!tmp.containsKey(k)) {
                arr[nums[i]] = true;
                tmp.put(k, 1);
                k = map.get(k);
                len++;
            }
            if (len > max) {
                max = len;
            }

        }
        return max;
    }
}
