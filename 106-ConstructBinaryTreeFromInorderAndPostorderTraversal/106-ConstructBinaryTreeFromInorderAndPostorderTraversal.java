// Last updated: 8/1/2026, 4:31:28 PM
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = buildTreePost(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
        return root;
    }

    public TreeNode buildTreePost(int[] inorder, int inS, int inE, int[] postorder, int postS, int postE,
            Map<Integer, Integer> map) {
        if (postS > postE || inS > inE)
            return null;

        TreeNode root = new TreeNode(postorder[postE]);
        int inRoot = map.get(postorder[postE]);
        int numLeft = inRoot - inS;

        root.left = buildTreePost(inorder, inS, inRoot - 1, postorder, postS, postS + numLeft - 1, map);
        root.right = buildTreePost(inorder, inRoot + 1, inE, postorder, postS + numLeft, postE - 1, map);

        return root;
    }
}