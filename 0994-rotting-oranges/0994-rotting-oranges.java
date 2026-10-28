class Pair{
    int row;
    int col;
    int ari;
    Pair(int r,int c,int a){
        this.row=r;
        this.col=c;
        this.ari=a;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int max=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int a=q.peek().ari;
            q.poll();
            if(c<m-1 && grid[r][c+1]==1 ){
                q.add(new Pair(r,c+1,a+1));
                grid[r][c+1]=2;
                max=Math.max(max,a+1);
            }
             if(c>0 && grid[r][c-1]==1){
                q.add(new Pair(r,c-1,a+1));
                 grid[r][c-1]=2;
                max=Math.max(max,a+1);
            }
             if(r<n-1 && grid[r+1][c]==1  ){
                q.add(new Pair(r+1,c,a+1));
                 grid[r+1][c]=2;
                max=Math.max(max,a+1);
            }
              if(r>0 && grid[r-1][c]==1 ){
                q.add(new Pair(r-1,c,a+1));
                 grid[r-1][c]=2;
                max=Math.max(max,a+1);
            }
            
        }
          for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return max;
    
    }
}