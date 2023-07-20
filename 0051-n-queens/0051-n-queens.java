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
            result.add(arrayToList(board));
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

        List<String> res = new LinkedList<>();

        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }

        return res;
    }
    // static List<String> arrayToList(char[][] board) {
    //     List<String> list = new ArrayList<>();
    //     for (int i = 0; i < board.length; i++) {
    //         String row = "";
    //         for (int j = 0; j < board.length; j++) {
    //             row += board[i][j];
    //         }
    //         list.add(row);
    //     }
    //     return list;
    // }   
}

// // METHOD 1 : Most efficient
// class Solution {

//     public List<List<String>> solveNQueens(int n) {
        
//         // Initialize the chess board with empty cells represented by '.'
//         char[][] board = new char[n][n];
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < n; j++){
//                 board[i][j] = '.';
//             }
//         }

//         // Initialize lists to store the solutions
//         List<List<String>> res = new ArrayList<>();

//         // Initialize arrays to keep track of used rows and diagonals
//         int[] usedRows = new int[n];
//         int[] usedLowerDiagonal = new int[2*n - 1];
//         int[] usedUpperDiagonal = new int[2*n - 1];

//         // Call the recursive solve method
//         solve(0, board, res, usedRows, usedLowerDiagonal, usedUpperDiagonal);

//         // Return the solutions
//         return res;
//     }

//     // Recursive function to solve the N-Queens problem
//     public void solve(int col, char[][] board, List<List<String>> res, int[] usedRows, int[] usedLowerDiagonal, int[] usedUpperDiagonal){

//         // If all columns are filled with queens, add the solution to the list and return
//         if(col == board.length){
//             res.add(construct(board));
//             return;
//         }

//         // Try placing a queen in each row of the current column
//         for(int row = 0; row < board.length; row++){

//             // Check if the current cell is safe for a queen
            
//             if(usedRows[row] == 0 && usedLowerDiagonal[row + col] == 0 && usedUpperDiagonal[board.length - 1 + col - row] == 0){

//                 // Place the queen in the current cell
//                 board[row][col] = 'Q';

//                 // Mark the used row and diagonals
//                 usedRows[row] = 1;
//                 usedLowerDiagonal[row + col] = 1;
//                 usedUpperDiagonal[board.length - 1 + col - row] = 1;

//                 // Recursively solve for the next column
//                 solve(col + 1, board, res, usedRows, usedLowerDiagonal, usedUpperDiagonal);

//                 // Remove the queen from the current cell
//                 board[row][col] = '.';

//                 // Unmark the used row and diagonals
//                 usedRows[row] = 0;
//                 usedLowerDiagonal[row + col] = 0;
//                 usedUpperDiagonal[board.length - 1 + col - row] = 0;
//             }
//         }
//     }

//     // Helper function to construct a list of strings representing the chess board
//     public List<String> construct(char board[][]){

//         List<String> res = new LinkedList<>();

//         for(int i = 0; i < board.length; i++){
//             String s = new String(board[i]);
//             res.add(s);
//         }

//         return res;
//     }
// }

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


