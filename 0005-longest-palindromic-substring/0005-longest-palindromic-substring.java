class Solution {

    public String longestPalindrome(String s) {
        int n=s.length();
        if (n <= 1)
            return s;
        boolean dp[][]=new boolean[n][n];
        int max=1;
        int start=0;

        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }

        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(len==2){
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=dp[i+1][j-1];
                    }

                    if(dp[i][j] && len>max){
                        max=len;
                        start=i;
                    }
                }

            }
        }
        return s.substring(start,start+max);
    }
}