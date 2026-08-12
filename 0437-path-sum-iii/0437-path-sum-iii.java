class Solution {

    int targetSum;

    public int findPath(TreeNode root, long sum) {

        if (root == null) {
            return 0;
        }

        sum += root.val;

        int count = 0;

        if (sum == targetSum) {
            count++;
        }

        count += findPath(root.left, sum);
        count += findPath(root.right, sum);

        return count;
    }

    public int pathSum(TreeNode root, int targetSum) {

        this.targetSum = targetSum;

        if (root == null) {
            return 0;
        }

        return findPath(root, 0)
             + pathSum(root.left, targetSum)
             + pathSum(root.right, targetSum);
    }
}