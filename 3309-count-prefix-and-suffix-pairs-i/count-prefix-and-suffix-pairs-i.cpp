class Solution {
public:
    bool isPrefixAndSuffix(string s1,string s2){
        if(s1.size() > s2.size()) return false;
        bool pre = true;
        bool suff = true;

        // For Prefix
        for(int i = 0;i<s1.size() ;i++){
            if(s1[i]  != s2[i]) {
                pre = false;
                break;
            }
        }
        for(int i = 0;i<s1.size() ;i++){
            if(s1[i] != s2[s2.size() - s1.size() +i]){
                suff = false;
                break;
            }
        }
        return pre && suff;
    }
    int countPrefixSuffixPairs(vector<string>& words) {
        int answer = 0;
        for(int i = 0 ;i<words.size();i++){
            for(int j = i+1;j<words.size();j++){
                if(isPrefixAndSuffix(words[i],words[j])) answer++;
            }
        }
        return answer;
    }
};