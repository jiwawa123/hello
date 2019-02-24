package Dec1;

import java.util.*;

public class Dp {
    public static void main(String[] args) {
        int arr[][] = {{1,2},{1,3}};
        System.out.println(new Dp().kthSmallest(arr,1));
    }

    public int findRadius(int[] houses, int[] heaters) {
        int array[] = new int[houses.length];
        Arrays.fill(array, Integer.MAX_VALUE);
        Arrays.sort(heaters);
        int re = 0;
        for (int i = 0; i < houses.length; i++) {
            int start = 0, end = heaters.length;
            while (start <= end) {
                int med = (start + end) / 2;
                if (heaters[med] == houses[i]) {
                    array[i] = 0;
                    break;
                } else if (heaters[med] < houses[i])
                    start = med + 1;
                else
                    end = med - 1;
            }
            System.out.println(array[i]);
            System.out.println(start);
            if (array[i] != 0) {
                if (start == heaters.length)
                    array[i] = Math.abs(houses[i] - heaters[start - 1]);
                else if (start != 0)
                    array[i] = Math.min(Math.abs(houses[i] - heaters[start]), Math.abs(houses[i] - heaters[start - 1]));
                else
                    array[i] = Math.abs(houses[i] - heaters[start]);

            }

            re = Math.max(array[i], re);
        }
        return re;
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0));
        }
        // 升序比较器
        Comparator<Map.Entry<Character, Integer>> valueComparator = new Comparator<Map.Entry<Character, Integer>>() {

            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                // TODO Auto-generated method stub
                return o2.getValue() - o1.getValue();
            }
        };
        // map转换成list进行排序
        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());

        // 排序
        Collections.sort(list, valueComparator);

        String re = "";
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                re += entry.getKey() + "";
            }
        }

        return re;

    }

    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            HashMap<Character, Integer> map = new HashMap();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.')
                    continue;
                if (map.containsKey(board[i][j]))
                    return false;
                else
                    map.put(board[i][j], 1);
            }
        }
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < m; j++) {
                if (board[j][i] == '.')
                    continue;
                if (map.containsKey(board[j][i]))
                    return false;
                else
                    map.put(board[j][i], 1);

            }
        }
        for (int i = 0; i < m; i+=3) {
            int k = 0;
            while(k<9){
                HashMap<Character, Integer> map = new HashMap<>();
                for (int j = i; j < i+3; j++) {
                    for (int l = k; l < k+3; l++) {
                        if(board[j][l]=='.')
                            continue;
                        if(map.containsKey(board[j][l]))
                            return false;
                        map.put(board[j][l], 1);
                    }
                }
                k+=3;
            }
        }
        return true;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int arr[] = new int[matrix.length*matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                arr[i*matrix[0].length+j] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
}
