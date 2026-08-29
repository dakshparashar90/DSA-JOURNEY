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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        Queue<TreeNode>qq=new LinkedList<>();
       
        qq.add(root);
        while(!qq.isEmpty()){
            TreeNode curr=qq.poll();
            int v=curr.val;
            if(v>val){
                if(curr.left==null){
                    curr.left=new TreeNode(val);
                    return root;
                }
                qq.add(curr.left);
            }
            else{
                   if(curr.right==null){
                    curr.right=new TreeNode(val);
                    return root;
                }
                qq.add(curr.right);
            }
        }
        return root;

    }

}