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
        
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            temp = temp.next;
            len++;
        }

        temp = head;

        if(head.next == null){
            return null;
        }
        else if(len == n){
            return head.next;
        }
        else if(n == 1){
            for(int i = 0; i < len - 2; i++){
                temp = temp.next;
            }
            temp.next = null;
        }
        else{
            for(int i = 0; i < len - n - 1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }

        return head;
    }
}