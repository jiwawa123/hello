package Dec26;

import java.util.*;

public class Roman {
    public int romanToInt(String s) {
        if (null == s || s.equals(""))
            return 0;
        Map<String, Integer> map = new HashMap();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        if (s.length() < 2)
            return map.get(s);
        int count = 0;
        while (s.length() >= 2) {
            switch (s.substring(0, 2)) {
                case "IV":
                    count += 4;
                    s.substring(2, s.length());
                    break;
                case "IX":
                    count += 9;
                    s.substring(2, s.length());
                    break;
                case "XL":
                    count += 40;
                    s.substring(2, s.length());
                    break;
                case "XC":
                    count += 90;
                    s.substring(2, s.length());
                    break;
                case "CD":
                    count += 400;
                    s.substring(2, s.length());
                    break;
                case "CM":
                    count += 900;
                    s.substring(2, s.length());
                    break;
                default:
                    count += map.get(s.substring(0, 1));
                    s = s.substring(1, s.length());
                    break;
            }
        }
        while (!s.equals("")) {
            count += map.get(s.substring(0, 1));
            s = s.substring(1, s.length());
        }
        return count;
    }

    public String intToRoman(int num) {
//        Map<String,Integer> map = new HashMap();
//        map.put("I",1);
//        map.put("V",5);
//        map.put("X",10);
//        map.put("L",50);
//        map.put("C",100);
//        map.put("D",500);
//        map.put("M",1000);
        String re = "";
        while (num >= 1) {
            while (num >= 1000) {
                re += "M";
                num -= 1000;
            }
            while (num >= 900) {
                re += "CM";
                num -= 900;
            }
            while (num >= 500) {
                re += "D";
                num -= 500;
            }
            while (num >= 400) {
                re += "LD";
                num -= 400;
            }
            while (num >= 100) {
                re += "C";
                num -= 100;
            }
            while (num >= 90) {
                re += "XC";
                num -= 90;
            }
            while (num >= 50) {
                re += "L";
                num -= 50;
            }
            while (num >= 40) {
                re += "XL";
                num -= 40;
            }
            while (num >= 10) {
                re += "X";
                num -= 10;
            }
            while (num >= 9) {
                re += "IX";
                num -= 9;
            }
            while (num >= 5) {
                re += "V";
                num -= 5;
            }
            while (num >= 4) {
                re += "IV";
                num -= 4;
            }
            while (num >= 1) {
                re += "I";
                num -= 1;
            }
        }
        return re;
    }

    public int coinChange(int[] coins, int amount) {
        if (null == coins || amount < 0)
            return -1;
        //Arrays.sort(coins);
        int arr[] = new int[amount + 1];
        arr[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int k : coins
                    ) {
                int tmp = i - k;
                if (arr[tmp] != -1)
                    min = Math.min(min, arr[tmp] + 1);
            }
            arr[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return arr[amount];
    }

    //
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = A.length / 2;
        for (int i = 0; i < A.length; i++) {
            if (map.getOrDefault(A[i], 0) == n - 1)
                return A[i];
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        return 0;
    }

    //
    public int maxWidthRamp(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A.length - i < res)
                break;
            for (int j = A.length - 1; j >= 0; j--) {
                if (j - i <= res)
                    break;
                if (A[i] <= A[j]) {
                    res = Math.max(res, j - i);
                }

            }
        }
        return res;
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        helper(res, new ArrayList<Integer>(), nums, 0);
        return new ArrayList<List<Integer>>(res);
    }

    private void helper(Set<List<Integer>> res, List<Integer> subList, int[] nums, int start) {
        if (subList.size() >= 2) {
            res.add(new ArrayList<Integer>(subList));
        }
        for (int i = start; i < nums.length; i++) {
            if (subList.size() == 0 || subList.get(subList.size() - 1) <= nums[i]) {
                subList.add(nums[i]);
                helper(res, subList, nums, i + 1);
                subList.remove(subList.size() - 1);
            }
        }
    }

    public void myHelper(Set<List<Integer>> res, List<Integer> subList, int[] nums, int start) {
        if (subList.size() >= 2)
            res.add(new ArrayList<Integer>(subList));
        for (int i = start; i < nums.length; i++) {
            if (subList.size() == 0 || nums[i] >= subList.get(subList.size() - 1)) {
                subList.add(nums[i]);
                myHelper(res, subList, nums, i + 1);
                subList.remove(subList.size() - 1);
            }

        }
    }

    public static void setAll(Set<List<Integer>> res, List<Integer> subList, int[] nums, int start) {
        if (subList.size() >= 1)
            res.add(new ArrayList<Integer>(subList));
        for (int i = start; i < nums.length; i++) {
            subList.add(nums[i]);
            setAll(res, subList, nums, i + 1);
            subList.remove(subList.size() - 1);

        }
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static void setSum(Set<List<Integer>> res, List<Integer> subList, int[] nums, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(subList));
            return;
        }
        if (target < 0)
            return;
        for (int i = start; i < nums.length; i++) {
            subList.add(nums[i]);
            setSum(res, subList, nums, i + 1, target - nums[i]);
            subList.remove(subList.size() - 1);
        }
    }

    //有效的括号，设计两个stack一个用来存放（，一个用来存放*
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer>  star = new Stack<>();
        int i = 0;
        while(i<s.length()){
            switch (s.charAt(i)){
                case '(':
                    left.push(i);
                    break;
                case '*':
                    star.push(i);
                    break;
                default:
                    if(left.isEmpty()&&star.isEmpty())
                        return false;
                    if(!left.isEmpty())
                    {
                        left.pop();
                        break;
                    }
                    if(!star.isEmpty())
                    {
                        star.pop();
                        break;
                    }
                    break;
            }
        }
        while(!left.isEmpty()&&!star.isEmpty()){
            if(left.peek()>star.peek())
                return false;
            left.pop();
            star.pop();
        }
        return left.isEmpty();
    }
    public static String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while(idx < s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int count = 0;
                while(Character.isDigit(s.charAt(idx))){
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }else if(s.charAt(idx) == '['){
                resStack.push(res);
                res = "";
                idx++;
            }else if(s.charAt(idx) == ']'){
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for(int i = 0; i < repeatTimes; i++)
                    temp.append(res);
                res = temp.toString();
                idx++;
            }else{
                res += s.charAt(idx++);
            }
        }
        return res;
    }


    public int change(int amount, int[] coins) {
        int arr[] = new int[amount+1];
        arr[0] = 0;
        for (int i = 1; i < amount; i++) {
            for (int k:coins
                 ) {
                
            }
        }
        return arr[amount];
    }
}
