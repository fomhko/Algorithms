/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import javafx.util.Pair;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){return "";}
        int depth = 0;
        Stack<Pair<TreeNode,Integer>> s = new Stack<Pair<TreeNode,Integer>>();
        s.push(new Pair<TreeNode,Integer>(root,0));
        while(!s.isEmpty()){
            Pair<TreeNode,Integer> temp = s.pop();
            depth = Math.max(depth,temp.getValue());
            if(temp.getKey().left != null){
                s.push(new Pair<TreeNode,Integer>(temp.getKey().left,temp.getValue()+1));
            }
            if(temp.getKey().right != null){
                s.push(new Pair<TreeNode,Integer>(temp.getKey().right,temp.getValue()+1));
            }
        }
        char[] result = new char[(int)Math.pow(2,depth+1)];
        // System.out.println((int)Math.pow(2,depth+1));

        for(int i = 0; i < result.length;i++){result[i] = '!';}

        s.push(new Pair<TreeNode,Integer>(root,1));
        while(!s.isEmpty()){
            Pair<TreeNode,Integer> temp = s.pop();
            result[temp.getValue()] = (char)(temp.getKey().val + '0');

            if(temp.getKey().left != null){
                s.push(new Pair<TreeNode,Integer>(temp.getKey().left,temp.getValue()*2));
            }
            if(temp.getKey().right != null){
                s.push(new Pair<TreeNode,Integer>(temp.getKey().right,temp.getValue()*2+1));
            }
        }
        String result_str = new String(result);

        return result_str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){return null;}
        TreeNode root = new TreeNode((int)(data.charAt(1) - '0'));
        helper(data,root,1);
        return root;
    }
    public void helper(String data,TreeNode root, int index){

            int left = index * 2;

            if(left < data.length() && data.charAt(left) != '!'){
                // System.out.println(left + " " + data.length());
                root.left = new TreeNode((int)(data.charAt(left) - '0'));
                helper(data,root.left,left);
            }
            int right = index * 2+1;
            if(right < data.length() && data.charAt(right) != '!'){
                root.right = new TreeNode((int)(data.charAt(right) - '0'));
                helper(data,root.right,right);
            }
        }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
