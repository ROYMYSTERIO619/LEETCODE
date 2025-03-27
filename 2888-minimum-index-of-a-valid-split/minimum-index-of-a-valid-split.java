class Solution {
    public int minimumIndex(List<Integer> nums) {

        int dominant = findDominantElement(nums);

        int totalDominantCount = (int) nums.stream()
            .filter(num -> num == dominant)
            .count();
        
        int leftCount = 0;

        for (int i = 0; i < nums.size() - 1; i++) {

            if (nums.get(i) == dominant) {
                leftCount++;
            }
            

            double leftPercentage = (double) leftCount / (i + 1);
            double rightPercentage = (double) (totalDominantCount - leftCount) / (nums.size() - i - 1);
            
            if (leftPercentage > 0.5 && rightPercentage > 0.5) {
                return i;
            }
        }
        
        return -1;
    }
    

    private int findDominantElement(List<Integer> nums) {
        int candidate = 0;
        int count = 0;
        
  
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}