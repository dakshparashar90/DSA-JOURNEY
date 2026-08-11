/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr=headA;
        ListNode curr2=headB;
        while(curr!=curr2){
            curr=curr.next;
            curr2=curr2.next;
            if(curr==curr2){
                return curr;
            }
            if(curr==null)curr=headB;
            if(curr2==null)curr2=headA;
        }
        return curr;
    }
}