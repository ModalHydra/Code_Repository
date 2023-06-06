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
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int len = linkedListLen(head);
        head = cur;

        if(len < 2){
            return head;
        }

        if(len % 2 == 0){
            for(int i = 0; i < len/2; i++){
                head = head.next;
            }
        }
        else{
            for(int i = 0; i < len/2; i++){
                head = head.next;
            }
        }
        

        return head;
    }

    public int linkedListLen(ListNode head){
        int count = 0;
        if(head != null){
            count++;
            while(head.next != null){
                head = head.next;
                count++;
            }
        }

        return count;
    }
}