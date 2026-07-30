class DisjointSet{
    int prnt[];
    int size[];
    DisjointSet(int n){
        prnt=new int[n+1];
        size=new int[n+1];
        for(int i=1;i<=n;i++){
            prnt[i]=i;
            size[i]=1;
        }
    }
    public int findPar(int u){
        if(prnt[u]==u) return u;
        return prnt[u]=findPar(prnt[u]);
    }
    public void unionBySize(int u,int v){
        int pu=findPar(u);
        int pv=findPar(v);
        if(pu==pv) return;
        if(size[pu]>size[pv]){
            size[pu]+=size[pv];
            prnt[pv]=pu;
        }
        else{
            size[pv]+=size[pu];
            prnt[pu]=pv;
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DisjointSet ds=new DisjointSet(n);
        int ans[]=new int[2];
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(ds.findPar(u)==ds.findPar(v)){
                ans[0]=u;
                ans[1]=v;
                break;
            }
            else{
                ds.unionBySize(u,v);
            }
        }
        return ans;
    }
}