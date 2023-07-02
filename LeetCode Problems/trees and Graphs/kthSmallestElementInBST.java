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
    public int kthSmallest(TreeNode root, int k) {
        
        // depth first search means recursion

        int output = 0;
        TreeNode temp;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> valueHolder = new ArrayList<Integer>();

        queue.add(root);

        while(queue.peek() != null){
            temp = queue.poll();
            valueHolder.add(temp.val);
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        


  
        Collections.sort(valueHolder);  
        System.out.println(valueHolder.toString());

        // get all elements into a list
        // add those elements to an array
        // sort that array
        // get the kth element

        return valueHolder.get(k-1);

    }

}