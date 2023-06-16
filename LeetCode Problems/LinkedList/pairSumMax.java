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
    public int pairSum(ListNode head) {
        int len = 0;
        int max = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }

        int array[] = new int[len];
        for(int i = 0; i < len; i++){
            array[i] = head.val;
            head = head.next;
        }

        int left = 0;
        int right = len -1;
        int currentSum = 0;
        while(left < right){
            currentSum = array[left] + array[right];
            if(currentSum > max){
                max = currentSum;
            }
            left++;
            right--;
        }

        return max;
    }
}