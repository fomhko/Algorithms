/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        do{
            if (p1 != null && p1.next != null){
                 p1 = p1.next.next;
            }
            else{return null;}
            p2 = p2.next;
        }while(p1 != p2);
        p1 = head;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
