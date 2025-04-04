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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return findLCA(root, getDepth(root));
    }

   
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    
    private TreeNode findLCA(TreeNode root, int depth) {
        if (root == null) return null;
        if (depth == 1) return root; 
        
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == rightDepth) {
            return root; 
        } else if (leftDepth > rightDepth) {
            return findLCA(root.left, depth - 1); 
        } else {
            return findLCA(root.right, depth - 1); 
        }
    }
}
                                                                                                                                                    