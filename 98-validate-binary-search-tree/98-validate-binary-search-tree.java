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
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) 
            return true;
        
        var left = isValidBST(root.left);
        
        if (prev != null) {
            if (prev.val >= root.val)
                return false;
        }
        prev = root;
        
        var right = isValidBST(root.right);
        
        return left && right;
    }
    
    
    // Check inOrder Traversal of the Tree
//     public boolean isValidBST(TreeNode root) {
//         List<Integer> level = new ArrayList<>();
//         getInOrder(root, level);
//         for (int i = 0; i < level.size() - 1; i++) {
//             if (level.get(i) >= level.get(i+1)) return false;
//         }
//         return true;
//     }
    
//     private void getInOrder(TreeNode root, List<Integer> level) {
//         if (root == null) return;
//         getInOrder(root.left, level);
//         level.add(root.val);
//         getInOrder(root.right, level);
//     }
    
}