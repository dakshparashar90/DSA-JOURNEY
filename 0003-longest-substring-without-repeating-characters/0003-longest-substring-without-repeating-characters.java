class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128]; // For all ASCII characters
        int i = 0, j = 0;
        int maxLen = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);
            freq[ch]++;

            // If duplicate, shrink window from left until valid
            while (freq[ch] > 1) {
                char leftChar = s.charAt(j);
                freq[leftChar]--;
                j++;
            }

            // Update max length of valid window
            maxLen = Math.max(maxLen, i - j + 1);
            i++;
        }

        return maxLen;
    }
}
