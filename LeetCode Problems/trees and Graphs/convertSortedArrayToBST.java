/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root;
        int len = nums.length;
        root = convertToBSTHelper(nums, 0, len-1);
        return root;
    }

    public TreeNode convertToBSTHelper(int[] nums, int start, int end){
        TreeNode root = new TreeNode();
        int mid = (start + end)/2;

        if(start > end){
            return null;
        }
        else{
            root.val = nums[mid];
        }

        root.left = convertToBSTHelper(nums, start, mid -1);
        root.right = convertToBSTHelper(nums, mid + 1, end);


        return root;
    }
}