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
        generatePermutations(new ArrayList<>(), n, ans);
        return ans;
    }
static void generatePermutations(List<String> current, int n, List<List<String>> permutations) {
        if (current.size() == n) {
            permutations.add(new ArrayList<>(current));
            return;
        }
         for (int i = 0; i < n; i++) {
            if (isValid(current, i)) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                current.add(sb.toString());
                generatePermutations(current, n, permutations);
                current.remove(current.size() - 1);
            }
        }
    }
     static boolean isValid(List<String> current, int col) {
        int row = current.size();
        for (int i = 0; i < row; i++) {
            String rowStr = current.get(i);
            if (rowStr.charAt(col) == 'Q') {
                return false;
            }
            int diff = row - i;
            if (col - diff >= 0 && rowStr.charAt(col - diff) == 'Q') {
                return false;
            }
            if (col + diff < rowStr.length() && rowStr.charAt(col + diff) == 'Q') {
                return false;
            }
        }
        return true;
    }
}