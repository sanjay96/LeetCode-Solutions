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
    public int sumOfLeftLeaves(TreeNode root) {
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
    }
}