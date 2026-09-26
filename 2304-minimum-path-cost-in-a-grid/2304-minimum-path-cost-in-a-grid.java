class Solution {

    int[][] dp;
    int n, m;

    public int solve(int[][] grid, int[][] moveCost, int i, int j) {

      
        if (i == n - 1) {
            return grid[i][j];
        }

       
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        
        for (int k = 0; k < m; k++) {

            int cost = grid[i][j] + 
                       moveCost[grid[i][j]][k] +
                       solve(grid, moveCost, i + 1, k);

            ans = Math.min(ans, cost);
        }

        return dp[i][j] = ans;
    }

    public int minPathCost(int[][] grid, int[][] moveCost) {

        n = grid.length;
        m = grid[0].length;

        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = Integer.MAX_VALUE;

      
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, solve(grid, moveCost, 0, j));
        }

        return ans;
    }
}