// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> subset = new ArrayList<>();
//         Stack<Integer> curset = new Stack<>();
//         helper(0, nums, curset, subset);
//         return subset;
//     }
//     static void helper(int i, int[] nums, Stack<Integer> curset, List<List<Integer>> subset) {
//         if (i == nums.length) {
//             subset.add(new ArrayList<>(curset));
//             return;
//         }
//         // 2 choices
//         curset.push(nums[i]);
//         helper(i + 1, nums, curset, subset);
        
//         curset.pop();
//         helper(i + 1, nums, curset, subset);
//     }
// }
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
      
        int n=nums.length;
        
        for(int i=0;i<(1<<n);i++)
        {
            List<Integer>li=new ArrayList<>();
            for(int j=0;j<=n;j++)
            {
                if(((1<<j)&i)!=0)
                {
                    li.add(nums[j]);
                }
            }
            res.add(li);
            
        }
        //Arrays.sort(res);
        return res;

    }
}
