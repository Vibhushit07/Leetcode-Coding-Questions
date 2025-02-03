/**
 * * Definition for singly-linked list. * public class ListNode { * int val; *
 * ListNode next; * ListNode() {} * ListNode(int val) { this.val = val; } *
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; } * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode prev = null, slow = head, fast = head, prevRev = null;
        int maxSum = Integer.MIN_VALUE;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != null) {
            fast = slow.next;
            slow.next = prevRev;
            prevRev = slow;
            slow = fast;
        }
        prev.next = prevRev;
        slow = head;
        while (slow != prev.next) {
            maxSum = Math.max(maxSum, slow.val + prevRev.val);
            slow = slow.next;
            prevRev = prevRev.next;
        }
        return maxSum;
    }
}