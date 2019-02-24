package Dec5;

import java.util.*;

public class Arange {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] charArray = str.toCharArray();
        //输出按照输入字典顺序
        TreeSet<String> tempRes = new TreeSet<String>();
        PermutationCore(charArray, tempRes, 0);
        res.addAll(tempRes);
        return res;

    }

    private void PermutationCore(char[] charArray, TreeSet<String> tempRes, int loc) {
        if (charArray == null || charArray.length == 0 || loc < 0 || loc > charArray.length - 1) {
            return;
        }
        if (loc == charArray.length - 1) {
            tempRes.add(String.valueOf(charArray));//递归的出口
        } else {
            for (int i = loc; i < charArray.length; i++) {
                swap(charArray, i, loc);//将第一个字符与后面的字符交换
                PermutationCore(charArray, tempRes, loc + 1);//对后面所有的字符进行全排列
                swap(charArray, i, loc);//再将之前交换的字符交换回来，以便第一个字符再与其他字符交换
            }

        }
    }

    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public String largestTimeFromDigits(int[] A) {
        String tmp = "";
        for (int i = 0; i < A.length; i++) {
            tmp += A[i] + "";
        }
        List<String> res = Permutation(tmp);
        String result = "";
        int hours = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < res.size(); i++) {
            String tt = res.get(i);
            if (tt.charAt(0) > '2')
                continue;
            if (tt.charAt(0) == '2' && tt.charAt(1) > '3')
                continue;
            if (tt.charAt(2) > '5')
                continue;
            if (Integer.valueOf(tt.substring(0, 2)) > hours) {
                hours = Integer.valueOf(tt.substring(0, 2));
                min = Integer.valueOf(tt.substring(2, 4));
                tmp = tt.substring(0, 2) + ":" + tt.substring(2, 4);
            }
            if (hours == Integer.valueOf(tt.substring(0, 2))) {
                if (Integer.valueOf(tt.substring(2, 4)) > min) {
                    min = Integer.valueOf(tt.substring(2, 4));
                    tmp = tt.substring(0, 2) + ":" + tt.substring(2, 4);
                }
            }

        }
        return tmp;
    }

    public boolean reorderedPowerOf2(int N) {
        List<String> list = Permutation(N + "");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).charAt(0) == '0')
                continue;
            long tmp = Long.parseLong(list.get(i));
            boolean f = true;
            while (tmp > 1) {
                if (tmp % 2 != 0) {
                    f = false;
                    break;
                }
                tmp /= 2;
            }
            if (f)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Arange().toHex(-1));
    }

    List<Integer> list = new ArrayList();

    public int pop() {
        int i = 0;
        int index = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int j = 0; j < list.size(); j++) {
            map.put(list.get(j), map.getOrDefault(list.get(j), 0) + 1);
            if (map.get(list.get(j)) >= i) {
                i = map.get(list.get(j));
                index = j;
            }
        }
        int tmp = list.get(index);
        list.remove(index);
        return tmp;
    }

    //计算三位徒刑的面积
    public int projectionArea(int[][] grid) {
        if (null == grid || grid.length == 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            int tmp = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0)
                    sum++;
                tmp = Math.max(grid[i][j], tmp);
            }
            sum += tmp;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int tmp = 0;
            for (int j = 0; j < grid.length; j++) {
                tmp = Math.max(grid[j][i], tmp);
            }
            sum += tmp;
        }

        return sum;
    }

    //计算01出现的个数
    public int countBinarySubstrings(String s) {
        if (null == s || s.equals("") || s.length() <= 1)
            return 0;
        int res = 0;
        int arr[] = new int[s.length()];
        arr[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                res++;
                arr[i] = 1;
            } else {
                arr[i] = arr[i-1]+1;
                for (int j = i-1; j >=0 ; j--) {
                    if(s.charAt(i)==s.charAt(j))
                        continue;
                    if(arr[i]<=arr[j]){
                        res++;
                    }
                    break;
                }
            }
        }
        return res;
    }
    //将整数转16进制
    public String toHex(int n) {
        boolean flag = true;
        if(n<0){
            flag = false;
            n = -n;
        }
        StringBuffer s = new StringBuffer();
        String a;
        char []b = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        while(n != 0){
            s = s.append(b[n%16]);
            n = n/16;
        }
        if(flag)
            return s.reverse().toString();
        else{
            while(s.toString().length()<8){
                s.append("0");
            }
            a = s.reverse().toString();
            System.out.println(a);
            int index = a.length();
            for (int i = a.length()-1; i>=0; i--) {
                if(a.charAt(i)=='1')
                {
                    index = i;
                    break;
                }
            }
            char arr[] = a.toCharArray();
            for (int i = 0; i <a.length() ; i++) {
                if(i<index){
                    arr[i] = b[16-String.valueOf(b).indexOf(arr[i])-1];
                }
            }
            return String.valueOf(arr);
        }

    }


}
