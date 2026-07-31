// Last updated: 7/31/2026, 4:27:01 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> track, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left != null) {
                track.put(cur.left, cur);
                q.offer(cur.left);
            }
            if (cur.right != null) {
                track.put(cur.right, cur);
                q.offer(cur.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> track = new HashMap<>();
        markParents(root, track, root);
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(target);
        vis.put(target, true);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(level == k) break;
            level++;
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur.left != null && vis.get(cur.left) == null){
                    q.offer(cur.left);
                    vis.put(cur.left, true);
                }
                if(cur.right != null && vis.get(cur.right) == null){
                    q.offer(cur.right);
                    vis.put(cur.right, true);
                }
                if(track.get(cur) != null && vis.get(track.get(cur)) == null){
                    q.offer(track.get(cur));
                    vis.put(track.get(cur), true);
                } 
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            res.add(cur.val);
        }
        return res;
    }
}