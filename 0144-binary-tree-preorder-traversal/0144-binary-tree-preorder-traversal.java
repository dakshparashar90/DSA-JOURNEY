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
    public void help(TreeNode x , List<Integer>al){
        if(x == null){
            return;
        }
        al.add(x.val);
        help(x.left,al);
        help(x.right,al);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode c = root ;
        ArrayList<Integer> al = new ArrayList<>();
        help(c,al);
        return al;
    }
}