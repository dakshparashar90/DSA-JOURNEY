class Solution {
     int n;
        int m;
    public void dfs(char[][] g, int r,int c){
        if(r<0 || c<0 ||r>=n || c>=m ||g[r][c]=='2'||g[r][c]=='0'){
            return;
        }
       g[r][c]='2';
        dfs(g,r+1,c);
        dfs(g,r-1,c);
        dfs(g,r,c+1);
        dfs(g,r,c-1);
    }
    public int numIslands(char[][] grid) {
         n=grid.length;
        m=grid[0].length;
     
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}