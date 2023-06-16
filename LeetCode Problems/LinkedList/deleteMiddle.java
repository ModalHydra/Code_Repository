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
    public ListNode deleteMiddle(ListNode head) {
        int len = 0;
        ListNode temp = head;
        ListNode temp2 = head;

        while(temp != null){ // get length of linked list
            len++;
            temp = temp.next;
        }

        int mid = len/2; // calculate mid point
        temp = head;


        if(len == 1){ // address base cases
            return null;
        }
        else if(len == 2){
            head.next = null;
            return head;
        }

        while(mid > 0){ // traverse to mid node and mid node - 1
            temp2 = temp;
            temp = temp.next;
            mid--;
        }

        // have the previous node point to the node after mid node
        temp2.next = temp.next;


        return head;

        
    }
}