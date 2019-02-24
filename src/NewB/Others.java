package NewB;

import java.util.*;

public class Others {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int pos = 0;
        int chunk = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == i && i > pos) {
                chunk++;
            } else {
                pos = Math.max(arr[i], pos);
                if (pos > i) {
                    continue;
                } else if (pos == i) {
                    chunk++;
                }
            }
        }
        return chunk;
    }

    public List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        S = S.substring(1, S.length() - 1);
        for (int i = 1; i < S.length(); i++) {
            List<String> res1 = helper(S.substring(0, i));
            List<String> res2 = helper(S.substring(i));
            if (res1.size() == 0 || res2.size() == 0) continue;
            for (String s1 : res1) {
                for (String s2 : res2) {
                    res.add("(" + s1 + ", " + s2 + ")");
                }
            }
        }
        return res;
    }

    private List<String> helper(String S) {
        List<String> res = new ArrayList();
        if (S.length() == 0) return res;
        if (S.length() == 1 || (S.charAt(0) != '0' && S.charAt(S.length() - 1) == '0')) {
            res.add(S);
            return res;
        }
        if (S.charAt(0) == '0' && S.charAt(S.length() - 1) == '0') return res;
        if (S.charAt(0) == '0') {
            res.add(S.substring(0, 1) + "." + S.substring(1, S.length()));
            return res;
        }
        //使用深度搜索
        for (int i = 0; i < S.length() - 1; i++) {
            res.add(S.substring(0, i + 1) + "." + S.substring(i + 1, S.length()));
        }
        res.add(S);
        return res;
    }

    public int shortestSubarray(int[] A, int K) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int tmp = A[i];
            if (tmp >= K)
                return 1;
            for (int j = i + 1; j < A.length; j++) {
                tmp += A[j];
                if (tmp > K) {
                    res = Math.min(res, j - i + 1);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        String res = "";
        int i = 0;
        for (int j = 0; j < indexes.length; j++) {
            if (indexes[j] <= S.length() && i < indexes[j] && i <= S.length()) {
                res += S.substring(i, indexes[j]);
                i = indexes[j];
            }

            if (indexes[j] + sources[j].length() <= S.length() && sources[j].equals(S.substring(indexes[j], indexes[j] + sources[j].length()))) {
                res += targets[j];
                i = indexes[j] + sources[j].length();
            }
        }
        res += S.substring(i, S.length());
        return res;
    }

    public static void main(String[] args) {
        int res[][] = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopes(res));
    }

    public static String validIPAddress(String IP) {
        String res = "Neither";
        if (null == IP || IP.equals("") || IP.charAt(IP.length() - 1) == ':' || IP.charAt(IP.length() - 1) == '.')
            return res;
        //判断是不是ipv4
        if (IP.contains(".")) {
            String ipv4[] = IP.split("\\.");
            if (ipv4.length != 4)
                return res;
            for (int i = 0; i < ipv4.length; i++) {
                String tmp = ipv4[i];
                if (null == tmp || tmp.equals("") || tmp.length() > 3)
                    return res;
                for (int j = 0; j < tmp.length(); j++) {
                    if (!Character.isDigit(tmp.charAt(j))) {
                        return res;
                    }
                }
                if (Integer.valueOf(ipv4[i]) > 255)
                    return res;
                if (Integer.valueOf(ipv4[i]) != 0 && tmp.charAt(0) == '0')
                    return res;
            }
            return "ipv4";
        }
        //判断是不是ipv6
        if (IP.contains(":")) {
            String ipv6[] = IP.split(":");
            if (ipv6.length != 8)
                return res;
            for (int i = 0; i < ipv6.length; i++) {
                String tmp = ipv6[i];
                tmp = tmp.toLowerCase();
                if (null == tmp || tmp.equals(""))
                    return res;
                boolean flag = false;
                for (int j = 0; j < tmp.length(); j++) {
                    if (!Character.isDigit(tmp.charAt(j))) {
                        if (tmp.charAt(j) < 'a' || tmp.charAt(j) > 'z')
                            return res;
                        else
                            flag = true;

                    }
                }
                if (!flag) {
                    if (Integer.valueOf(tmp) == 0 && tmp.length() > 1) {
                        return res;
                    }
//                    if(Integer.valueOf(tmp)!=0&&tmp.charAt(0)=='0')
//                        return res;
                }

            }
            return "ipv6";
        }
        return res;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        //此问题为0-1背包问题，需要建立二维数组，判断能装下多少东西即可
        int res[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            res[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            res[0][i] = 0;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

            }
        }
        return res[m][n];
    }

    //俄罗斯套娃
    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null||envelopes.length==0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]!=b[0]){
                    return a[0]-b[0];
                }else{
                    return a[1]-b[1];
                }
            }
        });
        int max=1;
        int[] arr = new int[envelopes.length];
        for(int i=0; i<envelopes.length; i++){
            arr[i]=1;
            for(int j=i-1; j>=0; j--){
                if(envelopes[i][0]>envelopes[j][0]&&envelopes[i][1]>envelopes[j][1]){
                    arr[i]=Math.max(arr[i], arr[j]+1);
                }
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
