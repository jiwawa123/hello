package Dec5;

import java.util.*;

public class Image {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int old = image[sr][sc];
        if (old == newColor)
            return image;
        image[sr][sc] = newColor;
        if (sr - 1 >= 0 && image[sr - 1][sc] == old)
            image = floodFill(image, sr - 1, sc, newColor);
        if (sc - 1 >= 0 && image[sr][sc - 1] == old)
            image = floodFill(image, sr, sc - 1, newColor);
        if (sr + 1 < image.length && image[sr + 1][sc] == old)
            image = floodFill(image, sr + 1, sc, newColor);
        if (sc + 1 < image[sr].length && image[sr][sc + 1] == old)
            image = floodFill(image, sr, sc + 1, newColor);
        return image;
    }

    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int res = 0;
                    if (i - 1 >= 0) {
                        if (grid[i - 1][j] == 0)
                            res++;
                    }
                    if (i + 1 < row) {
                        if (grid[i + 1][j] == 0)
                            res++;
                    }
                    if (j + 1 < col) {
                        if (grid[i][j + 1] == 0)
                            res++;
                    }
                    if (j - 1 >= 0) {
                        if (grid[i][j - 1] == 0)
                            res++;
                    }
                    count += 4 - res;
                }
            }
        }
        return count;
    }

    //求岛屿的最大面积
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (1 == grid[i][j])
                    max = Integer.max(max, DfsApply(grid, i, j));
            }
        }
        return max;
    }

    public int DfsApply(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + DfsApply(grid, i + 1, j) + DfsApply(grid, i - 1, j) + DfsApply(grid, i, j + 1) + DfsApply(grid, i, j - 1);
        } else return 0;
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    Dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int Dfs(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = 0;
            return 1 + Dfs(grid, i + 1, j) + Dfs(grid, i - 1, j) + Dfs(grid, i, j + 1) + Dfs(grid, i, j - 1);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("hello,ley,".split(",").length);
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        int arr[] = new int[N];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[K - 1] = 0;
        int index = 1;
        while (index < N) {
            int len = Integer.MAX_VALUE;
            int kk = 0;
            for (int i = 0; i < times.length; i++) {
                int a[] = times[i];
                if (arr[a[0] - 1] == Integer.MAX_VALUE)
                    continue;
                if (arr[a[0] - 1] != Integer.MAX_VALUE && arr[a[1] - 1] != Integer.MAX_VALUE)
                    continue;
                if (a[2] < len) {
                    len = a[2] + arr[a[0] - 1];
                    kk = a[1] - 1;
                }
            }
            if (len != Integer.MAX_VALUE) {
                index++;
                arr[kk] = len;
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = Math.max(count, arr[i]);
        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    //计算表面积
    public int surfaceArea(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0)
                    continue;
                int temp = (grid[i][j] - 1) * 4 + 6;
                if (i - 1 >= 0) {
                    temp -= Math.min(grid[i - 1][j], grid[i][j]);
                }
                if (i + 1 < row) {
                    temp -= Math.min(grid[i + 1][j], grid[i][j]);
                }
                if (j + 1 < col) {
                    temp -= Math.min(grid[i][j + 1], grid[i][j]);
                }
                if (j - 1 >= 0) {
                    temp -= Math.min(grid[i][j - 1], grid[i][j]);
                }
                count += temp;
            }
        }
        return count;
    }

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < paths.length; i++) {
            String str[] = paths[i].split(" ");
            for (int j = 1; j < str.length; j++) {
                String tmp = str[j];
                tmp = tmp.replaceAll(",", "(");
                tmp = tmp.replaceAll(",", ")");
                String s[] = tmp.split(",");
                if (map.containsKey(s[1])) {
                    List<String> ll = map.get(s[1]);
                    ll.add(str[0] + "/" + s[0]);
                    map.put(s[1], ll);
                } else {
                    List<String> ll = new ArrayList<>();
                    ll.add(str[0] + "/" + s[0]);
                    map.put(s[1], ll);
                }

            }
        }
        for (List<String> l : map.values()
                ) {
            res.add(l);
        }
        return res;
    }

    public String decodeString(String s) {
        s = s.replaceAll("\\[", " ");
        s = s.replaceAll("\\]", " ");
        String tmp = "";
        String str[] = s.split(" ");
        int temp = 1;
        for (String ss : str
                ) {
            if (isNumeric(ss)){
                temp = Integer.valueOf(ss);
            }else{
                while(temp>0){
                    tmp+=ss;
                    temp--;
                }
                temp = 1;
            }

        }
        return tmp;

    }

    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
