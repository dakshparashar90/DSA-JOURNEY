class Solution {
    public void solve(int n,List<String>s,int i,int j,String ss ){
        if(i+j==n*2){
            s.add(ss);
            return;
        }

        if(i<n){
            solve(n,s,i+1,j,ss+"(");
        }
        if(j<i){
            solve(n,s,i,j+1,ss+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>s=new ArrayList<>();
        solve(n,s,0,0,"");

        return s;
    }
}