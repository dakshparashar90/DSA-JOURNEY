class Solution {

    public int minPathCost(int[][] grid, int[][] moveCost) {
     
         int n = grid.length;
        int m = grid[0].length;
        int[] dp= new int[m];

        
        
      

      
       for(int j=0;j<m;j++){
            dp[j]=grid[n-1][j];
       }

        for(int i=n-2;i>=0;i--){
            int prev[]=new int[m];
           for(int j=0;j<m;j++){
            int ans2=Integer.MAX_VALUE;

            for (int k = 0; k < m; k++) {

                    int cost= grid[i][j] + 
                       moveCost[grid[i][j]][k]+
                      dp[k];

                     ans2 = Math.min(ans2, cost);
            }
            prev[j]=ans2;
        
           }
           dp=prev;
        }

         int ans = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[j]);
        }

 
        return ans;
    }
}