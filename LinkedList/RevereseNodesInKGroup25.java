package LinkedList;

public class RevereseNodesInKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {

        // forward temp till kth node
        // so we can get the linkedlist which we want to reverse
        ListNode temp = head;
        for (int i = 1; i < k; i++) {
            // if length less than k , return head
            if (temp == null) {
                return head;
            }

            temp = temp.next;
        }
        // if length less than k , return head
        if (temp == null) {
            return head;
        }

        // we get reversed list from this
        ListNode res = reverseKGroup(temp.next, k);

        // this will make sure only k nodes get reversed
        temp.next = null;

        ListNode head1 = head;
        ListNode prev = null;
        ListNode curr = head;

        // easy reverse logic
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head1.next = res;
        return prev;

    } 
}
