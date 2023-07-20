class Solution {
     static List<List<String>> solveNQueens(int n) {
        // Initialize the chess board with empty cells represented by '.'
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        int[] usedCols = new int[n];    // 1 if Q present
        int[] usedLeftDiagonals = new int[2*n - 1];
        int[] usedRightDiagonals = new int[2*n - 1];

        solve(0, board, usedCols, usedLeftDiagonals, usedRightDiagonals, result);
        return result;
     }
     static void solve(int row, char[][] board, int[] usedCols, int[] usedLeftDiagonals, int[] usedRightDiagonals, List<List<String>> result) {
        if (row == board.length) {
            result.add(new ArrayList<>(arrayToList(board)));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            // Put if Safe
            if (usedCols[col] == 0 && usedLeftDiagonals[board.length - 1 - row + col] == 0 && usedRightDiagonals[row + col] == 0) {
                board[row][col] = 'Q';
                usedCols[col] = 1;
                usedLeftDiagonals[board.length - 1 - row + col] = 1;
                usedRightDiagonals[row + col] = 1;
                solve(row + 1, board, usedCols, usedLeftDiagonals, usedRightDiagonals, result); // all updated
                //backtrack
                board[row][col] = '.';
                usedCols[col] = 0;
                usedLeftDiagonals[board.length - 1 - row + col] = 0;
                usedRightDiagonals[row + col] = 0;
            }
        }
    }

    public static List<String> arrayToList(char board[][]){
        List<String> res = new ArrayList<>();   // maybe LinkedList slightly better
        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}


// //  // METHOD 2 : Kunal's / Default

// // class Solution {
// //     public List<List<String>> solveNQueens(int n) {
// //         List<List<String>> ans = new ArrayList<>();
// //         generatePermutations(new ArrayList<>(), n, ans);
// //         return ans;
// //     }
// //     static void generatePermutations(List<String> current, int n, List<List<String>> permutations) {
// //         if (current.size() == n) {
// //             permutations.add(new ArrayList<>(current));
// //             return;
// //         }
// //         for (int i = 0; i < n; i++) {
// //             if (isValid(current, i)) {
// //                 StringBuilder sb = new StringBuilder();
// //                 for (int j = 0; j < n; j++) {
// //                     if (j == i) {
// //                         sb.append("Q");
// //                     } else {
// //                         sb.append(".");
// //                     }
// //                 }
// //                 current.add(sb.toString());
// //                 generatePermutations(current, n, permutations);
// //                 current.remove(current.size() - 1);
// //             }
// //         }
// //     }
// //      static boolean isValid(List<String> current, int col) {
// //         int row = current.size();
// //         for (int i = 0; i < row; i++) {
// //             String rowStr = current.get(i);
// //             if (rowStr.charAt(col) == 'Q') {
// //                 return false;
// //             }
// //             int diff = row - i;
// //             if (col - diff >= 0 && rowStr.charAt(col - diff) == 'Q') {
// //                 return false;
// //             }
// //             if (col + diff < rowStr.length() && rowStr.charAt(col + diff) == 'Q') {
// //                 return false;
// //             }
// //         }
// //         return true;
// //     }
// // }


