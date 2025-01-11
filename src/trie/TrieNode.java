package trie;

public class TrieNode {
    TrieNode[] children;
    boolean wordEnd;
    int count;
    public TrieNode(){
        wordEnd = false;
        children = new TrieNode[26];
        count=0;
    }
    public void addWord(TrieNode root,String word){
        
        TrieNode curr = root;
        if(curr==null){
            curr = new TrieNode();
        }
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a']==null){
                curr.children[word.charAt(i)-'a'] = new TrieNode();
            }
            curr.children[word.charAt(i)-'a'].count++;
            curr = curr.children[word.charAt(i)-'a'];
            
        }
        curr.wordEnd = true;
        
        
    }
    public boolean search(TrieNode root, String s) {
        TrieNode curr = root;
        for(int i=0;i<s.length();i++){
            if(curr.children[s.charAt(i)-'a']==null){
                return false;
            }
            curr = curr.children[s.charAt(i)-'a'];
        }
        return curr.wordEnd;
    }
    public int findPrefixCount(TrieNode root, String s) {
        TrieNode curr = root;
        for(int i=0;i<s.length();i++){
            if(curr.children[s.charAt(i)-'a']==null){
                return 0;
            }
            curr = curr.children[s.charAt(i)-'a'];
        }
        return curr.count;
    }
    public String findUniquePrefix(TrieNode root, String s) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(curr.count==1){
                return sb.toString();
            }
            sb.append(s.charAt(i));
            curr = curr.children[s.charAt(i)-'a'];
        }
        return sb.toString();
    }
}
