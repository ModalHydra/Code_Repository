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

    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root, -100000);
    }

    public int goodNodesHelper(TreeNode root, int maxPast){
        if(root == null){
            return 0;
        }

        if(maxPast <= root.val){
            return goodNodesHelper(root.left, root.val) + goodNodesHelper(root.right, root.val) + 1;
        }
        else{
            return goodNodesHelper(root.left, maxPast) + goodNodesHelper(root.right, maxPast);
        }

    }
}