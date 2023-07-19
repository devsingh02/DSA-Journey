// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> ans = new ArrayList<>();
//         solve(0, ans);
//         return ans;
//     }
//     static void solve(int col, List<List<String>> ans) {
        
//         for (int row = 0; row < n; row++) {
            
//         }
//     }
// }
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        generatePermutations(new ArrayList<>(), new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], n, ans);
        return ans;
    }
static void generatePermutations(List<String> current, boolean[] cols, boolean[] diagonal1, boolean[] diagonal2, int n, List<List<String>> permutations) {
        if (current.size() == n) {
            permutations.add(new ArrayList<>(current));
            return;
        }
         int row = current.size();
        for (int col = 0; col < n; col++) {
            int diag1 = row - col + n - 1;
            int diag2 = row + col;
             if (!cols[col] && !diagonal1[diag1] && !diagonal2[diag2]) {
                cols[col] = true;
                diagonal1[diag1] = true;
                diagonal2[diag2] = true;
                 StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (i == col) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                current.add(sb.toString());
                 generatePermutations(current, cols, diagonal1, diagonal2, n, permutations);
                 current.remove(current.size() - 1);
                cols[col] = false;
                diagonal1[diag1] = false;
                diagonal2[diag2] = false;
            }
        }
    }
}