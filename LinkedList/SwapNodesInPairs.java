
package LinkedList;

class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = swapPairs(head.next.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        temp.next.next = res;

        return temp;

    }
}