class Solution {
    public int superEggDrop(int n, int k) {
    // Initialize array of size (n+1) and m as moves.
        int dp[] = new int[n + 1], m;
        for (m = 0; dp[n] < k; m++) {
            for (int x = n; x > 0; x--) {
                dp[x] += 1 + dp[x - 1];
            }
        }
        return m;
    }
}