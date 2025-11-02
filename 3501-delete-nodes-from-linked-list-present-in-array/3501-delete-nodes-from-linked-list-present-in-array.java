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
    public ListNode modifiedList(int[] nums, ListNode head) {

        if(head == null) {
            return null;
        }

        Set<Integer> hs = new HashSet<>();
        ListNode newHead = null, prev = null, curr = head;

        for(int n : nums) {
            hs.add(n);
        }

        while(curr != null) {
            if(!hs.contains(curr.val)) {
                if(newHead == null) {
                    newHead = curr;
                } else {
                    prev.next = curr;
                }

                prev = curr;
            }

            curr = curr.next;
        }

        prev.next = curr;

        return newHead;
    }
}