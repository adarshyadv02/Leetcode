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
        ListNode temp=head;
        int count=0;
        while(temp!=null&&count<k){
            temp=temp.next;
            count++;
        }
        if(count==k){
            ListNode prev=null;
            ListNode curr=head;
            ListNode forward=null;
            int i=0;
            while(i<k){
                forward=curr.next;
                curr.next=prev;
                prev=curr;
                curr=forward;
                i++;
            }
            ListNode recHead=reverseKGroup(forward,k);
            head.next=recHead;
            return prev;
        }
        else{
            return head;
        }
    }
}