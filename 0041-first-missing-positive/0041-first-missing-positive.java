class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

       
        int i = 0;
        int j = n - 1;

        while (i <= j) {

            if (nums[j] <= 0 || nums[j] > n) {
                j--;
                continue;
            }

            if (nums[i] <= 0 || nums[i] > n) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }

            i++;
        }

     
        for (i = 0; i < n; i++) {

            while (nums[i] >= 1 &&
                   nums[i] <= n &&
                   nums[nums[i] - 1] != nums[i]) {

                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}