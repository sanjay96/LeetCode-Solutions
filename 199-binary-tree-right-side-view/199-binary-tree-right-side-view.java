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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int depth = 0;
        dfs(result, root, depth);
        return result;
    }
    
    private void dfs(List<Integer> result, TreeNode root, int depth) {
        if (root == null)
            return;
        if (result.size() == depth)
            result.add(root.val);
        
        dfs(result, root.right, depth + 1);
        dfs(result, root.left, depth + 1);
    }
    
    // Implemented using BFS 
    // public List<Integer> rightSideView(TreeNode root) {
        // List<Integer> result = new ArrayList<>();
        // Queue<TreeNode> queue = new LinkedList<>();
        // if (root == null) {
        //     return result;
        // }
        // queue.add(root);
        // while (!queue.isEmpty()) {
        //     List<Integer> level = new ArrayList<>();
        //     int size = queue.size();
        //     for (int i = 0; i < size; i++) {
        //         TreeNode temp = queue.poll();
        //         if (temp != null) level.add(temp.val);
        //         if (temp.left != null) 
        //             queue.add(temp.left);
        //         if (temp.right != null)
        //             queue.add(temp.right);
        //     }
        //     result.add(level.get(level.size() - 1));
        // }
        // return result;
    // }
}