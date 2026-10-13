class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
                adj.add(new ArrayList<>());
        }
        for(int arr[]:prerequisites){
            int u=arr[1];
            int v=arr[0];

            adj.get(u).add(v);
        }
        int visit[]=new int[numCourses];
        Stack<Integer>st=new Stack<>();

        for(int i=0;i<numCourses;i++){
            if(visit[i]==0){
                if(dfs(i,adj,visit,st)){
                    return new int[]{};
                }
            }
        }
        int ans[]=new int[numCourses];
        int cnt=0;
        while(!st.isEmpty()){
            ans[cnt]=st.pop();
            cnt++;
        }
    return ans;
    }
    public boolean dfs(int i,ArrayList<ArrayList<Integer>>adj,int visit[],Stack<Integer>st){
        visit[i]=1;
        for(int it : adj.get(i)){
            if(visit[it]==0){
                if(dfs(it,adj,visit,st)){
                    return true;
                  }
            }
            else if(visit[it]==1){
                return true;
            }
           
        }

        st.push(i);
        visit[i]=2;
        return false;
    }
}