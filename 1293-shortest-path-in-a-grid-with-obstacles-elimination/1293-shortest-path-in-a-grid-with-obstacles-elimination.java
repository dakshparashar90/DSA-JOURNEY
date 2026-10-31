class Solution {

    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

       
        if (k >= m + n - 2) {
            return m + n - 2;
        }

       
        boolean[][][] visited =
            new boolean[m][n][k + 1];

        Queue<int[]> q = new LinkedList<>();

       
        q.offer(new int[]{0, 0, k});

        visited[0][0][k] = true;

        int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];
                int remain = curr[2];

               
                if (r == m - 1 && c == n - 1) {
                    return steps;
                }

                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nc < 0 ||
                        nr >= m || nc >= n) {
                        continue;
                    }

                    int newRemain =
                        remain - grid[nr][nc];

                    if (newRemain < 0) {
                        continue;
                    }

                    if (!visited[nr][nc][newRemain]) {

                        visited[nr][nc][newRemain] = true;

                        q.offer(new int[]{
                            nr, nc, newRemain
                        });
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}