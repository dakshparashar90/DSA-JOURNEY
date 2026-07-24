class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> mpp = new HashMap<>();

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            int mod = sum % k;

            if (mod == 0 && i >= 1) {
                return true;
            }

            if (mpp.containsKey(mod)) {
                int idx = mpp.get(mod);

                if (i - idx >= 2) {
                    return true;
                }
            } else {
                mpp.put(mod, i);
            }
        }

        return false;
    }
}


// class Solution {
//     public boolean checkSubarraySum(int[] nums, int k) {
//         HashMap<Integer,Integer>mpp=new HashMap<>();
//         int sum=0;
//         int i=0;
       
//        while(i<nums.length){
//             sum+=nums[i];
//             int mod=sum%k;
            
//             if(sum%k==0 &&  i>=1){
//                 return true;

//             }
//             else if(mpp.containsKey(mod)){
//                     int vl=mpp.get(mod);
//                     if(i-vl>=2){
//                         return true;
//                     }
//             }
//             else{
//                 mpp.put(mod,i);
//             }

//             i++;
//         }
//         return false;
//     }
// }