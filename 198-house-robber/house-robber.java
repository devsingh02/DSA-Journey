class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) memo[i] = -1;

        return solve(n-1, nums, memo);
    }
    int solve(int ind, int[] nums, int[] memo) {
        if (ind < 0) return 0;
        if (memo[ind] != -1) return memo[ind];

        int pick = nums[ind] + solve(ind-2, nums, memo);
        int notpick = 0 + solve(ind-1, nums, memo);
        return memo[ind] = Math.max(pick, notpick);
    }
}