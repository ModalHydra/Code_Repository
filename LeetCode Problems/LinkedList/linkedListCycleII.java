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
        Map<ListNode, Integer> linkMap = new HashMap<ListNode, Integer>();
        boolean forward = true;
        int count = 0;
        if(head == null){
            return head;
        }

        while(forward){
            if(head.next == null){
                return null;
            }
            if(!linkMap.containsKey(head)){
                linkMap.put(head, count);
                head = head.next;
            }
            else{
                forward = false;
            }
            count++;
        }

        System.out.println(head.val);
        return head;
    }
}