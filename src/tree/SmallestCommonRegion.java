package tree;

import java.util.*;;

public class SmallestCommonRegion {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String,TreeNode1> hm = new HashMap<>();
        TreeNode1 root = null;
        for(int i=0;i<regions.size();i++){
            if(root==null){
                root = new TreeNode1(regions.get(i).get(0));
                hm.put(root.val, root);
                List<TreeNode1> al = new ArrayList<>();
                for(int j=1;j<regions.get(i).size();j++){
                    TreeNode1 t = new TreeNode1(regions.get(i).get(j));
                    al.add(t);
                    hm.put(t.val, t);
                }
                root.tList = al;
            }
            else{
                TreeNode1 t = hm.get(regions.get(i).get(0));
                List<TreeNode1> al = new ArrayList<>();
                for(int j=1;j<regions.get(i).size();j++){
                    TreeNode1 temp = new TreeNode1(regions.get(i).get(j));
                    al.add(temp);
                    hm.put(temp.val, temp);
                }  
                t.tList = al;
            }
        }
        TreeNode1 ans = findLCA(root,hm.get(region1),hm.get(region2));
        if(ans==null){
            return null;
        }
        return ans.val;
    }
    public static TreeNode1 findLCA(TreeNode1 root, TreeNode1 p,TreeNode1 q){
        if(root==null){
            return null;
        }
        if(root==p || root == q){
            return root;
        }
        if(root.tList==null){
            return null;
        }
        TreeNode1 a1 = null;
        TreeNode1 a2 = null;
        for(int i=0;i<root.tList.size();i++){
            TreeNode1 temp = findLCA(root.tList.get(i),p,q);
            if(temp!=null){
                if(a1==null){
                    a1 = temp;
                }
                else if(a2==null){
                    a2=temp;
                }
            }
        }
        if(a1!=null && a2!=null){
            return root;
        }
        else if(a1!=null){
            return a1;
        }
        else{
            return a2;
        }
    }
}
class TreeNode1{
    String val;
    List<TreeNode1> tList;
    TreeNode1(String val){
        this.val = val;
        this.tList = null;
    }
}