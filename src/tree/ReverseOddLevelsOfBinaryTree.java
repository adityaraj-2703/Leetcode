package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        int level=0;
        Queue<TreeNode> pq = new LinkedList<>();
        Queue<TreeNode> cq = new LinkedList<>();
        pq.add(root);
        List<TreeNode> al = new ArrayList<>();
        while(!pq.isEmpty()){
            TreeNode t = pq.poll();
            if(level%2!=0){
                al.add(t);
            }
            if(t.left!=null){
                pq.add(t.left);
            }
            if(t.right!=null){
                pq.add(t.right);
            }
            if(pq.isEmpty()){
                if(level%2!=0){
                    int i = 0;
                    int j = al.size()-1;
                    while(i<j){
                        int temp = al.get(i).val;
                        al.get(i).val = al.get(j).val;
                        al.get(j).val = temp;
                        i++;
                        j--;
                    }
                    al = new ArrayList<>();
                }
                pq = cq;
                cq = new LinkedList<>();
                level++;

            }
        }
        return root;

    }
}
