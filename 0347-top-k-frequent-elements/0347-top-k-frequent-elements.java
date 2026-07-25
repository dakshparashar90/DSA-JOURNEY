class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer,Integer>mpp=new HashMap<>();
    int ans[]=new int[k];
       for(int i=0;i<nums.length;i++){
            
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);

       }

  PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));


        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
                pq.offer(new int[]{entry.getKey(),entry.getValue()});
        }

       for(int j=0;j<k;j++){
            ans[j]=pq.poll()[0];

       }

       return ans;
    }
}