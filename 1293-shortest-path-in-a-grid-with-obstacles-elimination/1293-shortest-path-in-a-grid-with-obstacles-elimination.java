class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        boolean dup[][][]=new boolean[n][m][k+1];

        Queue<int[]>qq=new LinkedList<>();

        qq.offer(new int[]{0,0,k});

        dup[0][0][k]=true;

        int step=0;

         int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        while(!qq.isEmpty()){

            int size=qq.size();
            while(size-- >0){
                int curr[]=qq.poll();

                int r=curr[0];
                int c=curr[1];
                int rem=curr[2];

                 if (r == n - 1 && c == m - 1) {
                    return step;
                }

              

                for(int it[]:directions){

                        int rr=r+it[0];
                        int cc=c+it[1];

                        if(rr<0 || rr>=n || cc<0 || cc>=m){
                            continue;
                        }


                    
                    int newR=rem-grid[rr][cc];
                    if(newR<0){
                        continue;
                    }

                    if(!dup[rr][cc][newR]){
                        dup[rr][cc][newR]=true;

                        qq.offer(new int[]{rr,cc,newR});
                    }

                }

                

                
            }
            step++;

        }

        return -1;
    }
}