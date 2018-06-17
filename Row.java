/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> v = new ArrayList<Integer>();
        if(root == null) return v;
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while(size > 0){
                size--;
                TreeNode n = q.poll();
                max = Math.max(max,n.val);
                if(n.left != null)
                    q.offer(n.left);
                if(n.right != null)
                    q.offer(n.right);
            }
            v.add(max);
        }
        return v;
    }
}
