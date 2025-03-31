package linkedelist;

import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode1 mergeKLists(ListNode1[] lists) {
        PriorityQueue<ListNode1> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (int i = 0; i < lists.length; i++) {

            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        ListNode1 ans = new ListNode1(0);
        ListNode1 currans = ans;
        while (!pq.isEmpty()) {
            ListNode1 l = pq.poll();
            currans.next = l;
            if (l.next != null) {
                pq.add(l.next);
            }
            currans = currans.next;
        }

        return currans.next;
    }
}
