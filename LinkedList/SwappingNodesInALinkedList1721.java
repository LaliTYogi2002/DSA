package LinkedList;

public class SwappingNodesInALinkedList1721 {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode dummy = head;
        for (int i = 1; i < k; i++) {
            dummy = dummy.next;
        }

        ListNode node1 = dummy;
        ListNode temp = head;
        while (dummy.next != null) {
            temp = temp.next;
            dummy = dummy.next;
        }

        int val1 = node1.val;
        int val2 = temp.val;

        node1.val = val2;
        temp.val = val1;

        return head;
    }
}
