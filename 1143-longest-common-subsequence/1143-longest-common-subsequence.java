class Solution {
    int dp[][];
    public int solve(String t1,String t2,int i,int j){
        if(i<0 || j<0)return 0;

        if(dp[i][j]!=-1)return dp[i][j];

        if(t1.charAt(i)==t2.charAt(j)){
          return  dp[i][j]=1+solve(t1,t2,i-1,j-1);
        }

        int ans1=solve(t1,t2,i,j-1);
        int ans2=solve(t1,t2,i-1,j);

        return dp[i][j]=Math.max(ans1,ans2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(text1,text2,n-1,m-1);

    }

}