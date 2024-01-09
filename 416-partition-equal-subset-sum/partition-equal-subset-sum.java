// I. TOP-DOWN
class Solution {
    public boolean canPartition(int[] nums) {
        int range = 0;
        for (int val : nums) range += val;

        if (range%2 != 0) return false;
        
        return knapsackTF(nums, nums.length, range/2);
    }
    public boolean knapsackTF(int[] nums, int n, int sum) {
        Boolean[][] t = new Boolean[n+1][sum+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                // BASE CASE
                if (i == 0 && j != 0) {
                    t[i][j] = false;
                    continue;
                }
                if (j == 0) {
                    t[i][j] = true;
                    continue;
                }
                // CHOICE DIAGRAM
                if (nums[i-1] <= j) 
                    t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j];
                else t[i][j] = t[i-1][j];
            }
        }
        return t[n][sum];
    }
}