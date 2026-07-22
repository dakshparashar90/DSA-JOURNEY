class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean>lt=new ArrayList<>();
        int max=0;
        for(int i=0;i<candies.length;i++){
            max=Math.max(candies[i],max);
        }
        for(int j=0;j<candies.length;j++){
            int sum=candies[j]+extraCandies;

            if(sum>=max){
                lt.add(true);
            }
            else{
                lt.add(false);
            }
        }
        return lt;
    }

}