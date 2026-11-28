
class Solution {
     int n;
        int m;
        int cnt;
    public void dfs(int[][] g, int r,int c){
        if(r<0 || c<0 ||r>=n || c>=m ||g[r][c]==0 ||g[r][c]==2){
            return;
        }
      g[r][c]=2;

         cnt++;
        dfs(g,r+1,c);
        dfs(g,r-1,c);
        dfs(g,r,c+1);
        dfs(g,r,c-1);
    }
     public int maxAreaOfIsland(int[][] grid) {
         n=grid.length;
         cnt=0;
        m=grid[0].length;
     
       int ans=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j);
                    ans=Math.max(cnt,ans);
                    cnt=0;
                }
            }
        }

        return ans;
    }
}