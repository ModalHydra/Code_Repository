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
        // convert them to strings and call my addStrings function
        String num1 = "";
        String num2 = "";
        

        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }

        while(l1 != null){
            num1 += l1.val;
            l1 = l1.next;
        }
        while(l2 != null){
            num2 += l2.val;
            l2 = l2.next;
        }

        String finalString = addStrings(num1, num2);
        int finalStringLen = finalString.length();
        ListNode output = new ListNode();
        ListNode temp = output;

        // convert result into Linked List
        for(int i = 0; i < finalStringLen; i++){
            temp.val = Integer.valueOf(finalString.charAt(i)) - '0';
            if(i != finalStringLen - 1){
                temp.next = new ListNode();
                temp = temp.next;
            }
        }

        return output;

        
    }

    String addStrings(String num1, String num2){
        String output = "";
        int len1 = num1.length();
        int len2 = num2.length();
        int difference = Math.abs(len1 - len2);

        num1 = reverse(num1);
        num2 = reverse(num2);

        if(len1 < len2){
            for(int i = 0; i < difference; i++){
                num1 += "0";
            }
        }
        else if (len1 > len2){
            for(int i = 0; i < difference; i++){
                num2 += "0";
            }
        }


        int temp1;
        int temp2;
        int carryOver = 0;
        int partialSum;
        String sPS;

        

        for(int i = 0; i < Math.max(len1, len2); i++){
            temp1 = Integer.valueOf(num1.charAt(i)) - '0';
            temp2 = Integer.valueOf(num2.charAt(i)) - '0';
            partialSum = temp1 + temp2 + carryOver;
            sPS = String.valueOf(partialSum);
            if(sPS.length() == 1){
                output += sPS.charAt(0);
                carryOver = 0;
            }
            else{
                output += sPS.charAt(1);
                carryOver = Integer.valueOf(sPS.charAt(0)) - '0';
            }
        }
        if(carryOver > 0){
            output += String.valueOf(carryOver);
        }

        return reverse(output);

    }

    String reverse(String num){
        String output = "";
        int len = num.length();

        for(int i = len -1; i >= 0; i--){
            output += num.charAt(i);
        }

        return output;
    }
}