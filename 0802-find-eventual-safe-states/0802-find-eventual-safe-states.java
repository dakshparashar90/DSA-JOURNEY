class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v[]=new int[graph.length];
        int path[]=new int[graph.length];
        int check[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(v[i]==0){
                dfs(i,graph,v,path,check);
            }
        }
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<check.length;i++){
            if(check[i]==1){
                list.add(i);
            }
        }
        return list;
    }
    public boolean dfs(int node ,int[][] graph,int v[],int path[],int check[]){
        v[node]=1;
        path[node]=1;
        check[node]=0;
        for(int it:graph[node]){
            if(v[it]==0){

                if(dfs(it,graph,v,path,check)==true){
                return true;
             }
            }
            else if(path[it]==1){
                return true;
            }
        }
        check[node]=1;
        path[node]=0;
        return false;
    }
}