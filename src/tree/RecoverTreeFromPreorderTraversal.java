package tree;

public class RecoverTreeFromPreorderTraversal {
    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal.length() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(traversal.charAt(0) - '0');
        int ind = 1;
        while (ind < traversal.length()) {
            int height = 0;
            while (ind < traversal.length() && traversal.charAt(ind) == '-') {
                height++;
                ind++;
            }
            TreeNode temp = findleftMostNull(height, root, null);
            if (temp.left == null) {
                temp.left = new TreeNode(traversal.charAt(ind) - '0');
                ind++;
            } else {
                temp.right = new TreeNode(traversal.charAt(ind) - '0');
                ind++;
            }
        }
        return root;

    }

    public TreeNode findleftMostNull(int height, TreeNode root, TreeNode prev) {
        if (root == null) {
            return null;
        }
        if (height == 1) {
            if (root.left != null && root.right != null) {
                return null;
            } else {
                return root;
            }
        }
        TreeNode l = findleftMostNull(height - 1, root.left, root);
        TreeNode r = findleftMostNull(height - 1, root.right, root);
        if (l != null && l.left == null) {
            return l;
        } else {
            return r;
        }

    }

    public static void main(String[] args) {
        String traversal = "1-2--3---4-5--6---7";
        RecoverTreeFromPreorderTraversal t = new RecoverTreeFromPreorderTraversal();
        System.out.println(t.recoverFromPreorder(traversal));
    }

}
