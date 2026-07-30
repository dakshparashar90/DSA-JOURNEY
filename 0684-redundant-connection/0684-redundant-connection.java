class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();

        for(int i=0;i<=edges.length;i++){
            adj.add(new ArrayList<>());
        }
        boolean vis[]=new boolean[edges.length+1];
       
        for(int arr[]:edges){
            int u=arr[0];
            int v=arr[1];

            if(check(u,v,adj,vis))return arr;
          
            adj.get(u).add(v);
            adj.get(v).add(u);


        }
        return new int[]{};
    }
    public boolean check(int src,int tar,ArrayList<ArrayList<Integer>>adj, boolean vis[]){
       if(src==tar)return true;
        vis[src]=true;
        for(int it:adj.get(src)){
            if(!vis[it]){
                 if(check(it, tar, adj, vis)) return true;
            }
        }
        vis[src]=false;
        return false;
    }
}