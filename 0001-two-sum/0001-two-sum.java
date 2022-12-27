class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // <element -> index>
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {    //O(1)
                int[] ans = {map.get(target - nums[i]), i};
                return ans;
            }
            map.put(nums[i], i); // add element later since if target=6, nums[i]=3, it will return {i,i} 
        }
        return null;
    }
}

