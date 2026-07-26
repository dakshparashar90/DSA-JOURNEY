class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128]; 
        int i = 0, j = 0;
        int maxLen = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            freq[ch]++;
           while (freq[ch] > 1) {
                char leftChar = s.charAt(j);
                freq[leftChar]--;
                j++;
            }   
            maxLen = Math.max(maxLen, i-j+1);
            i++;
        }

        return maxLen;
    }
}