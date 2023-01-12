import java.util.List;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode head = new ListNode();
        ListNode tail = head;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1 != null)
            tail.next = list1;
        else if (list2 != null)
            tail.next = list2;
        return head.next;
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

    public static void main(String[] args) {
        // list1 = [1,2,4]
        ListNode n1 = new ListNode(5);
        //ListNode n2 = new ListNode(2);
        //ListNode n4 = new ListNode(4);
        //n1.next = n2;
        //n2.next = n4;
        // list2 = [1,3,4]
        ListNode m1 = new ListNode(1);
        ListNode m3 = new ListNode(2);
        ListNode m4 = new ListNode(4);
        m1.next = m3;
        m3.next = m4;
        ListNode result = mergeTwoLists(n1, m1);
        printList(result);
    }
}
