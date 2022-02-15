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
    // Get the kth element in the inorder traversal of the tree
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        kthSmallest(root, inorder);
        return inorder.get(k-1);
    }
    
    private void kthSmallest(TreeNode root, List<Integer> inorder) {
        if (root == null) 
            return;
        kthSmallest(root.left, inorder);
        inorder.add(root.val);
        kthSmallest(root.right, inorder);
    }
    
}