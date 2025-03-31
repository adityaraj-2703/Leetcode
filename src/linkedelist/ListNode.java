package linkedelist;

class ListNode1 {
    int val;
    ListNode1 next;

    public ListNode1() {
    }

    public ListNode1(int val) {
        this.val = val;
    }

    public ListNode1(int val, ListNode1 next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode1 getNext() {
        return next;
    }

    public void setNext(ListNode1 next) {
        this.next = next;
    }

    public void display(ListNode1 head) {
        ListNode1 curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public ListNode1 insertAtStart(int val, ListNode1 head) {
        ListNode1 temp = new ListNode1(val, head);
        return temp;
    }

    public ListNode1 insertAtEnd(int val, ListNode1 head) {
        ListNode1 curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        ListNode1 temp = new ListNode1(val);
        curr.next = temp;
        return head;
    }

    public ListNode1 insertAtKth(int val, int k, ListNode1 head) {
        if (k == 0) {
            return insertAtStart(val, head);
        }
        int c = 1;
        ListNode1 curr = head;
        ListNode1 prev = null;
        while (curr != null && c < k) {
            prev = curr;
            curr = curr.next;
            c++;
        }
        prev.next = new ListNode1(val, curr);

        return head;
    }

    public ListNode1 reverseRecursion(ListNode1 head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode1 newHead = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode1 reverseIteration(ListNode1 head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode1 prev = null;
        ListNode1 curr = head;
        while (curr != null) {
            ListNode1 next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode1 deleteFromStart(ListNode1 head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    public ListNode1 deleteFromEnd(ListNode1 head) {
        ListNode1 curr = head;
        while (curr.next != null && curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    public int size(ListNode1 head) {
        int size = 0;
        ListNode1 curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    public static ListNode1 addtoList(int[] val) {
        ListNode1 head = new ListNode1(val[0]);
        ListNode1 curr = head;
        for (int i = 1; i < val.length; i++) {
            ListNode1 temp = new ListNode1(val[i]);
            curr.setNext(temp);
            curr = temp;

        }
        return head;
    }
}
