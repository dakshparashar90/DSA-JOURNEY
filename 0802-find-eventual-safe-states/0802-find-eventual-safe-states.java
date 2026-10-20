class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        int indeg[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(int it:graph[i]){
                adj.get(it).add(i);
                indeg[i]++;
            }
        }
    
      
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int it:adj.get(node)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.add(it);
                }
            }
        }
        
      Collections.sort(ans);
        return ans;
    }

}