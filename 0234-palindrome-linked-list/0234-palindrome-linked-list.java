class Solution {
    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode newHead=reverse(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)return true;
        ListNode fast=head;
        ListNode slow=head;
       
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newHead=reverse(slow);
       
      ListNode first=head;
      ListNode second=newHead;
        while(second!=null){
            if(first.val!=second.val){
                
                return false;
            }
            first=first.next;
            second=second.next;

           
        }

        
        return true;
    }
}