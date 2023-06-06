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
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> output = new LinkedList<List<Integer>>();

        TreeNode temp;

        if(root == null){
            return output;
        }


        queue.add(root);

        // need to know what depth I'm at to know when to make a new linkedlist

        while(!queue.isEmpty()){
            // remove value from queue
            LinkedList<Integer> level = new LinkedList<Integer>();
            int siz = queue.size();
            for(int i = 0; i < siz; i++){
                if(queue.peek().left != null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.add(queue.peek().right);
                }
                temp = queue.remove();
                level.add(temp.val);
            }
            output.add(level);
        }

        return output;
    }
}