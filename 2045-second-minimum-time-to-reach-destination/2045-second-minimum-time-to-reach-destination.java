class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] first = new int[n + 1];
        int[] second = new int[n + 1];

        Arrays.fill(first, Integer.MAX_VALUE);
        Arrays.fill(second, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{1, 0});
        first[1] = 0;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int u = curr[0];
            int t = curr[1];

           
            if ((t / change) % 2 == 1) {
                t = (t / change + 1) * change;
            }

            int nextTime = t + time;

            for (int v : adj.get(u)) {

                if (nextTime < first[v]) {
                    second[v] = first[v];
                    first[v] = nextTime;

                    q.offer(new int[]{v, nextTime});
                } 
                else if (nextTime > first[v]
                        && nextTime < second[v]) {

                    second[v] = nextTime;

                    q.offer(new int[]{v, nextTime});
                }
            }

            if (second[n] != Integer.MAX_VALUE) {
                return second[n];
            }
        }

        return -1;
    }
}