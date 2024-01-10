class Solution {
    public static int mod = 1000000007;

    public int numberOfWays(int n, int x) {
        // int nn = (int)Math.pow(n, 1.0 / x); // Use 1.0 to ensure double division
        int nn = 1;
        while (Math.pow(nn, x) <= n) {
            nn++;
        }
        int sum = n;
        int[][] memo = new int[nn + 1][sum + 1];
        for (int i = 0; i <= nn; i++) {
            for (int j = 0; j <= sum; j++) {
                memo[i][j] = -1;
            }
        }
        return (solve(nn, sum, x, memo)) % mod;
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
