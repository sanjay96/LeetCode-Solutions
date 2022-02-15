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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode buildTree(int preorderStart, int inorderStart, int inorderEnd, int[] preorder, int[] inorder) {
        if (preorderStart > preorder.length - 1 || inorderStart > inorderEnd) 
            return null;
        
        TreeNode root = new TreeNode(preorder[preorderStart]);
        
        int inorderIndex = 0;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (root.val == inorder[i])
                inorderIndex = i;
        }
        
        root.left = buildTree(preorderStart + 1, inorderStart, inorderIndex - 1, preorder, inorder);
        root.right = buildTree(preorderStart + inorderIndex - inorderStart + 1, inorderIndex + 1, inorderEnd, preorder, inorder);
        return root;
    }
}
