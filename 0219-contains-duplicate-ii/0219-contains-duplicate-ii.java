class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();
        int L = 0;
        for (int R = 0; R < nums.length; R++) {
            if (R-L+1 > k+1) {    // first maintain size, then compare.
                window.remove(nums[L]);
                L++;
            }
            if (window.contains(nums[R])) return true;
            window.add(nums[R]);
        }
        return false;
    }
}