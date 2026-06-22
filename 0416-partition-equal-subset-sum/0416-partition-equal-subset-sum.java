class Solution {
    public boolean canPartition(int[] nums) {
  
        int sum = 0;
      
      for(int x : nums){
            sum += x;
        }
       
        if(sum % 2 != 0){
            return false;
        }
        boolean dp[]=new boolean[(sum/2)+1];
            dp[0]=true;

        if(nums[0]<=sum/2){

            dp[nums[0]]=true;
        }

        for(int i=1;i<nums.length;i++){
            for(int target=sum/2;target>=nums[i];target--){

                dp[target]=dp[target] || dp[target-nums[i]];    
            
            }
       }

        

       return dp[sum/2];
      
    }
}



//tabulation

// class Solution {
//     public boolean canPartition(int[] nums) {
  
//         int sum = 0;
      
//       for(int x : nums){
//             sum += x;
//         }
       
//         if(sum % 2 != 0){
//             return false;
//         }
//         boolean dp[][]=new boolean[nums.length][(sum/2)+1];

//         for(int i=0;i<nums.length;i++){
//             dp[i][0]=true;
//         }

//         if(nums[0]<=sum/2){

//             dp[0][nums[0]]=true;
//         }

//         for(int i=1;i<nums.length;i++){
//             for(int target=1;target<=sum/2;target++){

//                     boolean notTake = dp[i-1][target];
                
//                     boolean take = false;

//                     if(nums[i] <= target){
//                         take = dp[i-1][target-nums[i]];
//                     }

//                     dp[i][target] = take || notTake;
//             }
//        }

        

//        return dp[nums.length-1][sum/2];
      
//     }
// }



//memoiation

// class Solution {
//     int dp[][];
//     boolean solve(int[] nums, int idx, int target){

//         if(target == 0) return true;

//         if(idx == 0){
//             return nums[0] == target;
//         }

//         if(dp[idx][target]!=-1)return dp[idx][target]==1;

//         boolean notTake =
//             solve(nums, idx-1, target);

//         boolean take = false;

//         if(nums[idx] <= target){
//             take =
//                 solve(nums, idx-1,
//                       target-nums[idx]);
//         }

//         dp[idx][target]= take|| notTake?1:0;
//         return take || notTake;
//     }

//     public boolean canPartition(int[] nums) {

//         int sum = 0;
//         for(int x : nums){
//             sum += x;
//         }

//         if(sum % 2 != 0){
//             return false;
//         }
//         dp=new int[nums.length][sum+1];
//         for(int i=0;i<nums.length;i++){
//             Arrays.fill(dp[i],-1);
//         }

//         return solve(
//             nums,
//             nums.length-1,
//             sum/2
//         );
//     }
// }








//ye code is question ka sol ni h y tab chlega agr tumhe solve milte hi uske index chiye ho subset k


// boolean solve(int nums[], ArrayList<Integer> list, int i, int sum){

//     if(sum == 0){
//         return true;
//     }

//     if(i < 0){
//         return false;
//     }

//     // Not Take
//     if(solve(nums, list, i-1, sum)){
//         return true;
//     }

//     // Take
//     if(nums[i] <= sum){

//         list.add(i);

//         if(solve(nums, list, i-1, sum-nums[i])){
//             return true;
//         }

//         list.remove(list.size()-1);
//     }

//     return false;
// }