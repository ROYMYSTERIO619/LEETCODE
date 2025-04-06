class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        
        int maxLen = 1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i]%arr[j]==0){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        
        int currNum = -1;
        List<Integer> ans = new ArrayList<>();
        for(int i=n-1; i>=0; i--){
            if(dp[i]==maxLen && (currNum==-1 || currNum%arr[i]==0)){
                ans.add(arr[i]);
                maxLen--;
                currNum = arr[i];
            }
        }
        return ans;
    }
}