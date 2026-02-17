class MovieRentingSystem {
    Map<Long,Integer> priceMap;
    Map<Integer,TreeSet<int[]>> map;
    TreeSet<int[]> ts;
    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new HashMap<>();
        map = new HashMap<>();
        ts = new TreeSet<>((a,b)->{
            if(a[0]!=b[0])return a[0] - b[0];
            if(a[1]!=b[1])return a[1] - b[1];
            return a[2] - b[2];
        });
        for(int[] e:entries){
            int shop=e[0], movie=e[1], price = e[2];
            priceMap.put(key(shop,movie),price);
            map.computeIfAbsent(movie,k->new TreeSet<>((a,b)->{
                if(a[0]!=b[0])return a[0] - b[0];
                return a[1] - b[1];
            })).add(new int[]{price,shop});
        }
    }

    private long key(int shop,int movie){
        return ((long)shop<<20)|movie;
    }
    
    public List<Integer> search(int movie) {
        List<Integer> list = new ArrayList<>();
        if(!map.containsKey(movie))return list;
        int cnt = 0;
        for(int[] e:map.get(movie)){
            list.add(e[1]);
            if(++cnt==5)break;
        }
        return list;
    }
    
    public void rent(int shop, int movie) {
        int price = priceMap.get(key(shop,movie));
        map.get(movie).remove(new int[]{price,shop});
        ts.add(new int[]{price,shop,movie});
    }
    
    public void drop(int shop, int movie) {
        int price = priceMap.get(key(shop,movie));
        ts.remove(new int[]{price,shop,movie});
        map.get(movie).add(new int[]{price,shop});
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> list = new ArrayList<>();
        int cnt = 0;
        for(int[] e:ts){
            list.add(Arrays.asList(e[1],e[2]));
            if(++cnt==5)break;
        }
        return list;
    }
}