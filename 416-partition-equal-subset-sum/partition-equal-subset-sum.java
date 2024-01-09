// // I. TOP-DOWN
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int range = 0;
//         for (int val : nums) range += val;

//         if (range%2 != 0) return false;
        
//         return knapsackTF(nums, nums.length, range/2);
//     }
//     public boolean knapsackTF(int[] nums, int n, int sum) {
//         boolean[][] t = new boolean[n+1][sum+1];
//         // BASE CASE
//         for (int j = 0; j <= sum; j++) t[0][j] = false;
//         for (int i = 0; i <= n; i++) t[i][0] = true;

//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= sum; j++) {
//                 // CHOICE DIAGRAM
//                 if (nums[i-1] <= j) 
//                     t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j];
//                 else t[i][j] = t[i-1][j];
//             }
//         }
//         return t[n][sum];
//     }
// }

// MEMO using 2D Array
class Solution {
    public boolean canPartition(int[] nums) {
        int range = 0;
        for (int val : nums) range += val;
        if (range%2 != 0) return false;

        int n = nums.length;
        int sum = range/2;
        Boolean[][] memo = new Boolean[n+1][sum+1];
        return knapsackTF(nums, n, sum, memo);
    }
    public boolean knapsackTF(int[] nums, int n, int sum, Boolean[][] memo) {
        // BASE CASE
        if (sum == 0) return true;
        if (n == 0 & sum != 0) return false;
        if (memo[n][sum] != null) return memo[n][sum];

        // CHOICE DIAGRAM
        if (nums[n-1] <= sum) {
            memo[n][sum] = knapsackTF(nums, n-1, sum-nums[n-1], memo) || 
            knapsackTF(nums, n-1, sum, memo);
        }
        else memo[n][sum] = knapsackTF(nums, n-1, sum, memo);

        return memo[n][sum];
    }
}