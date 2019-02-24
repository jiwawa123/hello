package Oct27;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
    int count = 0;
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
        }
    }

}