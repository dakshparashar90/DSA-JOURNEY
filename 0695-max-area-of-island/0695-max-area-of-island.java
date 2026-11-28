
class Solution {
     int n;
        int m;
        int cnt;
    public void dfs(int[][] g,boolean v[][], int r,int c){
        if(r<0 || c<0 ||r>=n || c>=m || v[r][c]||g[r][c]==0){
            return;
        }
        v[r][c]=true;

         cnt++;
        dfs(g,v,r+1,c);
        dfs(g,v,r-1,c);
        dfs(g,v,r,c+1);
        dfs(g,v,r,c-1);
    }
     public int maxAreaOfIsland(int[][] grid) {
         n=grid.length;
         cnt=0;
        m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
       int ans=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]!=true){
                    dfs(grid,vis,i,j);
                    ans=Math.max(cnt,ans);
                    cnt=0;
                }
            }
        }

        return ans;
    }
}