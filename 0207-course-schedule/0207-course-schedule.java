class Solution {
    public boolean canFinish(int V, int[][] edges) {
              int[] deg=new int[V];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
            
        }
        for(int arr[]:edges){
            int u=arr[0];
            int v=arr[1];
            
            adj.get(u).add(v);
            
        }
        
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                deg[it]++;
            }
        }
        
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(deg[i]==0){
                q.add(i);
            }
        }
        
      int cnt=0;
        while(!q.isEmpty()){
            int node=q.poll();
           cnt++;
            for(int it:adj.get(node)){
                deg[it]--;
                if(deg[it]==0){
                    q.add(it);
                }
            }
        }
        
        return cnt==V?true:false;
    }
}