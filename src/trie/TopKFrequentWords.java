package trie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> hm = new HashMap<>();
        for(int i=0;i<words.length;i++){
            hm.put(words[i],hm.getOrDefault(words[i], 0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq = 
            new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>() {
                public int compare(Map.Entry<String,Integer> e1,Map.Entry<String,Integer> e2){
                    String word1 = e1.getKey();
                    int frq1 = e1.getValue();
                    String word2 = e2.getKey();
                    int frq2 = e2.getValue();
                    if(frq1!=frq2){
                        return frq2-frq1;
                    }
                    else{
                        return word1.compareTo(word2);
                    }

                }
            });
        for(Map.Entry<String,Integer> m : hm.entrySet()){
            pq.add(m);
        }
        List<String> ans = new ArrayList<>();
        for(int i=0;i<k-1;i++){
            ans.add(pq.poll().getKey());
        }
        return ans;

    }
    class TrieNode{
        TrieNode[] children;
        boolean wordEnd;
        int count;
        TrieNode(){
            this.children = new TrieNode[26];
            this.wordEnd = false;
            this.count=0;
        }
        public void insert(TrieNode root,String word){
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                if(curr.children[word.charAt(i)-'a'] == null){
                    curr.children[word.charAt(i)-'a'] = new TrieNode();
                }
                curr.children[word.charAt(i)-'a'].count++;
                curr = curr.children[word.charAt(i)-'a'];
            }
        }
        public List<String> findKmostFrequentWords(TrieNode root,int k){
            List<String> ans = new ArrayList<>();
            TrieNode curr = root;
            for(int i=0;i<26;i++){
                StringBuilder sb = new StringBuilder();
                TrieNode temp = curr;
                while(temp.children[i]!=null && temp.children[i].count >= k){
                    sb.append((char)(i+97));
                    temp = temp.children[i];
                }
                ans.add(sb.toString());
            }
            return ans;
        }
    }
}
