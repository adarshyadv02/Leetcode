/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node solve(Node head){
        if(head==null) return null;
        Node it=head;
        Node tail=it;
        while(it!=null){
            if(it.child!=null){
                Node childTail=solve(it.child);
                Node temp=it.next;
                it.next=it.child;
                it.next.prev=it;
                childTail.next=temp;
                if(temp!=null)
                    temp.prev=childTail;
                it.child=null;
            }
            tail=it;
            it=it.next;
        }
        return tail;
    }
    public Node flatten(Node head) {
        solve(head);
        return head;
    }
}