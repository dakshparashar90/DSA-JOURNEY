class Solution {
    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = n - 2; i >= 0; i--) {

            int prev = 0;

            for (int j = i + 1; j < n; j++) {

                int temp = dp[j];

                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = 2 + prev;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                prev = temp;
            }
        }

        return dp[n - 1];
    }
}