class Solution {
    public int[] productExceptSelf(int[] nums) {
     int prefix=1;
     int n=nums.length;
     int ans[]=new int[n];
    ans[0]=1;
     for(int i=1;i<n;i++){
        ans[i]=ans[i-1]*nums[i-1];
     }
     int sufix=1;
     for(int i=n-2;i>=0;i--){
        sufix*=nums[i+1];
        ans[i]*=sufix;
     }
     return ans;
    }
}