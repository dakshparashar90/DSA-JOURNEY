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
    public int maxDepth(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int cnt){
        if(root==null){
            return cnt;
        }
       
        int max1=dfs(root.left,cnt+1);
        int max2=dfs(root.right,cnt+1);


        return Math.max(max1,max2);
    }
}