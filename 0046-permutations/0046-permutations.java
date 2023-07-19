// // METHOD 1 : Kunal / String

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutation(new ArrayList<>(), 0, nums, ans);
        return ans;
    }
    static void permutation(List<Integer> p, int ind, int[] nums, List<List<Integer>> ans) {
        if (ind == nums.length) {
            ans.add(new ArrayList<>(p));
            return;
        }
        int ch = nums[ind];
        for (int i = 0; i <= p.size(); i++) {
            List<Integer> newp = new ArrayList<>(p);
            newp.add(i, ch);
            permutation(newp, ind + 1, nums, ans);
        }
    }
}


// class Solution {
    
// public static void solve(int[] nums,List<List<Integer>>v,int i)
//     {
//         if(i>=nums.length)
//         {
//              ArrayList<Integer> cl = new ArrayList<>();
// 			//creating the list every time when the base conditions get hit
//             for(int x:nums)
//             {
//                 cl.add(x);
//             }
//             v.add(cl);
//             return;
//         }
//         for(int j=i;j<nums.length;j++)
//         {
            
//             //swap 
//     int temp=nums[i];
//     nums[i]=nums[j];
//     nums[j]=temp;
        
//             solve(nums,v,i+1);
            
            
//      //swap
//      temp=nums[i];
//     nums[i]=nums[j];
//     nums[j]=temp;
//         }
          
//     }
//     public List<List<Integer>> permute(int[] nums) {
//          List<List<Integer>>v=new ArrayList<>();
//          int i=0;
//         solve(nums,v,i);
//         return v;
        
//     }
// }

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

