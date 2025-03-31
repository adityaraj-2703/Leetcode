package linkedelist;

import java.util.Stack;

public class MaximumTwinSum {
    public int pairSum(ListNode1 head) {
        Stack<Integer> st = new Stack<>();
        ListNode1 slow = head;
        ListNode1 fast = head;
        while (fast != null && fast.next != null) {
            st.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        ListNode1 curr = head;
        int max = 0;
        while (slow != null) {
            max = Math.max(max, curr.val + slow.val);
            curr = curr.next;
            slow = slow.next;
        }
        return max;

    }

    public ListNode1 reverse(ListNode1 head) {
        ListNode1 curr = head;
        ListNode1 prev = null;
        while (curr != null) {
            ListNode1 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {

    }

    static class ListNode2 {
        int val;
        ListNode2 next;

        ListNode2() {
        }

        ListNode2(int val) {
            this.val = val;
        }

        ListNode2(int val, ListNode2 next) {
            this.val = val;
            this.next = next;
        }

        public void setNext(ListNode2 temp) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setNext'");
        }
    }

}
