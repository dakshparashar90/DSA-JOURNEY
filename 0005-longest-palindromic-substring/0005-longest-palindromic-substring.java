class Solution {

    Boolean[][] dp;
    String ans = "";

    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new Boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(String s, int i, int j) {

        if (i >= j) {
            return true;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) != s.charAt(j)) {
            return dp[i][j] = false;
        }

        return dp[i][j] = isPalindrome(s, i + 1, j - 1);
    }
}