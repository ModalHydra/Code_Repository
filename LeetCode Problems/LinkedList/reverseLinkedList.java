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
    public ListNode reverseList(ListNode head) {
        ListNode reverse = head;
        // if head is empty list
        if(head == null){
            return head;
        }

        // if head has only one value
        if(head.next == null){
            return head;
        }

        // create an array holding all values of head
        int len = linkedListLen(head);
        int headArray[] = new int[len];
        int backArray[] = new int[len];
        int j = len - 1;


        for(int i = 0; i < len; i++){
            headArray[i] = head.val;
            head = head.next;
        }
        for(int i = 0; i < len; i++){
            backArray[j] = headArray[i];
            j--;
        }



        ListNode top = reverse;        
        for(int i = 0; i < len; i++){
            reverse.val = backArray[i];
            reverse = reverse.next;
        }

        // reverse that array 
        // add the contents of that array to linked list backwards        

        return top;
    }

    public int linkedListLen(ListNode head){
        int count = 0;
        if(head != null){
            count++;
            while(head.next != null){
                count++;
                head = head.next;
            }
        }
        return count;
    }
}