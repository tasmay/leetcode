/*
* Basic LinkedList Implementation
* Reverse a LinkedList: https://leetcode.com/problems/reverse-linked-list/
* Remove Nth Node from end of linkedlist: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
* */

public class LinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode nxt = null;
        ListNode curr = head;

        while(curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        head = prev;
        return head;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        if (head != null){
            do {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            } while (curr != head && curr != null);
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode last = head;
        ListNode prev = null;
        int i=0;
        while(last != null) {
            if (i<n) {
                i++;
            } else {
                prev = curr;
                curr = curr.next;
            }
            last = last.next;
        }
        if (curr == head) {
            head = curr.next;
        } else {
            prev.next = curr.next;
        }
        curr.next = null;
        return head;
    }

    public static boolean hasCycle(ListNode head) {
        if (head==null)
            return false;
        ListNode current = head;
        ListNode lookahead = head;

        while(lookahead.next != null && lookahead.next.next != null) {
            current = current.next;
            lookahead = lookahead.next.next;
            if (current == lookahead)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode myNode = new ListNode(1);
        myNode.next = new ListNode(2);
        myNode.next.next = new ListNode(3);
        myNode.next.next.next = new ListNode(4);
        myNode.next.next.next.next = new ListNode(5);
        myNode.next.next.next.next.next = myNode;
        printList(myNode);
        System.out.println();
        System.out.println("Has Cycle: " + hasCycle(myNode));
        printList(myNode);
    }
}
