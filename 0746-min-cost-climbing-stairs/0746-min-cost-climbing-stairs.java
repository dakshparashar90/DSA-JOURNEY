class Solution {
    int dp[];
    public int solve(int cost[],int i){
        if(i+1 > cost.length-1){
            return cost[i];
        }

        if(i+2 > cost.length-1){
            return cost[i];
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int step1=solve(cost,i+1);
        int step2=solve(cost ,i+2);

        return dp[i]=cost[i]+Math.min(step1,step2);
    }
    public int minCostClimbingStairs(int[] cost) {
        dp=new int [cost.length];
        Arrays.fill(dp,-1);
        return Math.min(solve(cost,0),solve(cost,1));
    }
}