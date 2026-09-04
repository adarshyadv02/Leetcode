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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int re=0;
        re=len-n;
        ListNode prev=head;
        if(re==0){
            head=head.next;
            return head;
        }
        else{
        for(int i=0;i<re-1;i++){
            prev=prev.next;
        }
        ListNode curr=prev.next;
        ListNode forward=curr.next;
        curr.next=null;
        prev.next=forward;
        }
        return head;
    }
}