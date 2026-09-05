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
    static int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        idx = n - 1; 
        return func(inorder, postorder, 0, n - 1);
    }

    public static TreeNode func(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) return null;

        int rootVal = postorder[idx--]; 
        TreeNode root = new TreeNode(rootVal);

       
        int i;
        for (i = start; i <= end; i++) {
            if (inorder[i] == rootVal) break;
        }

       
        root.right = func(inorder, postorder, i + 1, end);
        root.left = func(inorder, postorder, start, i - 1);

        return root;
    }
}