package Oct27;


import Oct24.ListNode;

import java.lang.reflect.Array;
import java.util.*;

public class Leet {
    public static void main(String[] args) {
        int array[] = {5, 4, 3, 2, 1};
        System.out.println(new Leet().findRelativeRanks(array));
    }

    public String convertToTitle(int n) {
        String result = "";
        while (n > 0) {
            result += (char) ('A' + (n - 1) % 26);
            n = (n - 1) / 26;

        }
        return new StringBuffer(result).reverse().toString();
    }

    public String toLowerCase(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                temp = (char) (s.charAt(i) + 32) + "";
            } else {
                temp = s.charAt(i) + "";
            }
            str += temp;
        }
        return str;
    }

    public int[] sortArrayByParity(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                continue;
            } else {
                int temp = A[i];
                int j = i + 1;
                while (j < A.length && A[j] % 2 != 0) {
                    j++;
                }
                if (j < A.length) {
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
        return A;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList();
        for (int i = left; i <= right; i++) {
            int temp = i;
            boolean flag = true;
            while (temp > 0) {
                if (temp % 10 == 0 || i % (temp % 10) != 0) {
                    flag = false;
                    continue;
                }
                temp = temp / 10;
            }
            if (flag)
                list.add(i);
        }
        return list;
    }

    public int[] sortArrayByParityII(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == A[i] % 2) {
                continue;
            } else {
                int t = i + 1;
                while ((t < A.length && t % 2 == A[t] % 2) || (A[t] % 2 != i % 2))
                    t++;
                if (t < A.length) {
                    int temp = A[i];
                    A[i] = A[t];
                    A[t] = temp;
                }

            }
        }
        return A;
    }

    public boolean judgeCircle(String moves) {
        int h = 0, v = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                h--;
            } else if (moves.charAt(i) == 'R') {
                h++;
            } else if (moves.charAt(i) == 'U') {
                v++;
            } else if (moves.charAt(i) == 'D') {
                v--;
            }
        }
        return h == 0 && v == 0;
    }

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new TreeSet<>();
        for (int k : candies
                ) {
            set.add(k);
        }
        return Math.min(candies.length / 2, set.size());
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else
                map.put(nums[i], 0);
        }
        int result = 0;
        for (int k : map.keySet()
                ) {
            result = k;
        }
        return result;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int len = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[len - 1]) {
                nums[len++] = nums[i];
            }//if
        }//f
        return len;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0) + 1 > nums.length / 2)
                return nums[i];
            else
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return 0;
    }

    public List<Integer> majorityElementI(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int k : map.keySet()
                ) {
            if (map.get(k) > nums.length / 3)
                list.add(k);
        }
        return list;
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int len = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (isExist(nums1[i], nums2))
                set.add(nums1[i]);
        }
        int result[] = new int[set.size()];
        int i = 0;
        for (int k : set
                ) {
            result[i++] = k;
        }
        return result;
    }

    public boolean isExist(int k, int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            if (k == nums[i])
                return true;
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                return true;
            else
                map.put(nums[i], 0);
        }
        return false;
    }

    public String[] findRelativeRanks(int[] nums) {
        String[] str = new String[nums.length];
        int temp[] = new int[nums.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = temp.length - 1; j >= 0; j--) {
                if (nums[i] == temp[j]) {
                    System.out.println(j);
                    if (temp.length - 1 - j == 0)
                        str[i] = "Gold Medal";
                    else if (temp.length - 1 - j == 1)
                        str[i] = "Silver Medal";
                    else if (temp.length - 1 - j == 2)
                        str[i] = "Bronze Medal";
                    else
                        str[i] = temp.length - j + "";
                    continue;
                }
            }
        }
        return str;
    }

    public double findMaxAverage(int[] nums, int k) {

        int result = 0;
        for (int i = 0; i < k; i++) {
            result += nums[i];
        }
        for (int i = 1; i < nums.length - k; i++) {
            int count = 0;
            for (int j = i; j < i + k; j++) {
                count += nums[j];
            }
            result = Math.max(result, count);
        }
        return result * 1.0 / k;
    }

    public int singleNumberI(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0) == 2)
                map.remove(nums[i]);
            else
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int result = 0;
        for (int k : map.keySet()
                ) {
            result = k;
        }
        return result;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0) == 1) {
                map.remove(nums[i]);
                list.add(nums[i]);
            } else
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return list;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        ListNode re = new ListNode(0);
        ListNode temp = re;
        int i = 0;
        while (i < list.size()) {
            if (i + k <= list.size()) {
                for (int j = k + i - 1; j >= i; j--) {
                    ListNode t = new ListNode(list.get(j));
                    temp.next = t;
                    temp = t;
                }
            }
            i += k;
        }
        while (i != list.size()) {
            ListNode t = new ListNode(list.get(i));
            temp.next = t;
            temp = t;
            i++;
        }
        return re;
    }

    //提莫攻击
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        int temp = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] == 0) {
                count += duration;
                temp += duration;
            } else {
                if (timeSeries[i] >= temp) {
                    count += duration;
                    temp = timeSeries[i] + duration;
                } else {
                    if (timeSeries[i] + duration > temp) {
                        count += timeSeries[i] + duration - temp;
                        temp = timeSeries[i] + duration;
                    }
                }
            }
        }
        return count;
    }

    //最小移动
    public int minMoves(int[] nums) {
        if (nums.length <= 1)
            return 1;
        int max = Integer.MIN_VALUE;
        for (int k : nums)
            max = Math.max(max, k);
        int count = 0;
        for (int k : nums)
            count += max - k;
        return count;

    }

    //图片平滑器
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int re[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = M[i][j];
                int count = 1;
                if (i - 1 >= 0) {
                    temp += M[i - 1][j];
                    count++;
                }

                if (i + 1 < m) {
                    temp += M[i + 1][j];
                    count++;
                }

                if (j - 1 >= 0) {
                    temp += M[i][j - 1];
                    count++;
                }

                if (j + 1 < n) {
                    temp += M[i][j + 1];
                    count++;
                }

                if (i - 1 >= 0 && j - 1 >= 0) {
                    temp += M[i - 1][j - 1];
                    count++;
                }

                if (i - 1 < m && j + 1 < n) {
                    temp += M[i + 1][j + 1];
                    count++;
                }

                if (i + 1 < m && j - 1 >= 0) {
                    temp += M[i + 1][j - 1];
                    count++;
                }

                if (i + 1 < m && j + 1 < n) {
                    temp += M[i + 1][j + 1];
                    count++;
                }


                re[i][j] = temp / count;
            }
        }
        return re;
    }
}
