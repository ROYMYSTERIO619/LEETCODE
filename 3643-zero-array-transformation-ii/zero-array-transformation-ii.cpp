class Solution {
public:
    bool isFeasible(vector<int>& nums, int n, int k, vector<vector<int>>& queries)
    {
        vector<long long int> sweep(n + 1, 0);

        for(int i = 0; i <= k; i++)
        {
            sweep[queries[i][0]] += (long long int)queries[i][2];
            sweep[queries[i][1] + 1] -= (long long int)queries[i][2]; 
        }

        long long int cumm = 0;
        
        for(int i = 0; i < n; i++)
        {
            cumm += sweep[i];
            if(cumm < nums[i])
                return false;
        }

        return true;
    }

    int minZeroArray(vector<int>& nums, vector<vector<int>>& queries) {
        
        int n = nums.size();
        int low = 0, high = queries.size() - 1, k;
        int res = -1;

        long long int sum = accumulate(nums.begin(), nums.end(), 0LL);
        if(!sum) return 0;

        while(low <= high)
        {
            k = (low + high) / 2;
            if(isFeasible(nums, n, k, queries))
            {
                res = k + 1;
                high = k - 1;
            }
            else
                low = k + 1;
        }
        return res;
    }
};