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
    List<Double>ans;
    List<Integer>count;
    public List<Double> averageOfLevels(TreeNode root) {
        ans=new ArrayList<>();
        count=new ArrayList<>();

        solve(root,0);

        for(int i=0;i<ans.size();i++){
            ans.set(i,ans.get(i)/count.get(i));
        }

        return ans;
    }
    public void solve(TreeNode root,int cnt){
        if(root==null)return;

        if(cnt==ans.size()){
            ans.add((double) root.val);
            count.add(1);
        }
        else{
            ans.set(cnt,ans.get(cnt)+root.val);
            count.set(cnt,count.get(cnt)+1);
        }

        solve(root.left,cnt+1);
        solve(root.right,cnt+1);
    }
}