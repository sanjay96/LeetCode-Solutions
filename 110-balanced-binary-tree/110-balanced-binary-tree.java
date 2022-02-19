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
    
    public boolean isBalanced(TreeNode root) {
        int treeHeight = height(root);
        if (treeHeight == -1) 
            return false;
        else 
            return true;
    }
    
    private int height(TreeNode root) {
        if (root == null) 
            return 0;
        int left = height(root.left); 
        int right = height(root.right); 
        if (left == -1 || right == -1)
            return -1;
        if (Math.abs(left - right) > 1)
            return -1;
        return 1 + Math.max(left, right);
    }
    
    

//     public boolean isBalanced(TreeNode root) {
//         if (root == null) return true;
//         int left = helper(root.left);
//         int right = helper(root.right);
//         // System.out.println(left + " " + right);
//         return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//     }
    
//     public int helper(TreeNode root) {
//         if (root == null) return 0;
//         return Math.max(helper(root.left), helper(root.right)) + 1; 
//     }
}