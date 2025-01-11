package tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<Pair12>> hm = new TreeMap<>();
        traverse(root,0,0,hm);
        List<List<Integer>> ans = new ArrayList<>();
        for(Map.Entry m : hm.entrySet()){
            List<Pair12> temp = (List)m.getValue();
            Collections.sort(temp, new Comparator<Pair12>() {
                public int compare(Pair12 a, Pair12 b) {
                    if(a.h != b.h){
                        return a.h - b.h;
                    }
                    else{
                        return a.ind - b.ind;
                    }
                }
            });
            List<Integer> t1 = new ArrayList<>();
            for(int i=0;i<temp.size();i++){
                t1.add(temp.get(i).ind);
            }
            ans.add(t1);
        }
        return ans;
    }
    public static void traverse(TreeNode root,int v,int l, TreeMap<Integer,List<Pair12>> hm){
        if(root==null){
            return;
        }
        List<Pair12> a = hm.getOrDefault(v,new ArrayList<>());
        a.add(new Pair12(l,root.val));
        hm.put(v,a);
        traverse(root.left,v-1,l+1,hm);
        traverse(root.right,v+1,l+1,hm);
    }
}
class Pair12{
    int h;
    int ind;
    Pair12(int h,int ind){
        this.h = h;
        this.ind = ind;
    }
}
