class Solution {
    public int minOperations(int[] nums, int k) {
        int arr[] = new int[101];
        arr[k]++;
        for(int n : nums){
            if(n >= k )
            arr[n]++;
            else
            return -1;
        }
        int count = 0;
        for(int n : arr){
            if(n > 0){
                count++;
            }
        }
        return count-1;
    }
}