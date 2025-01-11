package linkedelist;

import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1,n2)->n1.val-n2.val);
        for(int i=0;i<lists.length;i++){
            
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        ListNode ans = new ListNode(0);
        ListNode currans = ans;
        while(!pq.isEmpty()){
            ListNode l = pq.poll();
            currans.next = l;
            if(l.next!=null){
                pq.add(l.next);
            }
            currans = currans.next;
        }
        
        return currans.next;
    }
}
