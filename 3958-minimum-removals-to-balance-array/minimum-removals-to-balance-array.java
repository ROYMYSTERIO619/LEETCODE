class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int maxlen = 1;
        for (int right = 0; right < nums.length; right++) {
            while ((long) nums[right] > (long) nums[left] * k) {
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return nums.length - maxlen;
    }
}