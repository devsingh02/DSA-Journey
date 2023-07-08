class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> subset = new ArrayList<>();
        Stack<Integer> curset = new Stack<>();
        helper(0, candidates, target, curset, subset);
        return subset;
    }
        static void helper(int i, int[] candidates, int target, Stack<Integer> curset, List<List<Integer>> subset) {
        if (target == 0) {
            subset.add(new ArrayList<>(curset));
            return;
        }
        if (target < 0) return;
        
        for (int j = i; j < candidates.length; j++) {
            curset.push(candidates[j]); target -= candidates[j];
            helper(j, candidates, target, curset, subset);
            target += curset.pop(); //sum + element removed
        }
    }
}
    
    // METHOD 1 :
//     static void helper(int i, int sum, int[] candidates, int target, Stack<Integer> curset, List<List<Integer>> subset) {//take "i"
//         if (sum == target) {
//             subset.add(new ArrayList<>(curset));
//             return;
//         }
//         if (sum > target || i == candidates.length) return;

//         //choice -> take i
//         curset.push(candidates[i]); sum+=candidates[i];
//         helper(i , sum, candidates, target, curset, subset); 
//         sum-=curset.pop();
//         //choice -> don't take
//         helper(i + 1, sum, candidates, target, curset, subset);
//     }
// }

// METHOD 2
//     static void helper(int i, int sum, int[] candidates, int target, Stack<Integer> curset, List<List<Integer>> subset) {
//         if (sum == target) {
//             subset.add(new ArrayList<>(curset));
//             return;
//         }
//         if (sum > target) return;
        
//         for (int j = i; j < candidates.length; j++) {
//             curset.push(candidates[j]); sum += candidates[j];
//             helper(j, sum, candidates, target, curset, subset);
//             sum -= curset.pop(); //sum + element removed
//         }
//     }
// }