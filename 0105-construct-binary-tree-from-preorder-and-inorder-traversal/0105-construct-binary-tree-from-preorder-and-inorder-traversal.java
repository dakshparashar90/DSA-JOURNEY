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
    int ind;
    int find(int val,int[]in,int[]pr,int s,int e ){
      
     
        for(int j=s;j<=e;j++){
            if(in[j]==val){
                return j;
            }
        }
        return -1;
    }
    TreeNode solve(int[]pr,int[]in,int s,int e){
        if(s>e){
            return null;
        }
        
        int val=pr[ind++];
        int vl=find(val,in,pr, s, e);
        TreeNode tree=new TreeNode(val); 
           
       
        tree.left=solve(pr,in,s,vl-1);
        tree.right=solve(pr,in,vl+1,e);
        
        return tree;
    }
 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        ind=0;
      return solve(preorder,inorder,0,inorder.length-1);
    }
}