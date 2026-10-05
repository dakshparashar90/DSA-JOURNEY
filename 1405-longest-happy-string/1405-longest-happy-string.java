class Pair {
    int freq;
    char ch;

    Pair(int freq, char ch) {
        this.freq = freq;
        this.ch = ch;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x, y) -> y.freq - x.freq
        );

        if (a > 0) pq.offer(new Pair(a, 'a'));
        if (b > 0) pq.offer(new Pair(b, 'b'));
        if (c > 0) pq.offer(new Pair(c, 'c'));

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {

            Pair first = pq.poll();

          
            if (sb.length() >= 2 &&
                sb.charAt(sb.length() - 1) == first.ch &&
                sb.charAt(sb.length() - 2) == first.ch) {

               
                if (pq.isEmpty()) {
                    break;
                }

                Pair second = pq.poll();

                sb.append(second.ch);
                second.freq--;

                if (second.freq > 0) {
                    pq.offer(second);
                }

              
                pq.offer(first);

            } else {

                sb.append(first.ch);
                first.freq--;

                if (first.freq > 0) {
                    pq.offer(first);
                }
            }
        }

        return sb.toString();
    }
}