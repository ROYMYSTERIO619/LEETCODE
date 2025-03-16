class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 0;
        int mini = 1000000;
        for(int i:ranks) mini = Math.min(i, mini);
        long high = (long)cars*cars*mini;
        long ans = 0;
        while(low<=high){
            long mid=(low+high)/2;
            if(check(ranks, cars, mid)){
                ans = mid;
                high = mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public boolean check(int[] ranks, int cars, long ans){
        long used=0;
        for(int i : ranks){
            used += Math.sqrt(ans/(1L*i));
        }
        return used >= cars;
    }
}