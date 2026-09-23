class Solution {
    int dp[][];
    public int solve(String s,int i,int j){
        if(i>j){
            return 0;
        }
        if(i==j){
            return dp[i][j]= 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]= 2+solve(s,i+1,j-1);
        }

        return dp[i][j]= Math.max(solve(s,i+1,j),solve(s,i,j-1));
    }
    public int longestPalindromeSubseq(String s) {
        dp=new int[s.length()+1][s.length()+1];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s,0,s.length()-1);
    }
}