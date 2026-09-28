class Solution {
   
    public int calculateMinimumHP(int[][] dungeon) {

    int n=  dungeon.length;
    int m= dungeon[0].length;
    int dp[][]=   new int[n][m];
      

      for(int i=m-1;i>=0;i--){
        dp[n-1][i]=i==m-1?Math.max(1,1-dungeon[n-1][i]):Math.max(1,dp[n-1][i+1]-dungeon[n-1][i]);
      }
      
      for(int i=n-2;i>=0;i--){
        for(int j=m-1;j>=0;j--){
            int d=dp[i+1][j];
            int r=j<m-1?dp[i][j+1]:Integer.MAX_VALUE;

                int need=Math.min(d,r);
              dp[i][j] = Math.max(1, need - dungeon[i][j]);  

        }
      }

     
        return dp[0][0];

        
    }
}