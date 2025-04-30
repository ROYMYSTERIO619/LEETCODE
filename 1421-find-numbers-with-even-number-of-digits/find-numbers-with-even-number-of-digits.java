class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            // Count digits using log10 without converting to string
            if ((int)(Math.log10(num) + 1) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}