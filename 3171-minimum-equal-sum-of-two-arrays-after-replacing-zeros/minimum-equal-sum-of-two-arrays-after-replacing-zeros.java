class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        long zCount1 = 0;
        long zCount2 = 0;
        for(int i=0; i<nums1.length; i++){
            sum1 += nums1[i];
            if(nums1[i] == 0) zCount1++;
        }
        for(int i=0; i<nums2.length; i++){
            sum2 += nums2[i];
            if(nums2[i] == 0) zCount2++;
        }
        if(zCount1 == 0 && zCount2 == 0 && sum1 == sum2){
            return sum1;
        }
        if(zCount1 == 0 && zCount2 == 0 && sum1 != sum2){
            return -1;
        }
        if((zCount2 == 0 && sum1 + zCount1 > sum2) || (zCount1 == 0 && sum2 + zCount2 > sum1)){
            return -1;
        }
        return Math.max(sum1+zCount1, sum2+zCount2);
    }
}