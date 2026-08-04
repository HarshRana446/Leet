// Last updated: 8/4/2026, 12:47:19 PM
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
    private int k;
    private int result;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.result = -1;
        inorder(root);
        return result;
    }
    void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            if (--k == 0) {
                result = node.val;
                return;
            }
            inorder(node.right);
        }
    }
}