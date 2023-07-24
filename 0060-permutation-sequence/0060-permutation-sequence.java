class Solution {
    public String getPermutation(int n, int k) {
       StringBuilder res = new StringBuilder();
       ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        k--;
        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i = 1; i < n; i++){
            factorial[i] = factorial[i-1] * i;
        }
		
        while(n>0){
            int p = k/factorial[n-1];
            res.append(nums.remove(p));
            k = k%factorial[n-1];
            n = n-1; 
        }
        return res.toString();
    }
}