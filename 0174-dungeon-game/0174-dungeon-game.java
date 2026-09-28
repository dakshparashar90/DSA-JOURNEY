class Solution {
   
    public int calculateMinimumHP(int[][] dungeon) {

    int n=  dungeon.length;
    int m= dungeon[0].length;
    int dp[]=   new int[m];
      

      for(int i=m-1;i>=0;i--){
        dp[i]=i==m-1?Math.max(1,1-dungeon[n-1][i]):Math.max(1,dp[i+1]-dungeon[n-1][i]);
      }
      
      for(int i=n-2;i>=0;i--){
        for(int j=m-1;j>=0;j--){
       
            int d=dp[j];
            int r=j<m-1?dp[j+1]:Integer.MAX_VALUE;

                int need=Math.min(d,r);
             dp[j] = Math.max(1, need - dungeon[i][j]);  

        }
     
      }  
        return dp[0]; 
    }
}