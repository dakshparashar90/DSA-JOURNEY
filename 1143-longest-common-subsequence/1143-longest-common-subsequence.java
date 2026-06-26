
class Solution {
    int dp[][];
    int solve(String s1,String s2,int i,int j){
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]= 1+solve(s1,s2,i-1,j-1);
        }


        int t1=solve(s1,s2,i-1,j);
        int t2=solve(s1,s2,i,j-1);

        return dp[i][j]= Math.max(t1,t2);

    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length()-1;
        int m=text2.length()-1;
        dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(text1,text2,n,m);
    }
}