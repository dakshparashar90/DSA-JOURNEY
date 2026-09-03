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
class Solution { // Optimal Approach 
    public int index = 0;
    Map <Integer,Integer> map = new HashMap<>();
    public TreeNode build(int start , int end,int [] preorder)
    {
        if(start>end)
        return null;
        TreeNode root = new TreeNode (preorder[index]);
        int rootPositionInInorder = map.get(preorder[index]);
        index++;
        root.left = build(start,rootPositionInInorder-1,preorder);
        root.right = build(rootPositionInInorder+1,end,preorder);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder ) {
        index = 0;
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        map.put(inorder[i],i);
        TreeNode root = build(0,preorder.length-1,preorder);
        return root;
    }
}