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
    public ListNode reverse(ListNode temp){

        ListNode prev=null;
        ListNode curr=temp;
        while(curr!=null){
            ListNode node=curr.next;
            curr.next=prev;
            prev=curr;
            curr=node;
        }
        return prev;

    }
    public int pairSum(ListNode head) {
        
      
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode newNode=reverse(slow.next);
        slow.next=null;

        

        int sum=0;
        int max=Integer.MIN_VALUE;
        while(newNode!=null){
            sum=head.val+newNode.val;
            if(max<sum){
                max=sum;
            }
            head=head.next;
            newNode=newNode.next;
        }

    return max;
        
     }
}