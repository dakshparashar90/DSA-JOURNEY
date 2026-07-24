class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>mpp=new HashMap<>();
        int sum=0;
        int i=0;
       
       while(i<nums.length){
            sum+=nums[i];
            int mod=sum%k;
            
            if(sum%k==0 &&  i>=1){
                return true;

            }
            else if(mpp.containsKey(mod)){
                    int vl=mpp.get(mod);
                    if(i-vl>=2){
                        return true;
                    }
            }
            else{
                mpp.put(mod,i);
            }

            i++;
        }
        return false;
    }
}