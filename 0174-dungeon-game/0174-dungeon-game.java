class Solution {
    int dp[][];
    int n;
    int m;

    public int solve(int[][] dungeon,int i, int j){
        if(i>=n || j>=m ){
            return Integer.MAX_VALUE;
        }

        if (i == n - 1 && j == m - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

      

       int d= solve(dungeon,i+1,j);
       int r= solve(dungeon,i,j+1);

       int need=Math.min(d,r);

       dp[i][j] = Math.max(1, need - dungeon[i][j]);  

        return dp[i][j];
    }
    public int calculateMinimumHP(int[][] dungeon) {
        n=dungeon.length;
        m=dungeon[0].length;

        dp = new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

      return  solve(dungeon,0,0);

        
    }
}