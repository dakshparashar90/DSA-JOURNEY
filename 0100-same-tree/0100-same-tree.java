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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q,false);
    }
    public boolean dfs(TreeNode p,TreeNode q ,boolean tick){
       if(q==null && p!=null || p==null && q!=null)return false;
       if(q!=null && p!=null &&q.val!=p.val)return false;
       if(q==null && p==null) return true;

        boolean check=dfs(p.right,q.right,true);
        boolean check2=dfs(p.left,q.left,true);

        return check && check2;


    }
}