class Solution {
    public int[] productQueries(int n, int[][] queries) {
        // The modulus for all calculations
        int MOD = 1_000_000_007;

        // 1. Deconstruct n into powers of two
        ArrayList<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            // Check if the i-th bit of n is set
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i);
            }
        }

        // 2. Process each query
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            
            // Use long to prevent overflow before the modulo
            long product = 1; 
            for (int j = start; j <= end; j++) {
                product = (product * powers.get(j)) % MOD;
            }
            result[i] = (int) product;
        }

        return result;
    }
}