class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> curset = new ArrayList<>();
        Arrays.sort(nums); //all duplicates together && nlogn << 2^n
        helper(0, nums, curset, subset);
        return subset;
    }
    static void helper(int i, int[] nums, List<Integer> curset, List<List<Integer>> subset) {
        if (i == nums.length) {
            subset.add(new ArrayList<>(curset));
            return;
        }
        //TAKE ALL DUPLICATES (recursively it will take)
        curset.add(nums[i]);
        helper(i + 1, nums, curset, subset);
        curset.remove(curset.size() - 1);
        //SKIP ALL DUPILCATES
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++; //i now at last duplicate
        helper(i + 1, nums, curset, subset);
    }
}