package queue;

import java.util.HashMap;
import java.util.Map;

public class MRUQueue {
    class Node {
        int key;

        Node prev;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    Node head = new Node(-1);
    Node tail = new Node(-1);
    Map<Integer, Node> hm = new HashMap<>();

    public MRUQueue(int n) {
        head.next = tail;
        tail.prev = head;
        for (int i = 1; i <= n; i++) {
            Node newNode = new Node(i);
            addNode(newNode);
            hm.put(i, tail.prev);
        }
    }

    public void addNode(Node newNode) {
        Node temp = tail.prev;
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = tail;
        tail.prev = newNode;
    }

    public void removeNode(Node delNode) {
        Node prevv = delNode.prev;
        Node nextt = delNode.next;
        prevv.next = nextt;
        nextt.prev = prevv;
    }

    public int fetch(int k) {
        Node delNode = hm.get(k);
        removeNode(delNode);
        addNode(new Node(delNode.key));
        return delNode.key;
    }

    public static void main(String[] args) {
        MRUQueue m = new MRUQueue(8);
        System.out.println(m.fetch(3));
        System.out.println(m.fetch(5));
        System.out.println(m.fetch(2));
        System.out.println(m.fetch(8));
    }

}
