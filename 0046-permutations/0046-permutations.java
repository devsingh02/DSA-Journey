// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         permutation(new ArrayList<>(), 0, nums, ans);
//         return ans;
//     }
//     static void permutation(List<Integer> p, int ind, int[] nums, List<List<Integer>> ans) {
//         if (ind == nums.length) {
//             ans.add(new ArrayList<>(p));
//             return;
//         }
//         int ch = nums[ind];
//         for (int i = 0; i <= p.size(); i++) {
//             // List<Integer> f = new ArrayList<>(); for(int b = 0; b < a; b++) f.add(nums[b]);
//             // List<Integer> l = new ArrayList<>(); for(int b = a; b < p.size(); b++) l.add(nums[b]);
//             List<Integer> newp = new ArrayList<>();
//             for (int k = 0; k < p.size(); k++) {
//                 if (k == i) {
//                     newp.add(ch);
//                     newp.add(p.get(k));
//                     continue;
//                 }
//                 newp.add(p.get(k));
//             }
//             if (i == p.size()) newp.add(ch);
//             permutation(newp, ind + 1, nums, ans);
//         }
//     }
// }

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
class Solution {
    private void backtrack(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            ans.add(permutation);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            backtrack(index + 1, nums, ans);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, ans);
        return ans;
    }
}
