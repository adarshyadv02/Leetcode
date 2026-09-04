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
    public boolean isPalindrome(ListNode head) {
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode FinalMid;
        if((len&1)==1){
            FinalMid=slow.next;
        }
        else{
            FinalMid=slow;
        }
        ListNode prev=null;
        ListNode curr=FinalMid;
        while(curr!=null){
            ListNode forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
        }
        FinalMid=prev;
        temp=head;
        while(FinalMid!=null){
            if(temp.val !=FinalMid.val){
                return false;
            }
            else{
                temp=temp.next;
                FinalMid=FinalMid.next;
            }
        }
        return true;
    }
}