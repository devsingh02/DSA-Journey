// MEHTOD 1 : SubSequence 

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> curset = new ArrayList<>();
        helper(0, target, candidates, curset, subset);
        return subset;
    }
    static void helper(int i, int target, int[] candidates, List<Integer> curset, List<List<Integer>> subset) {
        if (i == candidates.length || target < 0) {
            if (target == 0) subset.add(new ArrayList<>(curset));
            return;
        }
        // choice 1 : Take
        if (candidates[i] <= target) { // ***
            curset.add(candidates[i]);
            helper(i, target - candidates[i], candidates, curset, subset);
            curset.remove(curset.size() - 1);
        }
        //choice 2 : Don't Take
        helper(i + 1, target, candidates, curset, subset);
    }
}


// METHOD 2 : C(n,k) 
//
// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> subset = new ArrayList<>();
//         Stack<Integer> curset = new Stack<>();
//         helper(0, candidates, target, curset, subset);
//         return subset;
//     }

//     static void helper(int i, int[] candidates, int target, Stack<Integer> curset, List<List<Integer>> subset) {
//         if (target == 0) {
//             subset.add(new ArrayList<>(curset));
//             return;
//         }
//         if (target < 0)
//             return;
//         for (int j = i; j < candidates.length; j++) {
//             curset.push(candidates[j]);
//             target -= candidates[j];
//             helper(j, candidates, target, curset, subset);
//             target += curset.pop(); // sum + element removed
//         }
//     }
// }