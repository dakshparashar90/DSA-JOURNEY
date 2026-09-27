class Solution {

    public int minPathCost(int[][] grid, int[][] moveCost) {
     
         int n = grid.length;
        int m = grid[0].length;
        int[][] dp= new int[n][m];

        
        
      

      
       for(int j=0;j<m;j++){
            dp[n-1][j]=grid[n-1][j];
       }

        for(int i=n-2;i>=0;i--){
           for(int j=0;j<m;j++){
            int ans2=Integer.MAX_VALUE;

            for (int k = 0; k < m; k++) {

                    int cost= grid[i][j] + 
                       moveCost[grid[i][j]][k]+
                      dp[i+1][k];

                     ans2 = Math.min(ans2, cost);
            }
           dp[i][j]=ans2;
           }
        }

         int ans = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[0][j]);
        }

 
        return ans;
    }
}