package LinkedList;
public class RemoveElementsFromListedList203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (curr.val == val) {
                curr = curr.next;
                if (prev != null) {
                    prev.next = curr;
                } else {
                    head = head.next;
                }
            } else {
                prev = curr;
                curr = curr.next;

            }

        }

        return head;
    }
}
