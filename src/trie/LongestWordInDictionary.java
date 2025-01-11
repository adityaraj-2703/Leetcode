package trie;

public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        TrieNode t = new TrieNode();
        for(int i=0;i<words.length;i++){
            t.insert(t,words[i]);
        }
        return t.findLongest(t);
    }
    public class TrieNode{
        TrieNode[] children;
        boolean wordEnd;
        int count;
        TrieNode(){
            this.children = new TrieNode[26];
            this.wordEnd = false;
            this.count=0;
        }
        public void insert(TrieNode root,String s){
            TrieNode curr = root;
            for(int i=0;i<s.length();i++){
                if(curr.children[s.charAt(i)-'a'] == null){
                    curr.children[s.charAt(i)-'a'] = new TrieNode();
                }
                curr.count++;
                curr = curr.children[s.charAt(i)-'a'];
            }
            curr.wordEnd = true;
        }
        public String findLongest(TrieNode root){
            TrieNode curr = root;
        
            StringBuilder sb = new StringBuilder();
            while(curr!=null){
                int max = 0;
                int c = -1;
                for(int i=0;i<26;i++){
                    if(curr.children[i]!=null && curr.children[i].count > max && curr.children[i].wordEnd){
                        max = curr.children[i].count;
                        c = i;
                    }
                    
                }
                if(c==-1){
                    break;
                }
                curr = curr.children[c];
                
                
                
                sb.append((char)(c+97));
            }
            return sb.toString();
            
    
        }
    }
}


