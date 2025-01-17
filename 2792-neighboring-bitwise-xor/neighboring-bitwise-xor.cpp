class Solution {
public:
    bool check_if_valid(const vector<int>& derived, int original_0) {
        int n = derived.size(); 
        vector<int> original(n); 
        original[0] = original_0; 
        for (int i = 1; i < n; ++i) { 
            original[i] = derived[i - 1] ^ original[i - 1]; 
        } 
        return derived[n - 1] == (original[n - 1] ^ original[0]); 
    } 

    bool doesValidArrayExist(vector<int>& derived) { 
        return check_if_valid(derived, 0) || check_if_valid(derived, 1); 
    }
};