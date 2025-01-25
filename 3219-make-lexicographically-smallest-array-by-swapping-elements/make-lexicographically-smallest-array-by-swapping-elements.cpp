class Solution {
public:
    vector<int> lexicographicallySmallestArray(vector<int>& nums, int limit) {
        vector<pair<int, int >> Pair;
        int n = nums.size();
        for (int i = 0; i < n; i++){
            Pair.push_back({nums[i], i});
        }
        sort(Pair.begin(), Pair.end());
        vector<int> x[n];
        vector<int> y[n];
        int j = 0, cur = Pair[0].first;

        x[j].push_back(Pair[0].first);
        y[j].push_back(Pair[0].second);
        for (int i = 1; i < n; i++){
            if (Pair[i].first - cur > limit){
                j++;
            }
            x[j].push_back(Pair[i].first);
            y[j].push_back(Pair[i].second);
            cur = Pair[i].first;
        }
        for (int i = 0; i < n; i++){
            sort(y[i].begin(), y[i].end());
        }
        vector<int> res(n);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < x[i].size(); j++){
                res[y[i][j]] = x[i][j];
            }
        }
        return res;
    }
};