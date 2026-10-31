
class Solution {
    int n;
    int m;
    int cnt = 0;

    public void solve(char[][] board, int i, int j, boolean[][] vis) {

        if (i < 0 || j < 0 || i >= n || j >= m ||
            board[i][j] == '.' || vis[i][j]) {
            return;
        }

        vis[i][j] = true;

        solve(board, i + 1, j, vis);
        solve(board, i - 1, j, vis);
        solve(board, i, j + 1, vis);
        solve(board, i, j - 1, vis);
    }

    public int countBattleships(char[][] board) {

        n = board.length;
        m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'X' && !vis[i][j]) {

                    cnt++;
                    solve(board, i, j, vis);
                }
            }
        }

        return cnt;
    }
}
