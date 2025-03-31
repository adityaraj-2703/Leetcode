package tree;

public class LCABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);

        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode a = lowestCommonAncestor(root.left, p, q);
        TreeNode b = lowestCommonAncestor(root.right, p, q);
        if (a != null && b != null) {
            return root;
        }
        if (a != null) {
            return a;
        } else {
            return b;
        }

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        LCABinarySearchTree lca = new LCABinarySearchTree();
        TreeNode t = lca.new TreeNode(6, null, null);
        t.left = lca.new TreeNode(2, null, null);
        t.right = lca.new TreeNode(8, null, null);
        t.left.left = lca.new TreeNode(0, null, null);
        t.left.right = lca.new TreeNode(4, null, null);
        t.right.left = lca.new TreeNode(7, null, null);
        t.right.right = lca.new TreeNode(9, null, null);
        t.left.right.left = lca.new TreeNode(3, null, null);
        t.left.right.right = lca.new TreeNode(5, null, null);

        System.out.println(lca.lowestCommonAncestor(t, t.left, t.left.right).val);

    }

}
