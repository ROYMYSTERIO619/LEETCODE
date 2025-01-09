class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        int ans = 0;
        for(auto str : words){
            int n = str.size(),m = pref.size();
            if(n < m)continue;
            for(int i=0;i<m;i++){
                if(str[i] != pref[i]){
                    break;
                }
                if(i == m-1)ans++;
            }
        }
        return ans;
    }
};