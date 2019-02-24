package Oct16;


import java.util.*;

public class LeetCode {
    class parir {
        int x;
        int y;

        public parir(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        parir temp = new parir(0, 0);
        int re = 0;

        Map<parir, Integer> map = new HashMap<>();
        for (int i = 0; i < obstacles.length; i++) {
            map.put(new parir(obstacles[i][0], obstacles[i][1]), 1);
        }
        for (int i = 0; i < commands.length; i++) {

        }
        return re;
    }

    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() * words[j].length() > max)
                    if (isUnion(words[i], words[j])) {
                        max = words[i].length() * words[j].length();
                    }
            }
        }
        return max;
    }

    public boolean isUnion(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (b.indexOf(a.charAt(i)) != -1)
                return false;
        }
        return true;
    }

    public int findCircleNum(int[][] M) {
        boolean flag[] = new boolean[M.length];
        Arrays.fill(flag, false);
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        queue.add(0);
        while (list.size() < M.length) {
            while (!queue.isEmpty()) {
                int temp = queue.remove();
                if (!flag[temp]) {
                    flag[temp] = true;
                    list.add(temp);
                    for (int i = 0; i < M[temp].length; i++) {
                        if (i != temp && M[temp][i] == 1)
                            queue.add(i);
                    }
                }
            }
            if (list.size() == M.length)
                break;
            else {
                count++;
                for (int i = 0; i < flag.length; i++) {
                    if (!flag[i]) {
                        queue.add(i);
                        break;
                    }

                }
            }

        }
        return count;
    }

    public String reverseStr(String s, int k) {
        StringBuffer sb = new StringBuffer("");
        while (s.length() > 2 * k) {
            String temp = s.substring(0, 2 * k);
            sb.append(new StringBuffer(temp.substring(0, k)).reverse() + temp.substring(k, 2 * k));
            s = s.substring(2 * k, s.length());
        }
        if (s.length() < k) {
            sb.append(new StringBuffer(s).reverse());
        } else {
            sb.append(new StringBuffer(s.substring(0, k)).reverse() + s.substring(k, s.length()));
        }
        return sb.toString();
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!t.isEmpty()) {
                    t.pop();
                }
            } else {
                s.push(T.charAt(i));
            }
        }
        while (!s.isEmpty() && !t.isEmpty()) {
            if (s.pop() != t.pop())
                return false;
        }
        return s.isEmpty() && t.isEmpty();
    }

    public int maxCount(int m, int n, int[][] ops) {
       int h = Integer.MAX_VALUE;
       int v = Integer.MAX_VALUE;
        for (int i = 0; i < ops.length; i++) {
            h = Math.min(h,ops[i][0]);
            v = Math.min(h,ops[i][1]);
        }
        return h*v*ops.length;
    }
    public boolean isAnagram(String s, String t) {
        if(s==null&&t==null||(s.equals(t))){
            return true;
        }
        if(s.length()!=t.length())
            return false;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i <t.length() ; i++) {
            if(!map.containsKey(t.charAt(i))||map.get(t.charAt(i))==0)
                return false;
            map.put(t.charAt(i),map.get(t.charAt(i))-1);
        }
        return true;
    }
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new TreeSet();
        for(int i = 0; i < words.length;i++){
            String temp = "";
            for(int j = 0;j<words[i].length();j++){
                temp+=arr[words[i].charAt(j) - 'a'];
            }
            System.out.println(temp);
            set.add(temp);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String arr[] = {"rwjje","aittjje","auyyn","lqtktn","lmjwn"};
        System.out.println(new LeetCode().uniqueMorseRepresentations(arr));
    }
}
