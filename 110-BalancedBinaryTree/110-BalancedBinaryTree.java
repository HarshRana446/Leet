// Last updated: 7/28/2026, 1:17:39 PM
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
        return dfsHight(root) != -1;
    }
    int dfsHight(TreeNode root){
        if(root == null) return 0;

        int lh = dfsHight(root.left);
        if(lh == -1) return -1;
        int rh = dfsHight(root.right);
        if(rh == -1) return -1;

        if(Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh , rh) + 1;
    }
}