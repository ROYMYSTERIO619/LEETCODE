class Pair{
    long cost;
    String node;
    Pair(long cost,String node){
        this.cost=cost;
        this.node=node;
    }
}
class Solution {
    //adj list is map here
    HashMap<String,List<Pair>> adj=new HashMap<>();
    Long M=(long)1e10;
    String sourceStr;
    String targetStr;
    Map<String, Map<String, Long>> dijkstraMemo = new HashMap<>();
    long[] dpMemo;
    //set to store the length of unique strings given so that we can have check on min 
    //possible cost by iterating on each
    TreeSet<Integer> set=new TreeSet<>();



    long dijkstra(String start,String end ){
        if (dijkstraMemo.containsKey(start) &&
            dijkstraMemo.get(start).containsKey(end)) {
            return dijkstraMemo.get(start).get(end);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparingLong(p -> p.cost));

        //for storing min path sum
        Map<String, Long> res = new HashMap<>();
        res.put(start, 0L);

        pq.add(new Pair(0,start));
        
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            long currCost = curr.cost;
            String node = curr.node;

            if(node.equals(end)) break;
            if (!adj.containsKey(node))
                continue;
            
            for(Pair edge:adj.get(node)){
                String adjNode = edge.node;
                long edgeCost = edge.cost;

                long newCost=currCost+edgeCost;
                if(!res.containsKey(adjNode) || newCost<res.get(adjNode)){
                    res.put(adjNode,newCost);
                    pq.offer(new Pair(newCost,adjNode));
                }
            }
        }
        long finalCost=res.getOrDefault(end,M);
//we can use  dijstra algorithm as it is used again if multiple frq occurs
         dijkstraMemo
            .computeIfAbsent(start, k -> new HashMap<>())
            .put(end, finalCost);

        return finalCost;
    } 
    //main solution logic
    long solve(int idx){
        if(idx>=sourceStr.length()) return 0;

        if (dpMemo[idx] != -1)
            return dpMemo[idx];

        long minC=M;

        //we have two ways
        //first is to skip the ith char as it is same already & move to next
        // second is to take that also in our substring
        if(sourceStr.charAt(idx)==targetStr.charAt(idx))
            minC=Math.min(minC,solve(idx+1));
        for(int l:set){
            if(idx+l>sourceStr.length()){
                break;
            }
            String srcSub=sourceStr.substring(idx,idx+l);
            String tgtSub=targetStr.substring(idx,idx+l);

            if(!adj.containsKey(srcSub)) continue;

            //if contains use dijkstra for min path cost
            long pCost=dijkstra(srcSub,tgtSub);
            if(pCost==M) continue;
            minC=Math.min(minC,pCost+solve(idx+l));
        }
        return dpMemo[idx] = minC;
    }


    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n= source.length();
        sourceStr=source;
        targetStr=target;

        dpMemo = new long[10001];
        Arrays.fill(dpMemo, -1);

        //create adj list and add the unique strings length
        for(int i=0;i<original.length;i++){
            adj.computeIfAbsent(original[i],k->new ArrayList<>())
               .add(new Pair(cost[i],changed[i]));
            set.add(original[i].length());
        }

        long res=solve(0);
        return res== M?-1:res;

    }
}