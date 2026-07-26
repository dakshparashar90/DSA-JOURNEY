//expand round center approch

class Solution {
    public String longestPalindrome(String s) {
     if(s==null || s.length()<1) return "";

        int start=0,end=0;

        for(int i=0;i<s.length();i++){
            int len1 = expand(i,i,s);     
            int len2 = expand(i,i+1,s); 

            int max=Math.max(len1,len2);

            if(max>end-start){
                start=i-(max-1)/2;
                end=i+(max/2);
            }
        }
        return s.substring(start,end+1);

    }
    public int expand(int left,int right,String s){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        return right-left-1;
    }
}