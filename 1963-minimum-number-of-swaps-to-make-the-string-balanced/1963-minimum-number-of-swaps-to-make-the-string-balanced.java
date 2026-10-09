class Solution {
    public int minSwaps(String s) {
        int bal=0;
       

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                bal++;
            }
            else if(bal!=0){
                bal--;
            }

           
        }
        return (bal+1)/2;
    }
}