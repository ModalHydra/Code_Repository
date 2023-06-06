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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode sortedList = new ListNode();
        int len1 = numNodes(list1), len2 = numNodes(list2);
        int totalLen = len1 + len2;

        
        // compare list1.val with list2.val

        if(len1 == 0 && len2 == 0){
            return list1;
        }
        else if(len2 == 0){
            return list1;
        }
        else if(len1 == 0){
            return list2;
        }

        

        if(list1.val < list2.val){
            sortedList.val = list1.val;
            sortedList.next = mergeTwoLists(list1.next, list2);
        }
        else if(list1.val >= list2.val){
            sortedList.val = list2.val;
            sortedList.next = mergeTwoLists(list1, list2.next);
        }

        return sortedList;
    }


    public int numNodes(ListNode list){
        int count = 0;

        if(list != null){
            count++;
            while(list.next != null){
                count++;
                list = list.next;
            }
        }

        return count;
    }
}