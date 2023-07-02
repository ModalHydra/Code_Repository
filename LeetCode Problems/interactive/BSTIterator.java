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
class BSTIterator {
    ArrayList<Integer> valueHolder = new ArrayList<Integer>();
    int position = 0;
    int size = 0;

    public BSTIterator(TreeNode r) {
        TreeNode temp;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(r);
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
        size = valueHolder.size();

    }
    
    public int next() {
        position++;
        return valueHolder.get(position - 1);
    }
    
    public boolean hasNext() {
        if(position >= size){
            return false;
        }
        else{
            return true;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */