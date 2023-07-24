// class Solution {
//     public String getPermutation(int n, int k) {
//        StringBuilder res = new StringBuilder();
//        ArrayList<Integer> nums = new ArrayList<>();
//         for(int i = 1; i <= n; i++){
//             nums.add(i);
//         }
//         k--;
//         int[] factorial = new int[n];
//         factorial[0] = 1;
//         for(int i = 1; i < n; i++){
//             factorial[i] = factorial[i-1] * i;
//         }
		
//         while(n>0){
//             int p = k/factorial[n-1];
//             res.append(nums.remove(p));
//             k = k%factorial[n-1];
//             n = n-1; 
//         }
//         return res.toString();
//     }
// }
class Solution {
public String getPermutation(int n, int k) {
    //assert n >= 1 && n <= 9: "Given n will be between 1 and 9 inclusive.";
    //assert k >= 1 && k <= factorial(n): "Given k will be between 1 and n! inclusive.";

    List<Integer> candidates = new LinkedList<>();
    for (int i = 1; i <= n; i++) candidates.add(i);

    // process
    StringBuilder sb = new StringBuilder(n);
    for (int count = candidates.size(), factorial = factorial(count) ; count != 0 ; count--) {
        // [1, f(count-1)]
        factorial /= count;
        int index = (k - 1) / factorial; // 0-based index.
        k = (k - 1) % factorial + 1; // update k.

        sb.append(candidates.remove(index));
    }

    return sb.toString();
}


private int factorial(int n) {
    int result = 1;
    for (int i = 2; i <= n ; i++) {
        result *= i;
    }
    return result;
}
}
