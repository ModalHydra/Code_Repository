/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {

        // condition to end traversal
        List<Integer> output = new ArrayList<Integer>();

        if(root == null){
            return output;
        }

        if(root.children.isEmpty()){
            output.add(root.val);
            return output;
        }
        else{
            output.add(root.val);
            for(Node i:root.children){
                output.addAll(preorder(i));
            }
        }

        return output;
    }
}