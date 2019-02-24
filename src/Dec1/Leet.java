package Dec1;

import java.lang.reflect.Array;
import java.util.*;

public class Leet {
    public static void main(String[] args) {
        System.out.println("hello".indexOf('h'));
        System.out.println("hello".substring(0,"hello".indexOf('h')));
        System.out.println("hello".substring("hello".indexOf('h')+1,"hello".length()));
    }

    public boolean judgeSquareSum(int c) {
        int j = (int) Math.sqrt(c);
        for (int i = 0; i <= j; ) {
            int temp = i * i + j * j;
            if (temp == c)
                return true;
            if (temp < c)
                i++;
            if (temp > c)
                j--;
        }
        return false;
    }

    public int countPrimes(int n) {
        if (n <= 1)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int count = 2;
        for (int i = 4; i <= n; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }
        return count;
    }

    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : nums
                ) {
            if (map.containsKey(k)) {

                return k;
            } else
                map.put(k, 1);
        }
        return 0;
    }

    public int sum(String prefix) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String str : map.keySet()
                ) {
            if (str.substring(0, prefix.length()).equals(prefix))
                count += map.get(str);

        }
        return count;
    }

    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                result = Math.max(Math.min(height[i], height[j]) * (j - i), result);
            }
        }
        return result;
    }

    public int[] dailyTemperatures(int[] t) {
        int arr[] = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            arr[i] = 0;
            for (int j = i + 1; j < t.length; j++) {
                if (t[j] > t[i]) {
                    arr[i] = j - i;
                    continue;
                }
            }
        }
        return arr;
    }

    public void setZeroes(int[][] matrix) {
        boolean h[] = new boolean[matrix.length];
        boolean v[] = new boolean[matrix[0].length];
        Arrays.fill(h, false);
        Arrays.fill(v, false);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    h[i] = true;
                    v[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (h[i] || v[i]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public boolean subQueue(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            int temp = findIndex(s.charAt(i), t);
            if (temp == -1)
                return false;
            t = t.substring(temp);
        }

        return true;
    }

    public int findIndex(char a, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (a == s.charAt(i))
                return i;
        }
        return -1;
    }

    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp = 0;
        while (!map.containsKey(temp)) {
            temp = 0;
            map.put(n, 0);
            while (n > 0) {
                temp = temp + (int) Math.pow((n % 10), 2);
                n /= 10;
            }
            if (temp == 1)
                return true;
            n = temp;
        }
        return temp == 1;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        boolean flag[] = new boolean[nums2.length];
        Arrays.fill(flag, true);
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && flag[j]) {
                    set.add(nums1[2]);
                    flag[j] = false;
                    break;
                }

            }
        }
        int arr[] = new int[set.size()];
        int i = 0;
        for (int k : set
                ) {
            arr[i++] = k;
        }
        return arr;
    }

    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0) < 2) {
                nums[index++] = nums[i];
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return index + 1;
    }

    public int[] nextGreaterElements(int[] nums) {
        int lon[] = new int[nums.length * 2];
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            lon[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            lon[i + nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = i + 1; j < lon.length; j++) {
                if (nums[i] < lon[j]) {
                    flag = false;
                    result[i] = j > nums.length ? j - nums.length : j;
                    break;
                }
            }
            if (flag)
                result[i] = -1;
        }
        return result;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] re = new int[nums1.length];
        Arrays.fill(re, -1);
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    flag = true;
                }
                if (flag && nums2[j] > nums1[i]) {
                    re[i] = nums2[j];
                    break;
                }
            }
        }
        return re;
    }

    public boolean search(String word) {
        Map<String, Integer> map = new HashMap<>();
        String str[] = word.split("\\.");
        for (String s : str) {
            boolean flag = false;
            for (String sm : map.keySet()) {
                if (!s.equals("") && sm.contains(s)) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return false;
        }
        return true;
    }

    public boolean pan(String a, String b) {

        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != '.' && a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int j = matrix[0].length - 1, i = 0;
        while (j >= 0 && i < matrix.length) {
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }

    public int numUniqueEmails(String[] emails) {
        int count = 0;
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (String email : emails
                ) {
            String[] str = email.split("@");
            for (int i = 0; i < str[0].length(); i++) {
                if (str[0].charAt(i) == '+') {
                    str[0] = str[0].substring(0, i);
                    break;
                }
            }
            str[0] = str[0].replaceAll("\\.", "");
            if (map.containsKey(str[1])) {
                Map<String, Integer> m = map.get(str[1]);

                if (!m.containsKey(str[0])) {
                    count++;
                    m.put(str[0], 1);
                    map.put(str[1], m);
                }
            } else {
                Map<String, Integer> m = new HashMap<>();
                m.put(str[0], 1);
                map.put(str[1], m);
                count++;
            }
        }
        return count;
    }

    public int[][] transpose(int[][] A) {
        if (A == null)
            return null;
        int re[][] = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                re[j][i] = A[i][j];
            }
        }
        return re;
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals(""))
            return 0;
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }

    public String reverseOnlyLetters(String S) {
        int i = 0, j = S.length() - 1;
        char[] s = S.toCharArray();
        while (i < j) {
            if (!isZM(s[i]) && i < j) {
                i++;
            }
            if (!isZM(s[j]) && i < j) {
                j--;
            }
            if (i < j) {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
            }
        }
        S = String.valueOf(s);
        return S;
    }

    public boolean isZM(char a) {
        return (a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z');
    }

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() <= 1)
            return false;
        String temp = s.substring(0, s.length() / 2);
        while (temp.length() >= 1) {
            boolean flag = true;
            int i ;
            for (i = 0; i < s.length() - temp.length()+1; i += temp.length()) {

                if (!s.substring(i, i + temp.length()).equals(temp)) {
                    flag = false;
                    break;
                }
            }

            if(i == s.length()&&flag)
                return true;
            temp = temp.substring(0,temp.length()-1);
        }
        return false;
    }
    public int firstUniqChar(String s) {
        Map<Character,Integer> map =new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1)
                return i;
        }
        return  -1;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0)
            return 0;

        List<Integer> a = triangle.get(0);
        List<Integer> b = triangle.get(0);
        for (int i = 1; i < triangle.size(); i++) {
            b = triangle.get(i);
            for (int j = 0; j < b.size(); j++) {
                if(j==0)
                    b.set(j,b.get(j)+a.get(0));
                else if(j==b.size()-1)
                    b.set(j,b.get(j)+a.get(a.size()-1));
                else
                    b.set(j,Math.min(a.get(j-1),a.get(j))+b.get(j));
            }
            a = b;
        }
        int count = Integer.MIN_VALUE;
        for (int k:b
             ) {
            if(k>count)
                count = k ;
        }
        return count;
    }
    public int[] productExceptSelf(int[] nums) {
        int countZero = 0;
        int re = 1;
        int c = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0)
                countZero++;
            else
                c *= nums[i];
            re *= nums[i];

        }
        if(countZero>=2){
            Arrays.fill(nums,0);
        }
        if(countZero==1){
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]==0)
                    nums[i] = c;
                else
                    nums[i] = 0;
            }
        }
        if(countZero==0){
            for (int i = 0; i < nums.length; i++) {
                nums[i] = re/nums[i];
            }
        }
        return nums;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list =new ArrayList<>();
        if(numRows==0)
            return list;
        List<Integer> l = new ArrayList<>();
        l.add(1);
        list.add(l);
        int i = 2;
        while(i<=numRows){
            l = new ArrayList();
            List<Integer> t = list.get(i-2);
            for (int j = 0; j < i; j++) {
                if(j==0)
                    l.add(t.get(0));
                else if(j==i-1)
                    l.add(t.get(t.size()-1));
                else
                    l.add(t.get(j-1)+t.get(j));
            }
            list.add(l);
        }
        i++;
        return list;
    }

}
