class Solution {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[] next = new int[n];

        for(int j=0;j<n;j++){
            next[j] = matrix[n-1][j];
        }

        for(int i=n-2;i>=0;i--){

            int[] curr = new int[n];

            for(int j=0;j<n;j++){

                int down = next[j];

                int dgL = (j > 0)
                        ? next[j-1]
                        : Integer.MAX_VALUE;

                int dgR = (j < n-1)
                        ? next[j+1]
                        : Integer.MAX_VALUE;

                curr[j] = matrix[i][j]
                        + Math.min(down,
                          Math.min(dgL,dgR));
            }

            next = curr;
        }

        int ans = Integer.MAX_VALUE;

        for(int j=0;j<n;j++){
            ans = Math.min(ans,next[j]);
        }

        return ans;
    }
}




//tabulation

// class Solution {
//     public int minFallingPathSum(int[][] matrix) {

//         int n = matrix.length;

//         int[][] dp = new int[n][n];

//         for(int j = 0; j < n; j++) {
//             dp[n - 1][j] = matrix[n - 1][j];
//         }

//         for(int i = n - 2; i >= 0; i--) {

//             for(int j = 0; j < n; j++) {

//                 int down = dp[i + 1][j];

//                 int leftDiag = (j > 0)
//                         ? dp[i + 1][j - 1]
//                         : Integer.MAX_VALUE;

//                 int rightDiag = (j < n - 1)
//                         ? dp[i + 1][j + 1]
//                         : Integer.MAX_VALUE;

//                 dp[i][j] = matrix[i][j]
//                          + Math.min(down,
//                            Math.min(leftDiag, rightDiag));
//             }
//         }

//         int ans = Integer.MAX_VALUE;

//         for(int j = 0; j < n; j++) {
//             ans = Math.min(ans, dp[0][j]);
//         }

//         return ans;
//     }
// }



//memo

// class Solution {
//     int dp[][];
//     public int solve(int matrix[][],int i,int j){
//         int n=matrix.length;
//         if(i>=n || j<0|| j>=n)return Integer.MAX_VALUE;
//         if(i==n-1){
//             return matrix[i][j];
//         }
//         if(dp[i][j]!=-1)return dp[i][j];

//         int dgR=solve(matrix,i+1,j+1);
//         int dgL=solve(matrix,i+1,j-1);
//         int dw=solve(matrix,i+1,j);

//         return dp[i][j]=matrix[i][j]+Math.min(dgR,Math.min(dw,dgL));
//     }
//     public int minFallingPathSum(int[][] matrix) {
//         int n=matrix.length;
//         dp=new int[n][n];
//         for(int i=0;i<n;i++){
//             Arrays.fill(dp[i],-1);

//         }
//         int ans=Integer.MAX_VALUE;
//         for(int j=0;j<n;j++){
//             ans = Math.min(ans, solve(matrix,0,j));
//         }
//         return ans;
//     }
// }