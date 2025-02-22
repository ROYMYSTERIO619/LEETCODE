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

            // TC - O(N) && SC - O(N)

TreeNode* solve(int &ind, string &traversal, int cntNeeded){
    if(ind == traversal.length())
    return NULL;

    int cnt = 0, i = ind;     // here I take addition i if incase cnt < cntNeeded then we don't want ind value to be updated.

    while(i < traversal.length()){
        if(traversal[i] == '-')
        cnt++;
        else
        break;
        i++;
    }

    if(cnt < cntNeeded)  // if cnt '-' is less than expected then return NULL
    return NULL;

    int val = 0;           // calculate the value for the node.
    while(i < traversal.length()){
        if(traversal[i] == '-')
        break;
        else
        val = val*10 + (traversal[i]-'0');

        i++;
    }
    
    TreeNode* root = new TreeNode(val);

    ind = i; // if everthing go well then update the ind .. [ no need to inc by 1 because in while if traversal[i] = '-' then only loop break's and we got i where trav[i] = '-' ].

    root->left = solve(ind, traversal, cntNeeded+1);  // call For Left
    root->right = solve(ind, traversal, cntNeeded+1); // call for Right

    return root; // return root;
}

    TreeNode* recoverFromPreorder(string traversal) {
        int ind = 0;
        return solve(ind, traversal, 0);
    }
};