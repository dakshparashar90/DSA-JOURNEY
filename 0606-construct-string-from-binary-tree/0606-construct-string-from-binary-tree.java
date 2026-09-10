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
   
       String st;
    public void solve(TreeNode root){
        if(root == null )return;

        st+="(";
        st+=root.val;


        solve(root.left);
        if(root.right!=null && root.left==null){
            st+="()";
        }
        solve(root.right);
        st+=")";

    }
    public String tree2str(TreeNode root) {
       st="";
      
       
     solve(root);

     int len=st.length();
     return st.substring(1,len-1);
    }
}