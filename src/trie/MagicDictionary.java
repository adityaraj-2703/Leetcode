package trie;


public class MagicDictionary {

    MagicDictionary[] children;
    boolean wordEnd;
    public MagicDictionary() {
        this.children = new MagicDictionary[26];
        this.wordEnd = false;
    }
    
    public void buildDict(String[] dictionary) {
        MagicDictionary root = this;
        for(int i=0;i<dictionary.length;i++){
            MagicDictionary curr = root;
            for(int j=0;j<dictionary[i].length();j++){
                if(curr.children[dictionary[i].charAt(j)-'a']==null){
                    curr.children[dictionary[i].charAt(j)-'a'] = new MagicDictionary();
                }
                curr = curr.children[dictionary[i].charAt(j)-'a'];
            }
            curr.wordEnd = true;

        }
    }
    
    public boolean search(String searchWord) {
        MagicDictionary curr = this;
        for(int i=0;i<searchWord.length();i++){
            if(curr!=null && curr.children[searchWord.charAt(i)-'a']!=null){
                curr = children[searchWord.charAt(i)-'a'];
            }
            else{
                for(int j=0;j<26;j++){
                    if(curr!=null && curr.children[j]!=null){
                        return search(searchWord.substring(i+1,searchWord.length()));
                    }
                }
            }
        }
        return curr.wordEnd;
    }
}
