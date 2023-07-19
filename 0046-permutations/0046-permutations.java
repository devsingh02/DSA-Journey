// METHOD 1 : Kunal / String

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

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutation(new ArrayList<>(), nums, ans);
        return ans;
    }

    static void permutation(List<Integer> p, int[] nums, List<List<Integer>> ans) {
        if (p.size() == nums.length) {
            ans.add(new ArrayList<>(p));
            return;
        }

        for (int ch : nums) {
            if (!p.contains(ch)) {
                List<Integer> newp = new ArrayList<>(p);
                newp.add(ch);
                permutation(newp, nums, ans);
            }
        }
    }
}


// // METHOD 2 : SWAPPING

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

