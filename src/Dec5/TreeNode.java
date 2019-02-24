package Dec5;

import jdk.nashorn.api.tree.Tree;

import java.sql.SQLOutput;
import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 1) {
            TreeNode root = new TreeNode(nums[0]);
            return root;
        }
        //开始查找最大的元素
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        if (index > 0) {
            int arr[] = new int[index];
            for (int i = 0; i < index; i++) {
                arr[i] = nums[i];
            }
            root.left = constructMaximumBinaryTree(arr);
        }
        if (index < nums.length - 1) {
            int arr[] = new int[nums.length - index];
            for (int i = 0; i < nums.length - index; i++) {
                arr[i] = nums[index + i + 1];
            }
            root.right = constructMaximumBinaryTree(arr);
        }
        return root;
    }

    public static void main(String[] args) {

        int inorder[] = {9,3,15,20,7};
        int postorder[] = {9,15,7,20,3};
        TreeNode root = new TreeNode(1);
        root.buildTree(inorder,postorder);
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            List<TreeNode> l = new ArrayList<>();
            Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
            boolean flag = false;
            while (!queue.isEmpty()) {
                TreeNode temp = queue.remove();
                l.add(temp);
                if (temp != null) {
                    flag = true;
                    if (temp.left != null) {
                        queue1.add(temp.left);
                    } else {
                        queue1.add(null);
                    }
                    if (temp.right != null) {
                        queue1.add(null);
                    } else {
                        queue1.add(null);
                    }
                } else {
                    queue1.add(null);
                    queue1.add(null);
                }

            }
            queue = queue1;
            if (!flag)
                break;
            int left = 0, right = l.size() - 1;
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i) != null) {
                    left = i;
                    break;
                }
            }
            for (int i = l.size() - 1; i >= 0; i--) {
                if (l.get(i) != null) {
                    right = i;
                    break;
                }
            }
            count = Math.max(count, right - left + 1);


        }
        return count;
    }

    //判断是不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
            List<TreeNode> ll = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.remove();
                if (temp.left == null && temp.right != null)
                    return false;
                if (temp.left != null) {
                    queue1.add(temp.left);
                    ll.add(temp.left);
                } else {
                    ll.add(null);
                }
                if (temp.right != null) {
                    queue1.add(temp.right);
                    ll.add(temp.left);
                } else {
                    ll.add(null);
                }

            }
            for (int i = 0; i < ll.size(); i++) {
                if (i == 0 && ll.get(i) == null)
                    break;
                if (ll.get(i) == null && i != ll.size() - 1)
                    return false;
            }
            queue = queue1;
        }
        return true;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length)
            return false;
        Stack<Integer> statck = new Stack<>();
        int i = 0, j = 0;
        while (i < pushed.length && j < popped.length) {
            if (pushed[i] != popped[j]) {
                statck.push(pushed[i]);
                i++;
            } else {
                j++;
                while (statck.peek() == popped[j]) {
                    statck.pop();
                }
            }
        }
        return statck.isEmpty();
    }

    List<String> list;

    public String smallestFromLeaf(TreeNode root) {
        if (root == null)
            return "";
        list = new ArrayList<>();
        deal_help("", root);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return isPan(o1, o2);
            }
        });
        return list.get(0);
    }

    public int isPan(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) < b.charAt(j)) {
                return -1;
            }
            if (a.charAt(i) > b.charAt(j)) {
                return 1;
            }
            i++;
            j++;
        }
        return a.length()-b.length();
    }

    public void deal_help(String str, TreeNode root) {
        if (root == null) {
            list.add(new StringBuffer(str).reverse().toString());
        } else {
            char temp = (char) ('a' + root.val);
            if (root.left != null)
                deal_help(str + temp, root.left);
            if (root.right != null)
                deal_help(str + temp, root.right);
            if (root.left == null && root.right == null)
                list.add(new StringBuffer(str + temp).reverse().toString());

        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(null==inorder||0==inorder.length)
            return null;
        if(inorder.length==1)
            return new TreeNode(inorder[0]);
        int len = postorder.length;
        TreeNode root = new TreeNode(postorder[len-1]);
        int index = 0;
        //开始寻找root左边的节点
        for(int i = 0;i<len;i++){
            if(inorder[i]==postorder[len-1]){
                //定位到root的位置
                index = i;
                break;
            }
        }
        int inLeft[] = Arrays.copyOfRange(inorder,0,index);
        int inRight[] = Arrays.copyOfRange(inorder,index+1,len);
        int postLeft[] = Arrays.copyOfRange(postorder,0,inLeft.length);
        int postRight[] = Arrays.copyOfRange(postorder,inLeft.length,postorder.length-1);
        root.left = buildTree(inLeft,postLeft);
        root.right = buildTree(inRight,postRight);
        return root;
    }
}
