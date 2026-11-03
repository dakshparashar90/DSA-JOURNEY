class Solution {
      int n;
        int m;
    public void solve(char grid[][],int r,int c,boolean vist[][]){
        if(r<0 || c<0 | r>=n || c>=m || vist[r][c] || grid[r][c]=='0'){
            return;
        }

        vist[r][c]=true;

        solve(grid,r,c+1,vist);
         solve(grid,r,c-1,vist);
          solve(grid,r+1,c,vist);
           solve(grid,r-1,c,vist);
    }
    public int numIslands(char[][] grid) {
        
         n=grid.length;
         m=grid[0].length;
        boolean vist[][]=new boolean[n][m];
        int step=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vist[i][j]){
                    solve(grid,i,j,vist);
                    step++;
                }
            }
        }
    return step;
    }
}