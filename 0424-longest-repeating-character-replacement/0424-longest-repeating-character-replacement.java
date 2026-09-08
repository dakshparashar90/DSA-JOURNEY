class Solution {
    public int characterReplacement(String s, int k) {
        int arr[]=new int[26];
        int maxFreq=Integer.MIN_VALUE;
        int ans=Integer.MIN_VALUE;
        int i=0;
        int j=0;
        while(i<s.length()){

            char ch=s.charAt(i);
            arr[ch-'A']++;
            maxFreq=Math.max(maxFreq,arr[ch-'A']);
            if((i-j+1)-maxFreq>k){
                arr[s.charAt(j)-'A']--;
                maxFreq=0;
                j++;
            }
            ans=Math.max(ans,i-j+1);
            i++;

        }
    return ans;
    }
}