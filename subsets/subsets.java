class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        Stack<Integer> curset = new Stack<>();
        helper(0, nums, curset, subset);    //modifies subset
        return subset;
    }
    static void helper(int i, int[] nums, Stack<Integer> curset, List<List<Integer>> subset) {
        if (i == nums.length) {
            subset.add(new ArrayList<>(curset));
            return;
        }
        //choice : lenge
        curset.push(nums[i]);
        helper(i+1, nums, curset, subset);
        curset.pop();
        //choice : nhi lenge
        helper(i+1, nums, curset, subset);
    }
}
