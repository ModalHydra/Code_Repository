
import java.math.BigInteger;
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger bigL1, bigL2, bigTotal, tempBig1, tempBig2, big10;
        bigL1 = new BigInteger("0");
        bigL2 = new BigInteger("0");
        int l1Length = linkedListLength(l1);
        int l2Length = linkedListLength(l2);
        String totalS;
        ListNode finalNum = new ListNode();
        // got to declare new BigInteger or something
        for(int i = l1Length - 1; i >= 0; i--){
            big10 = new BigInteger("10"); 
            tempBig1 = new BigInteger(Integer.toString(traverseLinkedList(l1,i).val));
            big10 = big10.pow(i);
            tempBig1 = tempBig1.multiply(big10);
            bigL1 = bigL1.add(tempBig1);
        }

        
    for(int i = l2Length - 1; i >= 0; i--){
            big10 = new BigInteger("10"); 
            tempBig2 = new BigInteger(Integer.toString(traverseLinkedList(l2,i).val));
            big10 = big10.pow(i);
            tempBig2 = tempBig2.multiply(big10);
            bigL2 = bigL2.add(tempBig2);
        }

       
        bigTotal = bigL1.add(bigL2);
        System.out.println(bigTotal);
        totalS = bigTotal.toString();
        
        
        int totalLength = totalS.length();

        return buildFinalNum(finalNum, totalLength, totalS);
    }

    public ListNode traverseLinkedList(ListNode l1, int position){
        ListNode returnNode = l1;
        for(int i = 0; i < position; i++){
            returnNode = returnNode.next;
        }

        return returnNode;
    }

    public int linkedListLength(ListNode l1){
        int len = 1;
        while(l1.next != null){
            len++;
            l1 = l1.next;
        }
        return len;
    }

    public ListNode buildFinalNum(ListNode finalNum, int len, String total){
        ListNode temp = finalNum;
        ListNode head = finalNum;
       
        for(int i = len - 1; i >= 0; i--){
            temp.val = (int)total.charAt(i) - (int)'0';
            System.out.print(temp.val);
            if(i != 0){
                temp.next = new ListNode();
                temp = temp.next;
            }
        }


        return head;
    }
}