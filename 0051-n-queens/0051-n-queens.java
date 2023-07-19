
 class Solution {
     static List<List<String>> solveNQueens(int n) {
        // Initialize the chess board with empty cells represented by '.'
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        // Initialize lists to store the solutions
        List<List<String>> res = new ArrayList<>();
        // Initialize arrays to keep track of used columns and diagonals
        int[] usedCols = new int[n];
        int[] usedLowerDiagonal = new int[2 * n - 1];
        int[] usedUpperDiagonal = new int[2 * n - 1];
        // Call the recursive solve method
        solve(0, board, res, usedCols, usedLowerDiagonal, usedUpperDiagonal);
        // Return the solutions
        return res;
    }
     // Recursive function to solve the N-Queens problem
    static void solve(int row, char[][] board, List<List<String>> res, int[] usedCols, int[] usedLowerDiagonal, int[] usedUpperDiagonal){
        // If all rows are filled with queens, add the solution to the list and return
        if (row == board.length){
            res.add(construct(board));
            return;
        }
        // Try placing a queen in each column of the current row
        for (int col = 0; col < board.length; col++){
            // Check if the current cell is safe for a queen
            if(usedCols[col] == 0 && usedLowerDiagonal[col + row] == 0 && usedUpperDiagonal[board.length - 1 + row - col] == 0){
                // Place the queen in the current cell
                board[row][col] = 'Q';
                // Mark the used column and diagonals
                usedCols[col] = 1;
                usedLowerDiagonal[col + row] = 1;
                usedUpperDiagonal[board.length - 1 + row - col] = 1;
                // Recursively solve for the next row
                solve(row + 1, board, res, usedCols, usedLowerDiagonal, usedUpperDiagonal);
                // Remove the queen from the current cell
                board[row][col] = '.';
                // Unmark the used column and diagonals
                usedCols[col] = 0;
                usedLowerDiagonal[col + row] = 0;
                usedUpperDiagonal[board.length - 1 + row - col] = 0;
            }
        }
    }
    // Helper function to construct a list of strings representing the chess board
    static List<String> construct(char board[][]){
        List<String> res = new LinkedList<>();
        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
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

//  // METHOD 2 : Kunal's / Default

// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> ans = new ArrayList<>();
//         generatePermutations(new ArrayList<>(), n, ans);
//         return ans;
//     }
//     static void generatePermutations(List<String> current, int n, List<List<String>> permutations) {
//         if (current.size() == n) {
//             permutations.add(new ArrayList<>(current));
//             return;
//         }
//         for (int i = 0; i < n; i++) {
//             if (isValid(current, i)) {
//                 StringBuilder sb = new StringBuilder();
//                 for (int j = 0; j < n; j++) {
//                     if (j == i) {
//                         sb.append("Q");
//                     } else {
//                         sb.append(".");
//                     }
//                 }
//                 current.add(sb.toString());
//                 generatePermutations(current, n, permutations);
//                 current.remove(current.size() - 1);
//             }
//         }
//     }
//      static boolean isValid(List<String> current, int col) {
//         int row = current.size();
//         for (int i = 0; i < row; i++) {
//             String rowStr = current.get(i);
//             if (rowStr.charAt(col) == 'Q') {
//                 return false;
//             }
//             int diff = row - i;
//             if (col - diff >= 0 && rowStr.charAt(col - diff) == 'Q') {
//                 return false;
//             }
//             if (col + diff < rowStr.length() && rowStr.charAt(col + diff) == 'Q') {
//                 return false;
//             }
//         }
//         return true;
//     }
// }



// // METHOD 3 : TC : O(n) SC : O(n)
// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         return generateChessBoard(n);
//     }
//     static List<List<String>> generateChessBoard(int n) {
//         char board[][] = new char[n][n];
//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j < n; j++) {
//                 board[i][j] = '.';
//             }
//         }
//         List<List<String>> ans = new ArrayList<>();
//         int column = 0;
//         int CD[] = new int[n];  // checking queens in centre left diagonal
//         int RD[] = new int[2*n+1]; // checking queens in upper part right diagonal
//         int LD[] = new int[2*n+1];  //  checking queens in lower part of left diagonal 
//         checkForAllColumns(column,board,ans,CD,LD,RD);
//         return ans;
//     }
//     static void checkForAllColumns(int column,char board[][],List<List<String>> ans,int CD[],int LD[],int RD[]) {
//         if(column == board.length) {
//             ans.add(convertIntoStringList(board));
//             return;
//         }
//         for(int row = 0; row < board.length; row++) {
// 		    // 1. CD[row] will take care of centre left diagonal
// 			// 2. LD[row+column] will take care of lower part of left diagonal
// 			// 3. RD[(n-1) + (column-row)] will take care of upper part of right diagonal ( n = board.length)
//             if(CD[row] == 0 && LD[column+row] == 0 && RD[(board.length-1) + (column-row)] == 0) {
// 			  // During placement of Queens
//               board[row][column] = 'Q';
//               CD[row] = 1;
//               LD[column+row] = 1;  
//               RD[(board.length-1) + (column-row)] = 1;
//               checkForAllColumns(column+1,board,ans,CD,LD,RD);
//               // During Backtracking
// 			  board[row][column] = '.';
//               CD[row] = 0;
//               LD[column+row] = 0;  
//               RD[(board.length-1) + (column-row)] = 0;  
//             }
//         }
//     }
//     static List<String> convertIntoStringList(char board[][]) {
//         List<String> al = new ArrayList<>();
//         for(int i = 0; i < board.length; i++) {
//             String s = new String(board[i]);
//             al.add(s);
//         }
//         return al;
//     }
// }
