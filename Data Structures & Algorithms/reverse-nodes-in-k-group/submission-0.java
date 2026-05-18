/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) break;          // fewer than k nodes remain

            ListNode groupNext = kth.next;   // save node after group
            ListNode curr = groupPrev.next;  // start of group (will become tail)

            // reverse the group
            reverse(groupPrev.next, kth);

            // reconnect
            groupPrev.next = kth;            // groupPrev → new head of group
            curr.next = groupNext;           // old head (now tail) → next group

            groupPrev = curr;                // advance groupPrev to tail of reversed group
        }

        return dummy.next;
    }

    private void reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;
        ListNode stop = end.next;            // stop before this node

        while (curr != stop) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    }

    private ListNode getKth(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
}
