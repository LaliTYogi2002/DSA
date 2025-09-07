package LinkedList;

public class ReorderList146 {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        
        ListNode head2 = reverse(slow.next);
        slow.next = null;

        while(head2 != null ){
            ListNode next = head.next;
            ListNode next2 = head2.next;
            head.next = head2;
            head2.next = next ;

            head = next;
            head2 = next2;
        }

        return ;

    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;


        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        return prev;


    }
}
