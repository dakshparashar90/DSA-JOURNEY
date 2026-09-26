class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if(obstacleGrid[n-1][m-1] == 1) return 0;

        int[][] dp = new int[n][m];
        dp[n-1][m-1] = 1;

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){

                if(i==n-1 && j==m-1) continue;

                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }

                int down = (i+1<n) ? dp[i+1][j] : 0;
                int right = (j+1<m) ? dp[i][j+1] : 0;

                dp[i][j] = down + right;
            }
        }

        return dp[0][0];
    }
}
