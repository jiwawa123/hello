package Dec5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Tran {
    public void rotate(int[][] matrix) {
        int arr[][] = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = matrix.length - 1; i >= 0; i--) {
                arr[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = arr[i][j];
            }
        }
    }

    public int jump(int[] nums) {
        int arr[] = new int[nums.length];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < i + nums[i] + 1; j++) {
                if (j >= nums.length)
                    break;
                arr[j] = Math.min(arr[j], arr[i] + 1);
            }
        }
        return arr[nums.length - 1];
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 1, 4};
        System.out.println(new Tran().jump(arr));
    }

    public int longestValidParentheses(String s) {
        int len = 0;
        for (int i = 0; i < s.length(); i++) {

        }
        return len;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    int aa = stack.pop();
                    int bb = stack.pop();
                    stack.push(-(aa - bb));
                    break;
                case "*":
                    int aaa = stack.pop();
                    int bbb = stack.pop();
                    stack.push(aaa * bbb);
                    break;
                case "/":
                    int aaaa = stack.pop();
                    int bbbb = stack.pop();
                    stack.push(bbbb / aaaa);
                    break;
                default:
                    stack.push(Integer.valueOf(tokens[i]));
            }

        }
        return stack.pop();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if(words[i].equals("")||null==words[i]||words[j].equals("")||null==words[j]){
                    String s1 = words[i]+words[j];
                    if(palindrome(s1)){
                        List<Integer> ll = new ArrayList<>();
                        ll.add(i);
                        ll.add(j);
                        l.add(ll);
                    }
                    String s2 = words[j]+words[i];
                    if(palindrome(s2)){
                        List<Integer> ll = new ArrayList<>();
                        ll.add(j);
                        ll.add(i);
                        l.add(ll);
                    }
                    continue;
                }
                if(words[i].charAt(0)==words[j].charAt(words[j].length()-1)){
                    String s1 = words[i]+words[j];
                    if(palindrome(s1)){
                        List<Integer> ll = new ArrayList<>();
                        ll.add(i);
                        ll.add(j);
                        l.add(ll);
                    }
                }
                if(words[j].charAt(0)==words[j].charAt(words[i].length()-1)){
                    String s2 = words[j]+words[i];
                    if(palindrome(s2)){
                        List<Integer> ll = new ArrayList<>();
                        ll.add(j);
                        ll.add(i);
                        l.add(ll);
                    }
                }
            }
        }
        return l;
    }

    public boolean palindrome(String string) {
        if (null == string || string.length() <= 1)
            return true;
        int i = 0, j = string.length() - 1;
        while (i < j) {
            if (string.charAt(i++) != string.charAt(j--))
                return false;

        }
        return true;
    }
}
