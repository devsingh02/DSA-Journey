// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int range = 0;
//         for (int num : nums) range += num;
//         if ((range+target) % 2 != 0) return 0;
//         int sum = (range + target)/2;
//         int n = nums.length;
//         int[][] memo = new int[n+1][sum+1];
//         return knap(nums, n, sum, memo);
//     }
//     int knap(int[] nums, int n, int sum, int[][] memo) {
//         // BASE CASE
//         if (sum == 0) return 1;
//         if (n == 0) return 0;
//         // CHOICE DIAGRAM
//         if (nums[n-1] <= sum)
//             memo[n][sum] = knap(nums, n-1, sum-nums[n-1], memo) 
//             + knap(nums, n-1, sum, memo);
//         else memo[n][sum] = knap(nums, n-1, sum, memo);

//         return memo[n][sum];
//     }
// }


class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //Solution 1
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;
        
        int n = nums.length;
        int s2 = (sum - target)/2;
        int[][] t = new int[n + 1][s2 + 1];
        t[0][0] = 1;
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < s2 + 1; j++) {
                if(nums[i - 1] <= j)
                    t[i][j] = t[i-1][j] + t[i - 1][j - nums[i - 1]];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][s2];
    }
}