package tree;

import java.util.Stack;

public class BTree {
    int val;
    BTree left;
    BTree right;
    BTree() {}
    BTree(int val) { this.val = val; }
    BTree(int val, BTree left, BTree right) {
        this.val = val;
        this.left = left;
    }
    public static BTree constructBTree(Integer[] arr){
        BTree root = new BTree(arr[0],null,null);
        Pair p = new Pair(root,1);
        Stack<Pair> st = new Stack<>();
        st.push(p);
        int idx = 0;
        while(!st.isEmpty()){
            Pair top = st.peek();
            if(top.state==1){
                idx++;
                if(arr[idx]!=null){
                    BTree ln = new BTree(arr[idx],null,null);
                    top.node.left = ln;
                    st.push(new Pair(ln,1));
                }
                else{
                    top.node.left = null;
                }
                top.state++;
            }
            else if(top.state==2){
                idx++;
                if(arr[idx]!=null){
                    BTree rn = new BTree(arr[idx],null,null);
                    top.node.right = rn;
                    st.push(new Pair(rn,1));
                }
                else{
                    top.node.right = null;
                }
                top.state++;
            }
            else{
                st.pop();
            }
        }
        return root;
    }
    public static void traverseIterative(BTree root){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        StringBuilder pre = new StringBuilder();
        StringBuilder post = new StringBuilder();
        StringBuilder in = new StringBuilder();
        while(!st.isEmpty()){
            Pair p = st.peek();
            if(p.state==1){
                pre.append(p.node.val + " ");
                p.state++;
                if(p.node.left!=null){
                    st.push(new Pair(p.node.left,1));
                }
                if(p.node.right!=null){
                    st.push(new Pair(p.node.right,1));
                }
            }

            else if(p.state==2){
                in.append(p.node.val + " ");
                p.state++;
            }
            else{
                post.append(p.node.val + " ");
                st.pop();
            }
        }
        System.out.println(pre);
        System.out.println(post);
        System.out.println(in);
    }
    public static int size(BTree root){
        if(root==null){
            return 0;
        }
        int ls = size(root.left);
        int rs = size(root.right);
        int ts = ls+rs+1;
        return ts;
    }
    public static int sum(BTree root){
        if(root==null){
            return 0;
        }
        int ls = sum(root.left);
        int rs = sum(root.right);
        int ts = ls+rs+root.val;
        return ts;
    }
    public static int maximum(BTree root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int max1 = maximum(root.left);
        int max2 = maximum(root.right);
        return Math.max(max1,Math.max(root.val,max2));
    }
    public static int height(BTree root){
        if(root==null){
            return 0;
        }
        int max1 = height(root.left);
        int max2 = height(root.right);
        return Math.max(max1,max2) + 1;
    }
    public static int diameter(BTree root){
        if(root==null){
            return 0;
        }
        int ld = diameter(root.left); // maximum distance between two nodes of lhs
        int rd = diameter(root.right); // maximum distance between two nodes of rhs
        //maximum distance between left deepest and right deepest
        int f = height(root.left) + height(root.right) + 2;

        return Math.max(f,Math.max(ld,rd));


    }
    public static DiaPair diameter2(BTree root){
        if(root==null){
            return null;
        }
        DiaPair lp = diameter2(root.left); // maximum distance between two nodes of lhs
        DiaPair rp = diameter2(root.right); // maximum distance between two nodes of rhs
        //maximum distance between left deepest and right deepest
        DiaPair mp = new DiaPair();
        mp.ht = Math.max(lp.ht,rp.ht)+1;

        int fes = lp.ht + rp.ht + 2;
        mp.dia = Math.max(fes,Math.max(lp.dia,rp.dia));
        return mp;


    }
    
}
class DiaPair{
    int ht;
    int dia;
}
class Pair{
    BTree node;
    int state;
    Pair(BTree node,int state){
        this.node = node;
        this.state = state;
    }
}

