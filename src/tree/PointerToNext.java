package tree;

import java.util.LinkedList;
import java.util.Queue;


public class PointerToNext {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    Node root;
    PointerToNext(int[] val){
        if(this.root==null){
            root = new Node(val[0]);
        }
        for(int i=1;i<val.length;i++){
            root.left = new Node(val[i]);
            root.right = new Node(val[i+1]);
        }
    }
    public Node connect(Node root) {
        Queue<Node> pq = new LinkedList<>();
        Queue<Node> cq = new LinkedList<>();
        pq.add(root);
        if(root==null){
            return null;
        }
        Node prev = root;
        Node ans = prev;
        
        while(!pq.isEmpty()){
            Node t = pq.poll();
            
            prev.next = t;
            prev = prev.next;
            
            if(t.left!=null){
                cq.add(t.left);
            }
            if(t.right!=null){
                cq.add(t.right);
            }
            if(pq.isEmpty()){
                pq = cq;
                cq = new LinkedList<>();
                prev.next = null;
                
            }
        }
        return ans;
    }
}
