// Last updated: 8/5/2026, 2:15:53 PM
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
public class BST {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    boolean reverse = true;

    public BST(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    public int next() {
        TreeNode tmp = stack.pop();
        if (reverse == false)
            pushAll(tmp.right);
        else
            pushAll(tmp.left);
        return tmp.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            if (reverse == true) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BST l = new BST(root, false);
        BST r = new BST(root, true);
        
        int i = l.next();
        int j = r.next();

        while(i < j){
            if(i + j == k) return true;
            else if(i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}