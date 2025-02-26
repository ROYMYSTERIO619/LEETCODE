class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
      int ans = INT_MIN;
      int n = nums.size();
      int maxSum = 0;
      int minSum = 0;
      for(int i=0;i<n;i++) {
         maxSum+=nums[i];
         minSum+=nums[i];
         ans = max(abs(maxSum),ans);
         ans= max(ans,abs(minSum));
         if(maxSum<=0) {
            maxSum=0;
         }
         if(minSum>=0) {
            minSum=0;
         }
      }
      return ans;
    }
};