class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); // <element, count>
        int pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                pairs += map.get(nums[i]);
            }
            else
                map.put(nums[i], 0);
        }
        return pairs;
    }
}