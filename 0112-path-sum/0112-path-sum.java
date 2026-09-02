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
    public boolean solve(TreeNode root,int targetSum,int sum){

        if(root==null)return false;

       if(root.right==null && root.left==null){
        sum+=root.val;
        if(sum==targetSum)return true;


        return false;
       }
        

    int newSum=sum+root.val;

        boolean left= solve(root.left,targetSum,newSum);
        boolean right=solve(root.right,targetSum,newSum);

        return left || right;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root,targetSum,0);
    }
}