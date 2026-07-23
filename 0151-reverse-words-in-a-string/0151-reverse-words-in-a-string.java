class Solution {
    public String reverseWords(String s) {

        int i = s.length() - 1;
        StringBuilder ans = new StringBuilder();

        while (i >= 0) {

         
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) break;

         
            int j = i;

          
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

          
            ans.append(s.substring(i + 1, j + 1));

           
            if (i > 0) {
                ans.append(" ");
            }
        }

        return ans.toString().trim();
    }
}