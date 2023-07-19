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
//         int[] usedLowerDiagonal = new int[2 * n - 1];
//         int[] usedUpperDiagonal = new int[2 * n - 1];

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
