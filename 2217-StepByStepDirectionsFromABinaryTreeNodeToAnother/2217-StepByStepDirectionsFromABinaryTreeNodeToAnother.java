// Last updated: 7/14/2026, 2:49:02 PM
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
    public TreeNode LCA(TreeNode root,int p, int q){
        if(root == null || root.val == p || root.val == q){
            return root;
        }
        TreeNode left = LCA(root.left,p,q);
        TreeNode right = LCA(root.right,p,q);
        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else{
            return root;
        }
    }
    public boolean findPath(TreeNode root, int target, StringBuilder path){
       if(root == null){
        return false;
       }
       if(root.val == target){
        return true;
       }
       path.append("L");
       if(findPath(root.left,target,path)){
            return true;
       }
       path.setLength(path.length()-1);

       path.append("R");
       if(findPath(root.right,target,path)){
            return true;
       }
       path.setLength(path.length()-1);

       return false;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = LCA(root, startValue, destValue);
        StringBuilder sourceToLCA = new StringBuilder();
        StringBuilder LCAToDest = new StringBuilder();
        findPath(lca, startValue, sourceToLCA);
        findPath(lca, destValue, LCAToDest);
        StringBuilder res = new StringBuilder();
        for(int i=0;i<sourceToLCA.length();i++){
            res.append("U");
        }
        res.append(LCAToDest);
        return res.toString();
      }
}