class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;
        
      
        long min = 0, max = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += differences[i];
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        int ans = (int)((upper - lower) - (max - min) + 1);
        return Math.max(0, ans);
    }
}