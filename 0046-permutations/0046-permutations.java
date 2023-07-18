class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    }
    
    public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int num: nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, ans, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}


// class Solution {
//     private void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
//         if (index == nums.length) {
//             // copy the ds to ans
//             List<Integer> ds = new ArrayList<>();
//             for (int i = 0; i < nums.length; i++) {
//                 ds.add(nums[i]);
//             }
//             ans.add(new ArrayList<>(ds));
//             return;
//         }

//         for (int i = index; i < nums.length; i++) {
//             swap(i, index, nums);
//             recurPermute(index + 1, nums, ans);
//             swap(i, index, nums);
//         }
//     }

//     private void swap(int i, int j, int[] nums) {
//         int t = nums[i];
//         nums[i] = nums[j];
//         nums[j] = t;
//     }

//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans = new ArrayList();
//         recurPermute(0, nums, ans);
//         return ans;
//     }
// }
