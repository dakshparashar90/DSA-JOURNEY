class Solution {
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];

        int dir[][] = {
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(grid[i][j] == '1' && !vis[i][j]) {

                    cnt++;

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    vis[i][j] = true;

                    while(!q.isEmpty()) {

                        int arr[] = q.poll();

                        for(int it[] : dir) {

                            int r = arr[0] + it[0];
                            int c = arr[1] + it[1];

                            if(r < 0 || c < 0 || r >= n || c >= m)
                                continue;

                            if(grid[r][c] == '1' && !vis[r][c]) {

                                vis[r][c] = true;
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }
}