class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean vist[]=new boolean[isConnected.length];
        int p=0;
        for(int i=0;i<isConnected.length;i++){
            if(!vist[i]){
                dfs(isConnected,vist,i);
                p++;
            }
        }
        return p;
    }
    public void dfs(int graph[][],boolean vist[],int i){
        vist[i]=true;

        for(int j=0;j<graph.length;j++){
            if(graph[i][j]==1 && !vist[j]){
                dfs(graph,vist,j);
            }
        }
    }
}