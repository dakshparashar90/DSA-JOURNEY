class Pair {
    int val;
    char ch;

    Pair(char ch, int val) {
        this.ch = ch;
        this.val = val;
    }
}

class Solution {
    public String reorganizeString(String s) {

        int arr[] = new int[26];
        char res[] = new char[s.length()];

      
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }

     
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> b.val - a.val);

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                char ch = (char) ('a' + i);
                pq.add(new Pair(ch, arr[i]));
            }
        }

      
        if (pq.peek().val > (s.length() + 1) / 2) {
            return "";
        }

        int k = 0;

        while (!pq.isEmpty()) {

            Pair p = pq.poll();

            while (p.val > 0) {

            if (k >= s.length()) {
                    k = 1;
                }

                res[k] = p.ch;
                k += 2;

                p.val--;
            }
        }

        return new String(res);
    }
}