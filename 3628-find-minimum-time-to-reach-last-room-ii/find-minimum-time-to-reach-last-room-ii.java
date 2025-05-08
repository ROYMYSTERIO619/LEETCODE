class Solution {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int m = moveTime.length;
        int n = moveTime[0].length;

        int[][] dist = new int[m][n];
        for (int[] temp : dist) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }

        int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};

        pq.offer(new int[]{0, 0, 0, 1});
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], wt = curr[2], step = curr[3];

            if (r == m - 1 && c == n - 1) return dist[r][c];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newwt = Math.max(wt, moveTime[nr][nc]) + step;

                    if (newwt < dist[nr][nc]) {
                        dist[nr][nc] = newwt;
                        pq.offer(new int[]{nr, nc, newwt, step == 1 ? 2 : 1});
                    }
                }
            }
        }

        return -1;
    }
}