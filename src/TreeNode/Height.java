package TreeNode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Height {
    public static void main(String[] args) {
        int i = 1;
        int j = i++;
        if ((i > ++j) && (i++ == j))
            i += j;
        System.out.println(i);
    }

    int re;

    public int height(TreeNode root, int height) {
        if (root == null)
            return height;
        if (root != null) {
            height++;
        }
        int left = height(root.left, 0);
        int right = height(root.right, 0);
        re = Math.max(re, left + right);
        System.out.println(root.val + " " + re);
        return Math.max(left, right) + height;
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> list = new ArrayList<>();
        if (S.length() < 3)
            return list;
        int i = 0;
        while (i < S.length()) {
            char temp = S.charAt(i);
            int j = i;
            while (i < S.length() && S.charAt(i) == temp) {
                i++;
            }

            if (i - j >= 4) {
                List<Integer> l = new ArrayList<>();
                l.add(j);
                l.add(i);
                list.add(l);
                i--;
            }
        }
        return list;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSame(s, t) || isSame(s.left, t) || isSame(s.right, t);
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (null == s && null == t)
            return true;
        else {
            if (null == s || null == t)
                return false;
            if (s.val != t.val)
                return false;
            return isSame(s.left, t.left) && isSame(s.right, t.right);
        }
    }

    //寻找最少的步数到达终点
    public int reachNumber(int target) {
        if (target < 0) return reachNumber(-target);
        int i = 1;
        while (i * (i + 1) < 2 * target) {
            i++;
        }
        if (i * (i + 1) == 2 * target) return i;
        else {
            if ((i * (i + 1) / 2 - target) % 2 == 0) return i;
            else {
                if (i % 2 == 0) return i + 1;
                else
                    return i + 2;
            }

        }
    }

    public int findUnsortedSubarray(int[] nums) {
        int arr[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] != nums[i]) {
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (arr[i] != nums[i]) {
                right = i;
                break;
            }
        }
        return left - right;
    }
    public String multiply(String num1, String num2) {
        if(num1.charAt(0)=='0'||num2.charAt(0)=='0')
            return "0";
        BigInteger b1 = new BigInteger(num1);
        BigInteger b2 = new BigInteger(num2);
        return  b1.multiply(b2)+"";


    }
}
