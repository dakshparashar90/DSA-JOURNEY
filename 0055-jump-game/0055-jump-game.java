class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }

       
        int maxi=0;

        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]==0 && maxi<=i){
                    return false;
            }

            if(maxi<=i+nums[i]){
              
                maxi=nums[i]+i;
            }
        }  
        return true;
    }
}