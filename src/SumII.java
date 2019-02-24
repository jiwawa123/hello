import java.util.ArrayList;
import java.util.List;

public class SumII {
    public static void main(String[] args) {

    }
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return res;
        list.add(root.val);
        if (root.left == null && root.right == null && sum == root.val)
            res.add(new ArrayList<>(list));
        pathSum(root.left, sum - root.val);
        pathSum(root.right, sum - root.val);
        list.remove(list.size() - 1);
        return res;
    }
}
