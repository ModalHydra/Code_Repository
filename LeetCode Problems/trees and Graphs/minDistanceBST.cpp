/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int minDiffInBST(TreeNode* root) {
        int min;
        stack<TreeNode *> holder;
        TreeNode* currentNode = root;
        vector<int> values;

        while(currentNode != NULL || holder.empty() == false){
            
            while(currentNode != NULL){
                holder.push(currentNode);
                currentNode = currentNode -> left;
            }

            currentNode = holder.top();

            holder.pop();
            values.insert(values.begin(), currentNode -> val);
            currentNode = currentNode -> right;
        }
        
        min = abs(values[0] - values[1]);

        for(int i = 0; i < size(values); i++){
            for(int j = 0; j < size(values); j++){
                if(abs(values[i] - values[j]) < min && i != j){
                    min = abs(values[i] - values[j]);
                }
            }
        }

        return min;
        
    }
};