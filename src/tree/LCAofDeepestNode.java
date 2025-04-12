package tree;

import java.util.HashMap;
import java.util.Map;

public class LCAofDeepestNode {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, Integer> hm = new HashMap<>();
        lcaDeepestLeavesUtil(root, hm, 0);
        int max = 0;
        TreeNode ans = root;
        for (Map.Entry<TreeNode, Integer> m : hm.entrySet()) {
            TreeNode temp = m.getKey();
            if (temp.left == null || temp.right == null) {
                continue;
            }
            if (max < m.getValue()) {
                max = m.getValue();
                ans = temp;
            }
        }
        return ans;

    }

    public void lcaDeepestLeavesUtil(TreeNode root, Map<TreeNode, Integer> hm, int height) {
        if (root == null) {
            return;
        }
        hm.put(root, height);
        lcaDeepestLeavesUtil(root.left, hm, height + 1);
        lcaDeepestLeavesUtil(root.right, hm, height + 1);

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public static void main(String[] args) {
        LCAofDeepestNode l = new LCAofDeepestNode();
        TreeNode root = l.new TreeNode(0);
        root.left = l.new TreeNode(1);
        root.right = l.new TreeNode(3);
        root.left.right = l.new TreeNode(2);
        System.out.println(l.lcaDeepestLeaves(root).val);
    }

}
