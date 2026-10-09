
class Solution {
    public int minInsertions(String s) {
        Stack<Character>st=new Stack<>();
       
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                st.push('(');
            } 
            else {
              
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } 
                else {
                  
                    ans++;
                }

                if (!st.isEmpty()) {
                    st.pop();
                } 
                else {
                  
                    ans++;
                }
            }
        }

        return ans + 2 * st.size();
    }
}
