package trie;

public class TrieNodeBinary {
    TrieNodeBinary[] children;
    boolean wordEnd;
    TrieNodeBinary(){
        this.children = new TrieNodeBinary[2];
        this.wordEnd = false;
    }
    public void addWord(TrieNodeBinary root,String s){
        TrieNodeBinary curr = root;
        if(root==null){
            root = new TrieNodeBinary();
        }
        for(int i=s.length()-1;i>=0;i--){
            int val = -1;
            if(s.charAt(i)=='0'){
                val=0;
            }
            else{
                val=1;
            }
            if(curr.children[val]==null){
                curr.children[val] = new TrieNodeBinary();
            }
            curr = curr.children[val];
        }
        curr.wordEnd = true;
    }
    public boolean search(TrieNodeBinary root,String s){
        TrieNodeBinary curr = root;
        if(root==null){
            root = new TrieNodeBinary();
        }
        for(int i=s.length()-1;i>=0;i--){
            int val = -1;
            if(s.charAt(i)=='0'){
                val=0;
            }
            else{
                val=1;
            }
            if(curr.children[val]==null){
                return false;
            }
            curr = curr.children[val];
        }
        return curr.wordEnd;
    }
    public String addWordAndXor(TrieNodeBinary root,String s){
        TrieNodeBinary curr1 = root;
        TrieNodeBinary curr2 = root;
        StringBuilder sb = new StringBuilder();
        if(root==null){
            root = new TrieNodeBinary();
        }
        for(int i=s.length()-1;i>=0;i--){
            int val = -1;
            if(s.charAt(i)=='0'){
                val=1;
            }
            else{
                val=0;
            }
            if(curr2.children[val]==null){
                sb.append(Math.abs(val-1) + "");
                curr2 = curr2.children[Math.abs(val-1)];
            }
            else{
                sb.append(val+"");
                curr2 = curr2.children[val];
            }
            
        }
        addWord(root,s);
        
        return sb.toString();
    }
    
}
