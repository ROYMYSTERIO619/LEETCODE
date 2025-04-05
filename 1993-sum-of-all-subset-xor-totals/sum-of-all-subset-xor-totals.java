class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length, total = 0;
        for (int m = 0; m< (1 << n); m++) {
            int subsetXor = 0;
            for (int i = 0; i < n; i++) {
                if ((m & (1 << i)) != 0) {
                    subsetXor ^= nums[i];
                }
            }
            total += subsetXor;
        }
        return total;
    }
}