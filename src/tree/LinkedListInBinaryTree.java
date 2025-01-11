package tree;

import linkedelist.ListNode;

public class LinkedListInBinaryTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root.val == head.getVal()){
            check(head,root);
        }
        else{
            boolean c = isSubPath(head,root.left);
            boolean d = isSubPath(head,root.right);
            return c || d;
        }
        return false;
        
    }
    public boolean check(ListNode currLNode, TreeNode currTNode){
        if(currLNode == null){
            return true;
        }
        if(currTNode==null){
            return false;
        }
        else if(currLNode.getVal() == currTNode.getVal()){
            return check(currLNode.getNext(),currTNode.left) || check(currLNode.getNext(),currTNode.right);
        }
        else{
            return false;
        }
        
    }
}
