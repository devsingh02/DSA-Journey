// HASHMAP
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>(); // <K=element, V=1st_ Index>
        int[] sort = nums.clone(); Arrays.sort(sort);
        int[] count = new int[nums.length];
        
        for (int i = 0; i < sort.length; i++) {
            hm.putIfAbsent(sort[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            count[i] = hm.get(nums[i]);
        }
        return count;
    }
}

//  BRUTE FORCE  O(n*n)
// class Solution {
//     public int[] smallerNumbersThanCurrent(int[] nums) {
//         int[] ans = new int[nums.length];
//         for (int i = 0 ; i < nums.length; i++) {
//             int count = 0;
//             for (int J : nums) {
//                 if (J < nums[i]) count++;
//             }
//             ans[i] = count;
//         }
//         return ans;
//     }
//}