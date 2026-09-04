class Solution {

    int n;
    int total;

    public int[][] solve(int[][] board, int[][] dup, int cell, int cnt) {

       
       
     
        if (cnt >= dup[0][cell]) {
            return dup;
        }

        dup[0][cell] = cnt;

         if (cell == total) {
            return dup;
        }


     
        for (int k = 1; k <= 6; k++) {

            int nextCell = cell + k;

            if (nextCell > total) {
                break;
            }

          
            int[] pos = getPosition(nextCell);

            int row = pos[0];
            int col = pos[1];

        
            if (board[row][col] != -1) {
                nextCell = board[row][col];
            }

            solve(board, dup, nextCell, cnt + 1);
        }

        return dup;
    }

   
    public int[] getPosition(int cell) {

        int row = n - 1 - (cell - 1) / n;

        int col = (cell - 1) % n;

       
        if ((n - row) % 2 == 0) {
            col = n - 1 - col;
        }

        return new int[]{row, col};
    }

    public int snakesAndLadders(int[][] board) {

        n = board.length;
        total = n * n;

     
        int[][] dup = new int[1][total + 1];

        Arrays.fill(dup[0], Integer.MAX_VALUE);

        solve(board, dup, 1, 0);

        return dup[0][total] == Integer.MAX_VALUE
                ? -1
                : dup[0][total];
    }
}