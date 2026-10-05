class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1)return s;


        int start=0;
        int end=0;

        for(int i=0;i<s.length();i++){
            int len1=check(i,i,s);
            int len2=check(i,i+1,s);

            int max=Math.max(len1,len2);

            if(max>end-start){
                start=i-(max-1)/2;
                end=i+(max/2);
            }


        }
        return s.substring(start,end+1);
    }
    

    public int check(int left,int right,String s){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;

        }

        return right-left-1;
    }
}