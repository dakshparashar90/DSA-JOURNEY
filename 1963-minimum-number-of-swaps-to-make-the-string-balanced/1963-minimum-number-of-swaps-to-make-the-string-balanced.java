class Solution {
    public int minSwaps(String s) {
        int bal=0;
        int maxInbal=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                bal++;
            }
            else{
                bal--;
            }

            maxInbal=Math.min(maxInbal,bal);
        }
        return (Math.abs(maxInbal)+1)/2;
    }
}