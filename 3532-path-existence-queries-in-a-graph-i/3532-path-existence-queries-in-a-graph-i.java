class DSU {

    int[] parent;
    int[] size;

    DSU(int n) {

        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int node) {

        if(parent[node] == node)
            return node;

        return parent[node] = find(parent[node]);
    }

    void union(int u,int v) {

        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return;

        if(size[pu] < size[pv]) {

            parent[pu] = pv;
            size[pv] += size[pu];

        } else {

            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}


class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean res[]=new boolean[queries.length];
        DSU dsu=new DSU(n);

       for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                dsu.union(i, i + 1);
            }
        }

        for(int i=0;i<queries.length;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            int p1=dsu.find(a);
            int p2=dsu.find(b);


            res[i]=p1==p2;
        }

        return res;
    }
}