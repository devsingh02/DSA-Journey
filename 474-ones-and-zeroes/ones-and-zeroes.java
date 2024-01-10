// class Solution {
//     public int findMaxForm(String[] strs, int m, int n) {
//         int N = strs.length;
//         Map<String, Integer> memo = new HashMap<>();
//         return solve(strs, memo, N, m, n);
//     }
//     int solve(String[] str, Map<String,Integer> memo, int n, int M, int N) {
//         // BASE CASES :- if this occurs no way (Smallest Valid + Invalid input)
//         if (M < 0 || N < 0) return 0;
//         if (n == 0) return 0;

//         String key = n + " " + M + "-" + N;
//         if (memo.containsKey(key)) return memo.get(key);

//         int zeros = zeros(str[n-1]);
//         int ones = ones(str[n-1]);
//         int ans;
//         if (zeros <= M && ones <= N)
//             ans = Math.max(1 + solve(str, memo, n-1, M-zeros, N-ones), solve(str, memo, n-1, M, N));
//         else ans = solve(str, memo, n-1, M, N);

//         memo.put(key, ans);
//         return ans;
//     }
//     int zeros(String s) {
//         int count = 0;
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '0') count += 1;
//         }
//         return count;
//     }
//     int ones(String s) {
//         int count = 0;
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '1') count += 1;
//         }
//         return count;
//     }
// }

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int N = strs.length;
        int[][][] memo = new int[N + 1][m + 1][n + 1];
        return solve(strs, memo, N, m, n);
    }

    int solve(String[] str, int[][][] memo, int n, int M, int N) {
        // BASE CASES :- if this occurs no way (Smallest Valid + Invalid input)
        if (M < 0 || N < 0) return 0;
        if (n == 0) return 0;

        if (memo[n][M][N] != 0) return memo[n][M][N];

        int zeros = zeros(str[n-1]);
        int ones = ones(str[n-1]);
        int ans;
        if (zeros <= M && ones <= N)
            ans = Math.max(1 + solve(str, memo, n-1, M-zeros, N-ones), solve(str, memo, n-1, M, N));
        else
            ans = solve(str, memo, n-1, M, N);

        memo[n][M][N] = ans;
        return ans;
    }

    int zeros(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') count += 1;
        }
        return count;
    }

    int ones(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count += 1;
        }
        return count;
    }
}
