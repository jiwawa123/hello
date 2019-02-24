package NewB;

import java.util.*;

public class Atlantic {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                boolean f1 = false, f2 = false;
                if (i == 0 || i == matrix.length - 1)
                    f1 = true;
                else {
                    if (i > 0 && matrix[i][j] > matrix[i - 1][j])
                        f1 = true;
                    if (j > 0 && matrix[i][j] > matrix[i][j - 1])
                        f1 = true;
                }

                if (j == matrix[i].length - 1 || j == 0)
                    f2 = true;
                else {
                    if (i < matrix.length - 1 && matrix[i][j] > matrix[i + 1][j])
                        f1 = true;
                    if (j < matrix.length - 1 && matrix[i][j] > matrix[i][j + 1])
                        f1 = true;
                }
                if (f1 & f2) {
                    int tmp[] = {i, j};
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    public int findLUSlength(String[] strs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.put(strs[i].length(), map.getOrDefault(strs[i], 0) + 1);
        }
        if (null == strs)
            return -1;
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        for (int i = 0; i < strs.length; i++) {
            String tmp = strs[i];
            if (map.get(tmp.length()) == 1)
                return tmp.length();
        }
        return -1;
    }

    public int maxTurbulenceSize(int[] A) {
        if (A.length <= 1)
            return A.length;
        int max = 1;
        for (int i = 0; i < A.length; i++) {
            int tmp = 1;
            for (int j = i + 1; j < A.length; j++) {
                if (j % 2 == 0 && A[j] > A[j - 1]) {
                    tmp++;
                } else if (j % 2 == 1 && A[j] < A[j - 1]) {
                    tmp++;
                } else {
                    break;
                }
            }
            max = Math.max(max, tmp);
        }
        for (int i = 0; i < A.length; i++) {
            int tmp = 1;
            for (int j = i + 1; j < A.length; j++) {
                if (j % 2 == 0 && A[j] < A[j - 1]) {
                    tmp++;
                } else if (j % 2 == 1 && A[j] > A[j - 1]) {
                    tmp++;
                } else {
                    break;
                }
            }
            max = Math.max(max, tmp);
        }
        return max;
    }

    //猜数字
    public String getHint(String secret, String guess) {
        int tmp = 0;
        int bmp = 0;
        Map<Character, Integer> map = new HashMap<>();
        boolean flag[] = new boolean[guess.length()];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                tmp++;
                flag[i] = true;
            } else {
                map.put(guess.charAt(i), map.getOrDefault(guess.charAt(i), 0) + 1);
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (flag[i])
                continue;
            if (map.getOrDefault(secret.charAt(i), 0) > 0) {
                map.put(secret.charAt(i), map.get(secret.charAt(i)) - 1);
                bmp++;
            }
        }
        return tmp + "A" + bmp + "B";
    }

    public int maxSubarraySumCircular(int[] A) {
        int arr[] = new int[A.length * 2];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i];
            arr[i + A.length] = A[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int tmp = A[i];
            max = Math.max(max,tmp);
            for (int j = i + 1; j < i + A.length; j++) {
                tmp += arr[j];
                max = Math.max(max,tmp);
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
