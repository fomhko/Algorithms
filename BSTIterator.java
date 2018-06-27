/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    public Stack<TreeNode> s = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        TreeNode temp = root;
        while(temp != null){
            s.push(temp);
            temp = temp.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(s.size() == 0){return false;}
        else return true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode ret = s.pop();
        TreeNode temp = ret;
        if(temp.right != null){
            temp = temp.right;
            while(temp != null){
                s.push(temp);
                temp = temp.left;
            }
        }
        return ret.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
