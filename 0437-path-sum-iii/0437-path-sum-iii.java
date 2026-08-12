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
    int targetSum;
    public int pathSum(TreeNode root, int targetSum) {

        
        this.targetSum=targetSum;
        HashMap<Long,Integer>map=new HashMap<>();
        map.put(0L,1);
        return dfs(root,0L,map);
        
        
    }

    public int dfs(TreeNode root,Long currSum , HashMap<Long,Integer>map){

        if(root==null){
            return 0;
        }

         currSum+=root.val;
        Long check=currSum-targetSum;
        int count =map.getOrDefault(check,0);

       map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        count+=dfs(root.left,currSum,map);
        count+=dfs(root.right,currSum,map);

       map.put(currSum, map.get(currSum) - 1);

        if (map.get(currSum) == 0) {
            map.remove(currSum);
        }

        return count;

    }

}


// class Solution {

//     int targetSum;

//     public int findPath(TreeNode root, long sum) {

//         if (root == null) {
//             return 0;
//         }

//         sum += root.val;

//         int count = 0;

//         if (sum == targetSum) {
//             count++;
//         }

//         count += findPath(root.left, sum);
//         count += findPath(root.right, sum);

//         return count;
//     }

//     public int pathSum(TreeNode root, int targetSum) {

//         this.targetSum = targetSum;

//         if (root == null) {
//             return 0;
//         }

//         return findPath(root, 0)
//              + pathSum(root.left, targetSum)
//              + pathSum(root.right, targetSum);
//     }
// }