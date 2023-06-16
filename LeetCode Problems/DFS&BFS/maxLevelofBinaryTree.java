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
    public int maxLevelSum(TreeNode root) {
        int level = 1;
        int maxLevel = 1;
        int curr = root.val;
        int max = root.val;
        int numNodesInLevel = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            numNodesInLevel = queue.size();
            curr = 0;
            for(int i = 0; i < numNodesInLevel; i++){
                TreeNode temp = queue.poll();
                curr+= temp.val;
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }

            if(curr > max){
                max = curr;
                maxLevel = level;
            }

            level++;

        
        }

        return maxLevel;
    }
}