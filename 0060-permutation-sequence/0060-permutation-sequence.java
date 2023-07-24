class Solution {
    public String getPermutation(int n, int k) {
        // Idea: calculate this by math
        //
        // Observation 1: (k - 1) / (n - 1)!  + 1 determines
        // which number in [1, n] comes first
        // E.g. If n = 3, k = 3,
        // then (3 - 1) / (3 - 1)! + 1
        // = 2 / 2 + 1
        // = 2
        // Thus, "2xx" would be the answer
        //
        // Observation 2: The "xx" part in "2xx" can be calculated
        // similarly as a subproblem. This is therefore a recursion problem,
        // solvable with the usual dynamic programming/iterative techniques.
        //
        // First, let's calculate all factorials from 0 to n - 1
        // Not really needed to calculate 0!, but
        // 1) it helps to calculate 1! and
        // 2) it eliminates the need for special case code
        // when finding the last number in the answer.
        int[] factorials = new int[n];
        factorials[0] = 1;
        
        for (int i = 1; i < factorials.length; ++i) {
            factorials[i] = i * factorials[i - 1];
        }
        
        // Use an array to mark which numbers in [1, n] have already
        // been used in the answer
        // Be mindful of 1-based indexing in question vs. zero-based
        // indexing in code
        boolean[] used = new boolean[n];
        
        // This is the recursive part, solved iteratively
        //
        // Observation 3: Since 0th (first) num can be found via
        // (k - 1) / (n - 1)!, the 1th (second) num can be found
        // similarly using a k'
        // k' is the remainder of (k - 1) / (n - 1)!, e.g., what is
        // left over after using the quotient of (k - 1) / (n - 1)!
        // to find the previous index.
        // Let's start with k - 1 as the remainder to find the 0th num.
        // Use k - 1 because k is 1-based indexing as phrased in the
        // question but in code we use zero-based indexing.
        int remainder = k - 1;
        
        // Accumulator for answer
        // Use StringBuilder if you want further optimization
        String answer = "";
        
        // Iterate from n - 1 down to 0
        // From observation 2 above
        for (int i = n - 1; i >= 0; --i) {
            // offset is the index of the list of unused nums in [1, n]
            // This is from observation 1 above.
            // For example, if n = 3, k = 3,
            // offset = (3 - 1) / (3 - 1)! = 1
            // 1th num in the list [1, 2, 3] is 2
            int offset = remainder / factorials[i];
            
            // iterate through the used array and find the offset-th unused num
            for (int j = 0; j < used.length; ++j) {
                if (used[j]) {
                    continue;
                }
                
                // Algorithm guarantees this will be matched once per loop
                // through the used array.
                //
                // Proof: offset is upper-bounded by i, which decreases by 1
                // every iteration of the outer loop. This is true because
                // remainder cannot exceed factorials[i + 1]. Also, we use one
                // num each iteration of the outer loop, so offset is always
                // less than or equal to the number of unused nums left.
                if (offset == 0) {
                    // j is zero-based index, but [1,n] is 1-based
                    answer += j + 1;
                    used[j] = true;
                    break;
                }
                
                --offset;
            }
            
            // From observation 3 above
            remainder %= factorials[i];
        }
        
        return answer;
    }
}