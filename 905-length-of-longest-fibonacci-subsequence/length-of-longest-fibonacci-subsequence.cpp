class Solution {
    int solve(unordered_map<int,int>& m,vector<int>& arr,int i,int j){
        if(m.find(arr[i]+arr[j])==m.end()) return 0;
        int ans=1 + solve(m,arr,j,m[arr[i]+arr[j]]);
        return ans;
    }
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        int ans=0;
        unordered_map<int,int> m;
        for(int i=0;i<arr.size();i++){
            m[arr[i]]=i;
        }
        for(int i=0;i<arr.size()-1;i++){
            for(int j=i+1;j< arr.size();j++){
                ans= max(ans,solve(m,arr,i,j)+2);
            }
        }
        return ans>2? ans:0;
    }
};