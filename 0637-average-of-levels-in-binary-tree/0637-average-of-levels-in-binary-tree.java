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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode>qq=new LinkedList<>();
        List<Double>res=new ArrayList<>();
        qq.add(root);
        while(!qq.isEmpty()){

           int size=qq.size();
            Double ans=0.0;

            for(int i=0;i<size;i++){
                TreeNode node=qq.poll();
                ans+=node.val;

                if(node.left!=null){
                    qq.add(node.left);
                }
                if(node.right!=null){
                    qq.add(node.right);
                }
            }
            ans=ans/size;
            res.add(ans);


            
        }

        return res;
    }
}