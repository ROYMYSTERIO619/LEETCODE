class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long[] pre = new long[n];
        long[] suf = new long[n];

        long prePrev = 0, sufPrev = 0;
        for(int i=0; i<n; i++) {
            pre[i] = Math.max(nums[i], prePrev);
            prePrev = pre[i];

            suf[n-1-i] = Math.max(nums[n-1-i], sufPrev);
            sufPrev = suf[n-1-i];

        }
        long res = 0;
        for(int i=1; i<n-1; i++) {
            res = Math.max(res, (pre[i-1]-nums[i])*suf[i+1]);
        }
        return res;
        
    }
}