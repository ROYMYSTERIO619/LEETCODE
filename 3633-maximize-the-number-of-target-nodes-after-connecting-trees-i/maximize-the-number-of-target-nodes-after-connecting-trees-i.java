class Pair {
    int node;
    int steps;

    public Pair(int node, int steps) {
        this.node = node;
        this.steps = steps;
    }
}

class Solution {
    
    public int bfs(int node, ArrayList<ArrayList<Integer>> adj, int arr[], int k) {
        boolean vis[] = new boolean[arr.length];
        int cnt = 0;
        vis[node] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, 0));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int nodeG = p.node;
            int steps = p.steps;

            if (steps <= k) cnt++;

            for (int nbr : adj.get(nodeG)) {
                if (steps + 1 <= k && !vis[nbr]) {
                    vis[nbr] = true;
                    q.add(new Pair(nbr, steps + 1));
                }
            }
        }
        return cnt;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < m; i++) adj2.add(new ArrayList<>());

        for (int[] i : edges1) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        for (int[] i : edges2) {
            adj2.get(i[0]).add(i[1]);
            adj2.get(i[1]).add(i[0]);
        }

        int bfs1[] = new int[n];
        for (int i = 0; i < n; i++) {
            bfs1[i] = bfs(i, adj, bfs1, k);
        }

        int bfs2[] = new int[m];
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            bfs2[i] = bfs(i, adj2, bfs2, k - 1);
            maxi = Math.max(maxi, bfs2[i]);
        }

        int answer[] = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = bfs1[i] + maxi;
        }
        return answer;
    }
}