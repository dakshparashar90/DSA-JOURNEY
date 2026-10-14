
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>>adj=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int arr[]:times){
            int u=arr[0];
            int v=arr[1];
            int w=arr[2];

            adj.get(u).add(new int[]{v,w});
        }

        int dup[]=new int[n+1];
        Arrays.fill(dup,Integer.MAX_VALUE);
        dup[k]=0;

        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int ap[]=pq.poll();
            int nd=ap[0];
            int dd=ap[1];

            for(int it[]:adj.get(nd)){
                int nd2=it[0];
                int dd2=it[1];

                if(dd+dd2 < dup[nd2]){
                    dup[nd2]=dd+dd2;
                    pq.add(new int[]{nd2,dd+dd2});
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dup[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(dup[i],max);
        }

        return max;
    }
}