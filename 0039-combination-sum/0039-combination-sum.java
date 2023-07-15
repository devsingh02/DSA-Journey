class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> subset = new ArrayList<>();
        Stack<Integer> curset = new Stack<>();
        helper(0, target, candidates, curset, subset);
        return subset;
    }
    static void helper(int i, int target, int[] candidates, Stack<Integer> curset, List<List<Integer>> subset) {
        if (i == candidates.length || target < 0) {
            if (target == 0) subset.add(new ArrayList<>(curset));
            return;
        }
        // choice 1 : Take
        curset.push(candidates[i]);
        helper(i, target - candidates[i], candidates, curset, subset);
        //choice 2 : Don't Take
        curset.pop();
        helper(i + 1, target, candidates, curset, subset);
    }
}