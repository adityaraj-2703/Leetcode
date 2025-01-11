package linkedelist;

public class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }
    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }

    public void display(ListNode head){
        ListNode curr = head;
        while(curr!=null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
    public ListNode insertAtStart(int val,ListNode head){
        ListNode temp = new ListNode(val,head);
        return temp;
    }
    public ListNode insertAtEnd(int val,ListNode head){
        ListNode curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        ListNode temp = new ListNode(val);
        curr.next = temp;
        return head;
    }
    public ListNode insertAtKth(int val,int k,ListNode head){
        if(k==0){
            return insertAtStart(val, head);
        }
        int c = 1;
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null && c<k){
            prev = curr;
            curr = curr.next;
            c++;
        }
        prev.next = new ListNode(val,curr);

        return head;
    }
    public ListNode reverseRecursion(ListNode head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode newHead = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode reverseIteration(ListNode head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode deleteFromStart(ListNode head){
        if(head==null){
            return null;
        }
        return head.next;
    }
    public ListNode deleteFromEnd(ListNode head){
        ListNode curr = head;
        while(curr.next!=null && curr.next.next!=null){
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }
    public int size(ListNode head){
        int size=0;
        ListNode curr = head;
        while(curr!=null){
            size++;
            curr = curr.next;
        }
        return size;
    }

    public static ListNode addtoList(int[] val){
        ListNode head = new ListNode(val[0]);
        ListNode curr = head;
        for(int i=1;i<val.length;i++){
            ListNode temp = new ListNode(val[i]);
            curr.setNext(temp);
            curr = temp;
            
        }
        return head;
    }
}
