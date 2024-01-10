class Solution {
    public static int mod = 1000000007;

    public int numberOfWays(int num, int x) {
        int n = (int) Math.round(Math.pow(num, 1.0 / x)); // Use 1.0 
        int sum = num;
        int[][] memo = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                memo[i][j] = -1;
            }
        }
        return solve(n, sum, x, memo);
    }

    int solve(int n, int sum, int x, int[][] memo) {
        if (sum == 0 && n == 0) return 1;
        if (n == 0) return 0;

        if (memo[n][sum] != -1) return memo[n][sum];

        int val = (int) Math.pow(n, x) % mod; // Cast to int after taking the power
        int tempans;

        if (val <= sum) {
            tempans = (solve(n - 1, sum - val, x, memo) + solve(n - 1, sum, x, memo)) % mod;
        } else {
            tempans = solve(n - 1, sum, x, memo) % mod;
        }

        memo[n][sum] = tempans;
        return tempans;
    }
}
