class Solution {
     int n;
        int m;
    public void dfs(char[][] g,boolean v[][], int r,int c){
        if(r<0 || c<0 ||r>=n || c>=m || v[r][c]||g[r][c]=='0'){
            return;
        }
        v[r][c]=true;

        dfs(g,v,r+1,c);
        dfs(g,v,r-1,c);
        dfs(g,v,r,c+1);
        dfs(g,v,r,c-1);
    }
    public int numIslands(char[][] grid) {
         n=grid.length;
        m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]!=true){
                    dfs(grid,vis,i,j);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}