class Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= m; j++){

                if(text1.charAt(i - 1) == text2.charAt(j - 1)){

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                }
                else{

                    dp[i][j] = Math.max(dp[i - 1][j],
                                        dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}


// class Solution {
//      int dp[][];
//     public int solve(String text1,String text2,int i,int j){
//          if(i<0 || j<0){
//             return 0;
//         }

//         if(dp[i][j]!=-1){
//             return dp[i][j];
//         }

//         if(text1.charAt(i)==text2.charAt(j)){
//             return dp[i][j]= 1+solve(text1,text2,i-1,j-1);
//         }
        
//         int t1=solve(text1,text2,i-1,j);
//         int t2=solve(text1,text2,i,j-1);

//         return dp[i][j]= Math.max(t1,t2);

//     }
   
//     public int longestCommonSubsequence(String text1, String text2) {
        
//                dp=new int[text1.length()][text2.length()];
//                for(int i=0;i<text1.length();i++){
//                 Arrays.fill(dp[i],-1);
//                }

//             return solve(text1,text2,text1.length()-1,text2.length()-1);
//     }
// }