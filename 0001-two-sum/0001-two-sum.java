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

// key must be unique, and only indices are unique, value maybe same
// BUT
// from K -> V ✓ can be found
// from V -> K X cannot be found
// ∴ since Index is to be found, put V=index K=element (∵ K->V)
