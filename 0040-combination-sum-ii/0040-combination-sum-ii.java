class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> curset = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, target, candidates, curset, subset);
        return subset;
    }
    static void helper(int i, int target, int[] candidates, List<Integer> curset, List<List<Integer>> subset) {
        if (target == 0) {  //*** COND. ABOVE since MUST TAKE LAST ELEMENT
            subset.add(new ArrayList<>(curset));
            return;
        }
        if (i == candidates.length || candidates[i] > target) return;
        
        //TAKE ALL DUPLICATES
        // if (candidates[i] <= target) {
            curset.add(candidates[i]);
            helper(i + 1, target - candidates[i], candidates, curset, subset);
            curset.remove(curset.size() - 1);
        // }
        // else return;
        //SKIP ALL DUPLICATES
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) i++; //at last duplicate
        helper(i + 1, target, candidates, curset, subset);
    }
}