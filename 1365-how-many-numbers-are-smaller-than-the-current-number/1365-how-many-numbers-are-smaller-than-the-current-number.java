class Solution {    //O(n)
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];  // constraint given 0-100
        int[] res = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {  //O(n)
            count[nums[i]]++;
        }
        
        for (int i = 1 ; i <= 100; i++) {  //O(n)
            count[i] += count[i-1];    
        }
        
        for (int i = 0; i < nums.length; i++) {  //O(n)
            if (nums[i] == 0)   //nothing less than 0
                res[i] = 0;
            else 
                res[i] = count[nums[i] - 1];
        }
        
        return res;        
    }
}

// HASHMAP  (Sorting occuring ∴ more time (O(n*logn)))
// class Solution {
//     public int[] smallerNumbersThanCurrent(int[] nums) {
//         HashMap<Integer, Integer> hm = new HashMap<>(); // <K=element, V=1st_ Index>
//         int[] sort = nums.clone(); Arrays.sort(sort);
//         int[] count = new int[nums.length];
        
//         for (int i = 0; i < sort.length; i++) {
//             hm.putIfAbsent(sort[i], i);
//         }
//         for (int i = 0; i < nums.length; i++) {
//             count[i] = hm.get(nums[i]);
//         }
//         return count;
//     }
// }

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