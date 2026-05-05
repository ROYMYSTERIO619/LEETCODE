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
    public ListNode rotateRight(ListNode head, int k) {
        //empty test case scenarios
        if (head == null || head.next == null) {
            return head;
        }
        //total length of list using and finding tail
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        //normalise the value of k
        k = k % length;
        // If k is 0, the list remains unchanged
        if (k == 0) {
            return head;
        }
//new tail
        ListNode current = head;
        for (int i = 0; i < length - k - 1; i++) {
            current = current.next;
        }

        // The new head is the node after the new tail
        ListNode newHead = current.next;
        // Break the list at the new tail
        current.next = null;
        // Connect the old tail to the old head
        tail.next = head;

        return newHead;
    }
}   