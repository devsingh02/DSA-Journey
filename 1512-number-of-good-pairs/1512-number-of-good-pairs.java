// New element forms pair with all previous same elements(count == pairs of current num)

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>(); // <K=element, V=count>
        int Total_pairs = 0;
        for (int num : nums) {
            int curr_count = hm.getOrDefault(num, 0); //return count if num present, else return 0
            Total_pairs += curr_count;
            hm.put(num, curr_count+1);
        }
        return Total_pairs;
    }
}

//SOLUTION 1
// class Solution {
//     public int numIdenticalPairs(int[] nums) {
//         HashMap<Integer, Integer> hm = new HashMap<>(); // <element, count>
//         int pairs = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (hm.containsKey(nums[i])) {
//                 int count = hm.get(nums[i]);
//                 pairs += count;   //pairs+=count (total current handshakes)
//                 hm.put(nums[i], ++count);
//             }
//             else
//                 hm.put(nums[i], 1);
//         }
//         return pairs;
//     }
// }

//SOLUTION 2
// class Solution {
//     public int numIdenticalPairs(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>(); // <element, count>
//         int pairs = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (map.containsKey(nums[i])) {
//                 map.put(nums[i], map.get(nums[i]) + 1);
//                 pairs += map.get(nums[i]);
//             }
//             else
//                 map.put(nums[i], 0);
//         }
//         return pairs;
//     }
// }