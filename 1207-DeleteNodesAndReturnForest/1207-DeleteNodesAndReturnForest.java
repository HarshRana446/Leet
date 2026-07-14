// Last updated: 7/14/2026, 2:49:37 PM
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode dfs(TreeNode root, HashSet<Integer> to_delete, List<TreeNode> forest) {
        if (root == null) {
            return null; // Base case for recursion
        }
        
        // Recursively process left and right children
        root.left = dfs(root.left, to_delete, forest);
        root.right = dfs(root.right, to_delete, forest);

        // If the current node needs to be deleted
        if (to_delete.contains(root.val)) {
            // If left child exists, add to forest
            if (root.left != null) {
                forest.add(root.left);
            }
            // If right child exists, add to forest
            if (root.right != null) {
                forest.add(root.right);
            }
            return null; // Deleting this node
        }
        
        return root; // Returning the current node if not deleted
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for (int to_be_del : to_delete) {
            set.add(to_be_del); // Convert to_delete array to a set for O(1) lookups
        }
        List<TreeNode> forest = new ArrayList<>();
        
        // Start DFS and handle the root separately
        if (dfs(root, set, forest) != null) {
            forest.add(root); // If the root is not deleted, add it to the forest
        }
        
        return forest; // Return the list of remaining tree roots
    }
}
