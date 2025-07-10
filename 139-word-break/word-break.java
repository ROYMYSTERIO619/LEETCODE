class Solution {
    boolean yesRec(int l, int r, String s, Set<String> set, Boolean[][] dp) {
        if (r == s.length() - 1 && set.contains(s.substring(l, r + 1)))
            return true;
        
        if (r >= s.length())
            return false;
        
        if (dp[l][r] != null)
            return dp[l][r];
        
        boolean res = yesRec(l, r + 1, s, set, dp);
        if (set.contains(s.substring(l, r + 1))) {
            res = yesRec(r + 1, r + 1, s, set, dp) || res;
        }

        return dp[l][r] = res;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new TreeSet<>();
        for (var word : wordDict) {
            set.add(word);
        }
        
        int n = s.length();
        Boolean[][] dp = new Boolean[n + 1][n + 1];

        return yesRec(0, 0, s, set, dp);
    }
}