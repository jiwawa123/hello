package TreeNode;

import jdk.nashorn.api.tree.Tree;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Pattern;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        proVisit(root);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            //升序排序
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        List<Integer> l = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> mapping : list) {
            if (mapping.getValue() > max) {
                max = mapping.getValue();
                l.add(mapping.getKey());
            } else {
                break;
            }
        }
        int re[] = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            re[i] = l.get(i);
        }
        return re;
    }

    public void proVisit(TreeNode root) {
        if (root != null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            proVisit(root.left);
            proVisit(root.right);
        }
    }

    public void inVisit(TreeNode root) {
        if (root != null) {
            proVisit(root.left);
            System.out.println(root.val);
            proVisit(root.right);
        }
    }

    public void levelTr(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            System.out.println(temp.val + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> re = new ArrayList();
        if (root == null)
            return re;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.remove();
                l.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            queue = queue1;
            re.add(l);
        }
        return re;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> re = new ArrayList<>();
        if (root == null)
            return re;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double count = 0.0;
            int index = 0;
            Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.remove();
                count += temp.val;
                index++;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            queue = queue1;
            re.add(count / index);
        }
        return re;
    }

    List<TreeNode> list = new ArrayList();

    public int[] findFrequentTreeSum(TreeNode root) {

        Map<Integer, Integer> map = new HashMap<>();
        preOredr(root);
        for (TreeNode temp : list
                ) {
            map.put(findAll(temp, 0), map.getOrDefault(findAll(temp, 0), 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> l = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(l, new Comparator<Map.Entry<Integer, Integer>>() {
            //升序排序
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }

        });
        List<Integer> re = new ArrayList<>();
        int index = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> mm : l
                ) {
            if (mm.getValue() >= index) {
                re.add(mm.getKey());
                index = mm.getValue();
            } else {
                break;
            }
        }
        int arr[] = new int[re.size()];
        int i = 0;
        for (int k : re
                ) {
            arr[i++] = k;
        }
        return arr;
    }

    public void preOredr(TreeNode root) {
        if (root == null)
            return;
        list.add(root);
        preOredr(root.left);
        preOredr(root.right);
    }

    public int findAll(TreeNode root, int val) {
        if (root == null)
            return val;
        if (root != null && root.left == null && root.right == null) {
            return val + root.val;
        } else {
            return val + root.val + findAll(root.left, 0) + findAll(root.right, 0);
        }
    }


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            root = new TreeNode(val);
            return root;
        }
        find(root, val);
        return root;
    }

    public void find(TreeNode root, int val) {
        if (root != null) {
            if (root.val == val)
                return;
            if (root.val < val) {
                if (null == root.right) {
                    TreeNode right = new TreeNode(val);
                    root.right = right;
                    return;
                } else {
                    find(root.right, val);
                }
            } else {
                if (null == root.left) {
                    TreeNode left = new TreeNode(val);
                    root.left = left;
                    return;
                } else {
                    find(root.left, val);
                }
            }
        }
    }

    public int calPoints(String[] ops) {
        int count = 0;
        boolean flag[] = new boolean[ops.length];
        Arrays.fill(flag, false);
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "C":
                    int j1 = i;
                    while (j1 >= 0) {
                        if (flag[j1]) {
                            flag[j1] = false;
                            count -= Integer.valueOf(ops[j1]);
                            break;
                        }
                        j1--;
                    }

                    break;
                case "+":
                    int index = 0, j = i;
                    int temp = 0;
                    while (index < 2 && j >= 0) {
                        if (flag[j]) {
                            temp += Integer.valueOf(ops[j]);
                            index++;
                        }
                        j--;
                    }
                    ops[i] = temp + "";
                    count += Integer.valueOf(ops[i]);
                    flag[i] = true;
                    break;
                case "D":
                    int jj = i;
                    int tem = 0;
                    while (jj >= 0) {
                        if (flag[jj]) {
                            tem += 2 * Integer.valueOf(ops[jj]);
                            break;
                        }
                        jj--;
                    }
                    ops[i] = tem + "";
                    count += Integer.valueOf(ops[i]);
                    flag[i] = true;
                    break;
                default:
                    flag[i] = true;
                    count += Integer.valueOf(ops[i]);
                    break;
            }
        }
        return count;
    }


    public String tree2str(TreeNode t) {
        String re = "";
        if (null == t)
            return re;
        if (t.left == null && t.right == null)
            return re + t.val;
        if (t.left == null && t.right != null) {
            return re + t.val + "(()(" + tree2str(t.right) + ")";
        }
        if (t.left != null && t.right == null) {
            return re + t.val + "(" + tree2str(t.left) + ")";
        }

        return re + t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";

    }

    //山羊数据
    public String toGoatLatin(String S) {
        char yy[] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Map<Character, Integer> map = new HashMap<>();
        for (char a : yy
                ) {
            map.put(a, 1);
        }
        String str[] = S.trim().split(" ");
        String re = "";
        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])) {
                str[i] += "ma";
            } else {
                str[i] = str[i].substring(1, str[i].length()) + str[i].substring(0, 1);
            }
            int j = -1;
            while (j < i) {
                str[i] += "a";
                j++;
            }
            re += str[i];
            if (i != str.length - 1) {
                re += " ";
            }
        }
        return re;
    }

    List<Integer> l = new ArrayList<>();

    //数字叠加
    public TreeNode convertBST(TreeNode root) {
        preOredr(root);
        add(root);
        return root;
    }

    public void add(TreeNode root) {
        if (root == null)
            return;
        int temp = 0;
        for (int k : l
                ) {
            if (k > root.val)
                temp += k;
        }
        root.val = temp;
        add(root.left);
        add(root.right);
    }

    public void preOredrI(TreeNode root) {
        if (root == null)
            return;
        l.add(root.val);
        preOredr(root.left);
        preOredr(root.right);
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int re = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            re = Math.max(nums[i] - nums[i - 1], re);
        }
        return re;
    }

    public String[] reorderLogFiles(String[] logs) {
        List<String> numList = new ArrayList<>();
        List<String> letterList = new ArrayList<>();
        for (String s : logs) {
            int index = s.indexOf(" ");
            char c = s.charAt(index + 1);
            if (c >= '0' && c <= '9')
                numList.add(s);
            else
                letterList.add(s);
        }

        Collections.sort(letterList, (o1, o2) -> {
            int indexo1 = o1.indexOf(" ");
            int indexo2 = o2.indexOf(" ");
            String substro1 = o1.substring(indexo1 + 1);
            String substro2 = o2.substring(indexo2 + 1);
            return substro1.compareTo(substro2);
        });
        String[] sortedLogs = new String[logs.length];
        int i = 0;
        for (String s : letterList) {
            sortedLogs[i++] = s;
        }

        for (String s : numList) {
            sortedLogs[i++] = s;
        }
        return sortedLogs;
    }

    int re = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        longestUnivaluePathI(root);
        return re;
    }

    public void longestUnivaluePathI(TreeNode root) {
        if (root == null)
            return;
        int t = 1 + path(root.left, root.val) + path(root.right, root.val);
        re = Math.max(re, t);
    }

    public int path(TreeNode root, int t) {
        if (null == root)
            return 0;
        if (root.val != t) {
            longestUnivaluePathI(root);
            return 0;
        } else
            return 1 + Math.max(path(root.left, t), path(root.right, t));
    }

    //移除所有不含1的节点
    public TreeNode pruneTree(TreeNode root) {
        pruneTreeCore(root);
        return root;
    }


    public TreeNode pruneTreeCore(TreeNode root) {
        if (root == null)
            return null;

        if (root.left != null)
            root.left = pruneTreeCore(root.left);
        if (root.right != null)
            root.right = pruneTreeCore(root.right);

        if (root.left == null && root.right == null && root.val == 0)
            root = null;

        return root;
    }


    public static void main(String[] args) {
        String str = "aaaa";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                System.out.println(map.getOrDefault(map.get(str.charAt(i)), 0));
                map.put(str.charAt(i), map.getOrDefault(map.get(str.charAt(i)), 0) + 1);
                System.out.println(map.get(str.charAt(i)));
            } else {
                map.put(str.charAt(i), 1);
            }
        }

    }

    public int numSpecialEquivGroups(String[] A) {
        if (null == A || A.length == 0)
            return 0;
        List<String> l = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (l.isEmpty()) {
                l.add(A[i]);
                continue;
            } else {
                boolean flag = false;
                for (int j = 0; j < l.size(); j++) {
                    if (isChange(l.get(j), A[i])) {
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    l.add(A[i]);
            }
        }
        return l.size();
    }

    public boolean isChange(String a, String b) {
        if (a.length() != b.length())
            return false;
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (i % 2 == 0)
                m1.put(a.charAt(i), m1.getOrDefault(a.charAt(i), 0) + 1);
            else
                m2.put(a.charAt(i), m2.getOrDefault(a.charAt(i), 0) + 1);
        }
        for (int i = 0; i < b.length(); i++) {
            if (i % 2 == 0) {
                if (!m1.containsKey(b.charAt(i)) || m1.get(b.charAt(i)) == 0)
                    return false;
                else
                    m1.put(b.charAt(i), m1.get(b.charAt(i)) - 1);
            } else {
                if (!m2.containsKey(b.charAt(i)) || m2.get(b.charAt(i)) == 0)
                    return false;
                else
                    m2.put(b.charAt(i), m2.get(b.charAt(i)) - 1);
            }
        }
        return true;
    }

    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        while (L <= R) {
            int t = 0;
            int n = L;
            while (n > 0) {
                if (n % 2 == 1) {
                    t++;
                }
                n /= 2;
            }
            if (isPrime(t))
                count++;
        }
        return count;
    }

    public boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 6 != 1 && n % 6 != 5)
            return false;
        for (int i = 5; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j <points.length ; j++) {
                if(i==j)
                    continue;
                for (int k = 0; k < points.length; k++) {
                    if(j==k||k==i)
                        continue;
                    int a = (points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                    int b = (points[i][0]-points[k][0])*(points[i][0]-points[k][0])+(points[i][1]-points[k][1])*(points[i][1]-points[k][1]);
                    if(a==b)
                        count++;
                }
            }
        }
        return count;
    }
    //最大二叉树II
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        //判断三种情况，
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val<val){
            TreeNode ro = new TreeNode(val);
            ro.left = ro;
            return ro;
        }
        if(root.left!=null){
            root.left = insertIntoMaxTree(root.left, val);
        }else{
            root.right = insertIntoMaxTree(root.right, val);
        }
        return root;

    }
}
