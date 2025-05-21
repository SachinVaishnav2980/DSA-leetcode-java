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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummyNode=new ListNode(0);
        dummyNode.next=head;
        ListNode temp=dummyNode;
        ListNode node=dummyNode;
        ListNode countNode=head;
        int count=0;
        while(countNode!=null){
            count++;
            countNode=countNode.next;
        }
        int i=1;
        while(i<=k){
            temp=temp.next;
            i++;
        }
        int j=1;
        while(j<=count-k+1){
            node=node.next;
            j++;
        }
        ListNode swap=new ListNode(0);
        swap.val=temp.val;
        temp.val=node.val;
        node.val=swap.val;

        return dummyNode.next;
    }
}