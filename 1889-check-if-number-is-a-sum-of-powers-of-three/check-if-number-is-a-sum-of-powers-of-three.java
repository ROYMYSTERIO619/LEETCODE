class Solution {
     private boolean dfs(int number, int progression) {
        if (number == 0) return true;
        if (number < 0) return false;
        if (progression > 16) return false;

        int powerOf3 = (int) Math.pow(3, progression);
        return dfs(number, progression + 1) || dfs(number - powerOf3, progression + 1);
    }

    public boolean checkPowersOfThree(int n) {
        return this.dfs(n, 0);
    }
} 