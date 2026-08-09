class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       Arrays.sort(intervals, (a,b) -> a[1]-b[1]);

        int count=0;
        int val = Integer.MIN_VALUE;

        for(int[] inter:intervals){
                if(inter[0]>=val){
                   
                    val=inter[1];
                }else{
                    count++;
                }
        }
        return count;
    }
}