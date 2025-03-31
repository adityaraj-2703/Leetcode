package tree;

public class ConstructFromPreorderPostOrder {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePostUtil(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode constructFromPrePostUtil(int[] preorder, int[] postorder, int prsi, int prei, int posi, int poei) {
        if (prsi > prei) {
            return null;
        }
        TreeNode t = new TreeNode(preorder[prsi]);
        int ind = poei - 1;
        while (ind >= 0 && postorder[ind] != preorder[prsi + 1]) {
            ind--;
        }
        int tne = ind + 1;
        t.left = constructFromPrePostUtil(preorder, postorder, prsi + 1, prsi + ind, 0, ind);
        t.right = constructFromPrePostUtil(preorder, postorder, prsi + ind + 1, prei, ind + 1, poei - 1);
        return t;
    }

    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
        int[] postorder = { 4, 5, 2, 6, 7, 3, 1 };
        ConstructFromPreorderPostOrder c = new ConstructFromPreorderPostOrder();
        System.out.println(c.constructFromPrePost(preorder, postorder));

    }

    public class TreeNode {
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

}
