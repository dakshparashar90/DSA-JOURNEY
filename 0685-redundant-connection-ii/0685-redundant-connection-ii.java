class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        int parent[]=new int[n+1];
        int cnd1[]=null;
        int cnd2[]=null;

        for(int edge[] : edges){
            int u=edge[0];
            int v=edge[1];

            if(parent[v]==0){            //ye check krta h ki kisi node k doo parent h ya  nhi 
                parent[v]=u;
            }
            else{
                cnd1=new int[]{parent[v],v};
                cnd2=new int[]{u,v};                // agar two parents h toh sec node ko temp ignpore kro

                edge[1]=0;
            }
        }

        int up[]=new int[n+1];

        for(int i=1;i<=n;i++){
            up[i]=i;
        }

        for(int edge[]:edges){
            if(edge[1]==0)
                continue;

            int u=edge[0];
            int v=edge[1];

            int upp=find(up,u);   

            if(v==upp){
                if(cnd1==null){
                    return edge;
                }

                return cnd1;
            } 

            up[v]=upp;
        }

        return cnd2;
    }

    public int find(int parent[],int u){
       if(parent[u]==u){
        return u;
       }

       return parent[u]=find(parent,parent[u]);
    }
}