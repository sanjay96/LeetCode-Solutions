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
    //Using Depth First Search
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) 
            return 0;
        
        if (root.left == null && root.right == null) 
            return 0;
        
        return sumOfLeftLeaves(root, true);
    }
    
    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) 
            return 0;
        
        if (root.left == null && root.right == null && isLeft == true) 
            return root.val;
        
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }
    // Using Level Order Traversal
    /*public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) 
            return 0;
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            
            if (temp.left != null && temp.left.left == null && temp.left.right == null) 
                sum = sum + temp.left.val;
            
            if (temp.left != null)
                queue.add(temp.left);
            
            if (temp.right != null)
                queue.add(temp.right);
        }
        return sum;
    }*/
}