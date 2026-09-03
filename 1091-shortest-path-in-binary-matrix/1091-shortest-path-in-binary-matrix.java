class Pair{
    int dis;
    int r;
    int c;
    Pair(int dis,int r,int c){
        this.dis=dis;
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
                return -1;
            }
        int dup[][]=new int[n][m];
       for(int i=0;i<n;i++){
        Arrays.fill(dup[i], Integer.MAX_VALUE);
       }
          dup[0][0]=1;
        Queue<Pair>pq=new LinkedList<>();
        pq.add(new Pair(1,0,0));
         int[][] dir = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},       {0,1},
            {1,-1},{1,0},{1,1}
        };
        
        while(!pq.isEmpty()){
            int dis=pq.peek().dis;
            int row=pq.peek().r;
            int col=pq.peek().c;

            pq.poll();

            for(int it[]:dir){
                int rr=row+it[0];
                int cc=col+it[1];
                if(rr>=0 && rr<n && cc>=0 && cc<n && grid[rr][cc]!=1){
                    if(dup[rr][cc]>dis+1){

                    dup[rr][cc]=dis+1;
                    pq.add(new Pair(dis+1,rr,cc));
                    }
                }
                

            }
        }
      return dup[n-1][n-1] == Integer.MAX_VALUE ? -1 : dup[n-1][n-1];

    }
}