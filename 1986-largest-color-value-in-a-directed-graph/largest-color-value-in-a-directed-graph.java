class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            indegree[v]++; // to ckeck incoming node dependancy 
        }

        int[] topo = topologicalSort(n, adj, indegree);
        if (topo == null) return -1;

        int[][] dp = new int[n][26];
        int maxCount = 0;

        for (int u : topo) {
            int colorIndex = colors.charAt(u) - 'a';
            dp[u][colorIndex]++;

            maxCount = Math.max(maxCount, dp[u][colorIndex]);

            for (int v : adj.get(u)) {
                for (int c = 0; c < 26; c++) {
                    dp[v][c] = Math.max(dp[v][c], dp[u][c]);
                }
            }
        }

        return maxCount;
    }

    public static void dfs(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, boolean[] underDFS, boolean[] hasCycle) {
        vis[node] = 1;
        underDFS[node] = true;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, st, adj, underDFS, hasCycle);
            } else if (underDFS[it]) {
                hasCycle[0] = true;
            }
        }

        underDFS[node] = false;
        st.push(node);
    }

    public static int[] topologicalSort(int n, ArrayList<ArrayList<Integer>> adj, int[] indegree) {
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        boolean[] underDFS = new boolean[n];
        boolean[] hasCycle = new boolean[1];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj, underDFS, hasCycle);
            }
        }

        if (hasCycle[0]) return null;

        int[] topo = new int[n];
        int i = 0;
        while (!st.isEmpty()) {
            topo[i++] = st.pop();
        }

        return topo;
    }
}