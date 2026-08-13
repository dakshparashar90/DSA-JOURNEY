class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length-1;
        if(nums.length==1)return nums[0];
        if(nums[0]!=nums[1])return nums[0];
        if(nums[n]!=nums[n-1])return nums[n];

        int low=1;
        int high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }

            if(nums[mid]==nums[mid+1] && (n-mid+1)%2==0){
                high=mid-1;
            }
            else if(nums[mid]==nums[mid-1] && (n-mid)%2==0){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return -1;
    }
}