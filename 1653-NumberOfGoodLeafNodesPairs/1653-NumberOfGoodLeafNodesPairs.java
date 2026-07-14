// Last updated: 7/14/2026, 2:49:20 PM
// TreeNode definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    private int result = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return result;
    }

    private int[] dfs(TreeNode node, int distance) {
        if (node == null) {
            return new int[distance + 1];
        }

        if (node.left == null && node.right == null) {
            int[] leaves = new int[distance + 1];
            leaves[1] = 1;
            return leaves;
        }

        int[] leftLeaves = dfs(node.left, distance);
        int[] rightLeaves = dfs(node.right, distance);

        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance - i; j++) {
                result += leftLeaves[i] * rightLeaves[j];
            }
        }

        int[] currentLeaves = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            currentLeaves[i + 1] = leftLeaves[i] + rightLeaves[i];
        }

        return currentLeaves;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        int distance = 3;
        int result = solution.countPairs(root, distance);
        System.out.println("Number of good leaf node pairs: " + result); // Output: 1
    }
}
