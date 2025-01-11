package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GTreeNode {
    int val;
    List<GTreeNode> children;
    public GTreeNode(){

    }
    public GTreeNode(int val){
        this.val = val;
        children = new ArrayList<>();
    }
    public static GTreeNode constructGTree (int[] arr){
        Stack<GTreeNode> st = new Stack<>();
        GTreeNode root = null;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                st.pop();
            }
            else{
                GTreeNode g = new GTreeNode(arr[i]);
                if(!st.isEmpty()){
                    st.peek().children.add(g);
                }
                else{
                    root = g;
                }
                st.push(g);
            }
        }
        return root;
        
    }
    public static void display(GTreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val + ":");
        for(GTreeNode child : root.children){
            System.out.print(child.val + ",");
        }
        System.out.print(".");
        System.out.println();
        for(GTreeNode child : root.children){
            display(child);
        }
    }
    public static int size(GTreeNode root){
        if(root==null){
            return 0;
        }
        
        int s = 0;
        for(GTreeNode child : root.children){
            s += size(child);
        }
        return s+1;
    }
    public static int maximum(GTreeNode root){
        if(root==null){
            return 0;
        }
        int max = root.val;
        for(GTreeNode child : root.children){
            max = Math.max(max,maximum(child));
        }
        return max;
    }
    public static int height(GTreeNode root){
        int height = 0;
        for(GTreeNode child : root.children){
            height = Math.max(height,height(child));
        }
        height += 1;
        return height;
    }
    public static void traversal(GTreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val + " ");
        for(GTreeNode child : root.children){
            traversal(child);
        }
        
        //System.out.println("node post" + root.val);

    }
    public static void iterativetraversal(GTreeNode root){
        Stack<GPair> st = new Stack<>();
        st.push(new GPair(root,-1));
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        while(!st.isEmpty()){
            GPair top = st.peek();
            if(top.state==-1){
                pre.add(top.node.val);
                top.state++;
            }
            else if(top.state == top.node.children.size()){
                post.add(top.node.val);
                st.pop();
            }
            else{
                GPair cp = new GPair(top.node.children.get(top.state),-1);
                st.push(cp);
                top.state++;
            }
        }
        System.out.println("pre");
        for(int p : pre){
            System.out.print(p + " ,");
        }
        System.out.println();
        System.out.println("post");
        for(int p : post){
            System.out.print(p + " ,");
        }
        System.out.println();

    }
    public static void levelorderTraversal(GTreeNode root){
        System.out.println("Level Order Traversal");
        Queue<GTreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            GTreeNode t = q.peek();
            for(int i=0;i<t.children.size();i++){
                q.offer(t.children.get(i));
            }
            System.out.print(q.poll().val + " ");
        }
    }
    public static void levelorderTraversallinewise(GTreeNode root){
        System.out.println("Level Order Traversal Linewise");
        Queue<GTreeNode> mq = new LinkedList<>();
        Queue<GTreeNode> cq = new LinkedList<>();
        mq.add(root);
        while(!mq.isEmpty()){
            GTreeNode t = mq.peek();
            for(int i=0;i<t.children.size();i++){
                cq.offer(t.children.get(i));
            }
            System.out.print(mq.poll().val + " ");
            if(mq.isEmpty()){
                System.out.println();
                mq = cq;
                cq = new LinkedList<>();
            }
        }
    }
    public static void levelorderTraversallinewisezigzag(GTreeNode root){

        //improve this
        System.out.println("Level Order Traversal ZigZag");
        Stack<GTreeNode> ms = new Stack<>();
        Stack<GTreeNode> cs = new Stack<>();
        ms.add(root);
        while(!ms.isEmpty()){
            GTreeNode t = ms.peek();
            for(int i=0;i<t.children.size();i++){
                cs.push(t.children.get(i));
            }
            System.out.print(ms.pop().val + " ");
            if(ms.isEmpty()){
                System.out.println();
                ms = cs;
                cs = new Stack<>();
            }
        }
    }
    

}
class GPair{
    GTreeNode node;
    int state;
    GPair(GTreeNode node,int state){
        this.node = node;
        this.state = state;
    }
}
