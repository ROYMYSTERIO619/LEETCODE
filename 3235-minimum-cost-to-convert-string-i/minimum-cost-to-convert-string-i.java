class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<List<int[]>> arr = new ArrayList<>();
        for(int i=0;i<26;i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<original.length;i++){
            arr.get(original[i]-'a').add(new int[]{changed[i]-'a',cost[i]});
        }
        long ans=0;
        long[][] dist = new long[26][26];
        for(long[] r:dist)Arrays.fill(r,Long.MAX_VALUE);
        for(int i=0;i<26;i++)dist[i][i]=0;
        int[] vis=new int[26];
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)!=target.charAt(i)){
                
                int u = source.charAt(i)-'a';
                int t = target.charAt(i)-'a';
                if(vis[u]==0){
                    PriorityQueue<int[]> pq  = new PriorityQueue<>((a,b)->(Integer.compare(a[0],b[0])));
                    pq.add(new int[]{0,u});
                    while(!pq.isEmpty()){
                        int[] curr = pq.poll();
                        for(int [] v:arr.get(curr[1])){
                            if(dist[u][v[0]]>curr[0]+v[1]){
                                dist[u][v[0]] = curr[0]+v[1];
                                pq.add(new int[]{curr[0]+v[1],v[0]});
                            }
                        }
                    }
                    vis[u]=1;
                }
                long check = dist[u][t]==Long.MAX_VALUE?-1:dist[u][t];
                
                if(check==-1L)return -1L;
                ans+=check;
            }
        }
        return ans;
    }
     
}