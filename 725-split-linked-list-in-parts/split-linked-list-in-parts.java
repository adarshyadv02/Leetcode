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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int N=0;
        ListNode it=head;
        while(it!=null){
            N++;
            it=it.next;
        }
        int idealPartSize=N/k;
        int extraNode=N%k;
        ListNode[] ans = new ListNode[k];
        it =head;
        for(int i=0;i<k&&it!=null;i++){
            ans[i]=it;
            int actualPartSize=idealPartSize +(extraNode-- > 0? 1:0);
            for(int j=0;j<actualPartSize-1;j++)
            it=it.next;

            ListNode nextPartStarting=it.next;
            it.next=null;
            it=nextPartStarting;
        }
        return ans;
    }
}