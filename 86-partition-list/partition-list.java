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
    public ListNode partition(ListNode head, int x) {
        ListNode fp=new ListNode(-1);
        ListNode sp=new ListNode(-1);
         ListNode fpTail=fp;
         ListNode spTail=sp;
         ListNode it=head;
         while(it!=null){
            if(it.val<x){
                fpTail.next=it;
                fpTail=fpTail.next;
            }
            else{
                spTail.next=it;
                spTail=spTail.next;
            }
            it=it.next;
         }

         //fp->sp->null
        fpTail.next=sp.next;
        spTail.next=null;
        return fp.next;
    }
}