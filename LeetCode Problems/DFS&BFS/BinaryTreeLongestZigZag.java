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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        longestZigZagHelper(root,true,0);
        longestZigZagHelper(root,false,0);

        return max;
    }

    public void longestZigZagHelper(TreeNode root, boolean direct, int cur){
        if(root == null){
            return;
        }
    
        max = Math.max(max, cur);

        if(!direct){ // left
            longestZigZagHelper(root.left, !direct, cur+1);
            longestZigZagHelper(root.right, direct, 1);
        }
        else{ // right
            longestZigZagHelper(root.left, direct, 1);
            longestZigZagHelper(root.right, !direct, cur+1);
        }

    }
}
