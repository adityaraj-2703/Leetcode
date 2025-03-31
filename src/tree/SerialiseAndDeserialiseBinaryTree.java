package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SerialiseAndDeserialiseBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || curr != null) {
            if (curr != null) {
                sb.append(curr.val);
                sb.append('%');
                st.push(curr);
                curr = curr.left;
            } else {
                sb.append("null%");
                TreeNode temp = st.pop();
                curr = temp.right;
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] d = data.split("%");
        // return deserializeUtil(d);
        Stack<Pair> st = new Stack<>();
        TreeNode t = new TreeNode(Integer.parseInt(d[0]));
        st.push(new Pair(t, 0));
        int ind = 1;
        while (!st.isEmpty() && ind < d.length) {

            Pair p = st.peek();
            if (p.state == 0) {
                if (!d[ind].equals("null")) {
                    p.t.left = new TreeNode(Integer.parseInt(d[ind]));
                    st.push(new Pair(p.t.left, 0));
                }
                p.state++;
                ind++;
            } else if (p.state == 1) {
                if (!d[ind].equals("null")) {
                    p.t.right = new TreeNode(Integer.parseInt(d[ind]));
                    st.push(new Pair(p.t.right, 0));
                }
                p.state++;
                ind++;
            } else {
                st.pop();

            }

        }
        return t;
    }

    public TreeNode deserializeByRecursion(String data) {
        String[] d = data.split("%");
        return deserializeUtil(d, 0);
    }

    public TreeNode deserializeUtil(String[] d, int ind) {
        if (ind > d.length) {
            return null;
        }
        if (d[ind].equals("null")) {
            return null;
        }
        TreeNode t = new TreeNode(Integer.parseInt(d[ind]));
        t.left = deserializeUtil(d, ind + 1);
        t.right = deserializeUtil(d, ind + 2);
        List<Integer> li = new ArrayList<>();

        return t;

    }

    class Pair {
        TreeNode t;
        int state;

        Pair(TreeNode t, int state) {
            this.t = t;
            this.state = state;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
        SerialiseAndDeserialiseBinaryTree s = new SerialiseAndDeserialiseBinaryTree();
        TreeNode t = s.new TreeNode(1);
        t.left = s.new TreeNode(2);
        t.right = s.new TreeNode(3);
        t.right.left = s.new TreeNode(4);
        t.right.right = s.new TreeNode(5);
        String s1 = s.serialize(t);
        System.out.println(s.deserializeByRecursion(s1));
    }

}
