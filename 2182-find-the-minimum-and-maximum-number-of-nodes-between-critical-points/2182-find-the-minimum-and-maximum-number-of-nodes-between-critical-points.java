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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return new int []{-1,-1};
        }
        int index=1;
        ListNode prev=head;
        ListNode curr=prev.next;
        ListNode nextNode=curr.next;
        ArrayList<Integer> list=new ArrayList<>();
        while (nextNode!=null) {
                if((curr.val<prev.val && curr.val<nextNode.val) || (curr.val>prev.val && curr.val>nextNode.val)){
            list.add(index);
            }
            prev=curr;
            curr=nextNode; 
            nextNode=nextNode.next;
            index++;
        }
        if(list.size()<2){
            return new int []{-1, -1};
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            min=Math.min(min, list.get(i)-list.get(i-1));
        }
        int max = list.get(list.size() - 1) - list.get(0);
        return new int[]{min, max};
    }
}