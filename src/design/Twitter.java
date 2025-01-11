package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Twitter {
    Map<Integer,List<Integer>> userTweet;
    Map<Integer,Set<Integer>> userFollow;
    List<List<Integer>> al;

    public Twitter() {
        
        Map<Integer,List<Integer>> userTweet = new HashMap<>();
        Map<Integer,Set<Integer>> userFollow = new HashMap<>();
        List<List<Integer>> al = new ArrayList<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Integer> l = userTweet.getOrDefault(userId,null);
        if(l!=null){
            userTweet.get(userId).add(tweetId);
        }
        else{
            List<Integer> a = new ArrayList<>();
            a.add(tweetId);
            userTweet.put(userId,a);
        }
        List<Integer> a1 = new ArrayList<>();
        a1.add(userId);
        a1.add(tweetId);
        al.add(a1);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        int count=0;
        List<Integer> ans = new ArrayList<>();
        for(int i=al.size()-1;i>=0;i--){
            List<Integer> temp = al.get(i);
            if(userFollow.get(userId).contains(temp.get(0)) || temp.get(0)==userId){
                ans.add(temp.get(1));
                count++;
            }
            if(count==10){
                break;
            }
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> l = userFollow.getOrDefault(followerId,null);
        if(l!=null){
            userFollow.get(followerId).add(followeeId);
        }
        else{
            Set<Integer> a = new HashSet<>();
            a.add(followeeId);
            userFollow.put(followerId,a);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> l = userFollow.getOrDefault(followerId,null);
        if(l!=null){
            userFollow.get(followerId).remove(followeeId);
        }
        else{
            return;
        }
    }
}
