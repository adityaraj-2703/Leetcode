package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        return al;
    }

    public void pathSumUtil(TreeNode root, int targetSum, List<List<Integer>> al, List<Integer> temp) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                temp.add(root.val);
                al.add(new ArrayList<>(temp));
            }
        }
        temp.add(root.val);
        pathSumUtil(root.left, targetSum - root.val, al, temp);
        pathSumUtil(root.right, targetSum - root.val, al, temp);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        t = new TreeNode(5);
        t.left = new TreeNode(4);
        t.right = new TreeNode(8);
        t.left.left = new TreeNode(11);
        t.left.left.left = new TreeNode(7);
        t.left.left.right = new TreeNode(2);
        t.right = new TreeNode(8);
        t.right.left = new TreeNode(13);
        t.right.right = new TreeNode(4);
        t.right.right.left = new TreeNode(5);
        t.right.right.right = new TreeNode(1);
        PathSum2 p = new PathSum2();
        System.out.println(p.pathSum(t, 0));

    }

}
