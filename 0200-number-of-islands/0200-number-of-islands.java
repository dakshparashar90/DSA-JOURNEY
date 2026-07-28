class Pair{
   int row;
   int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        boolean v[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='0')continue;
                if(!v[i][j]){
                    count++;
                    dfs(v,grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(boolean v[][], char grid[][],int i,int j){
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(i,j));
        v[i][j]=true;
        int n=grid.length;
        int m=grid[0].length;
        int delr[]={-1,1,0,0};
        int delc[]={0,0,-1,1};
        while(!q.isEmpty()){
            Pair check=q.poll();
            int row=check.row;
            int col=check.col;
            for(int k=0;k<4;k++){
               
                    int r=row+delr[k];
                    int c=col+delc[k];
                    if(r>=0 && r<n && c>=0 && c<m && !v[r][c] && grid[r][c]=='1'){
                          v[r][c]=true;
                        q.add(new Pair(r,c));
                    }
                
            }


        }
    }
}