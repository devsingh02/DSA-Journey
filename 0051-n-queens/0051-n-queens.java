// // //  METHOD 2 : Kunal's / Default

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

// // // METHOD 1 : Most efficient
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
// Approach 1 : TC : O(n * 3n)  SC : O(n)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        return generateChessBoard(n);
    }
	// Make n*n Chess Board Initially filled with '.'
    static List<List<String>> generateChessBoard(int n) {
        char board[][] = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>(); // List for returning 
        int column = 0; // check for 0th column rest our recursion & Backtracking will take care of it
        checkForAllColumns(column,board,ans);
        return ans;
    }
	
	// Recursive Function for checking all the possibles cases for rows and columns
    static void checkForAllColumns(int column,char board[][],List<List<String>> ans) {
       // base case
	   if(column == board.length) {
            ans.add(convertIntoStringList(board)); // convert method to convert char array to list of String and then returned list will be added into our ans list
            return;
        }
        for(int row = 0; row < board.length; row++) {
            if(safe(row,column,board)) { // safe function for checking 'Q' is present or not
              board[row][column] = 'Q'; // if safe then put Queen in that position
              checkForAllColumns(column+1,board,ans); // call for another column i.e column+1
              board[row][column] = '.'; // during backtracking make 'Q' to '.'
            }
        }
    }
	// Converting char arr[] to List<String>
    static List<String> convertIntoStringList(char board[][]) {
        List<String> al = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]); // String Constructor will convert char array to String
            al.add(s); // add that string into our list
        }
        return al;
    }
    static boolean safe(int r,int c,char board[][]) {
        int newr = r, newc = c;
        // Left Diagonal - Upper part 
        while(r >= 0 && c >= 0) {
            if(board[r][c] == 'Q') return false;
            r--;c--;
        }
        r = newr;
        c = newc;
        // Right Diagonal - Lower part 
        while(c >= 0 && r < board.length) {
            if(board[r][c] == 'Q') return false;
            r++;
            c--;
        }
        r = newr;
        c = newc;
        // Centre Diagonal 
        while(c >= 0) {
            if(board[r][c] == 'Q') return false;
            c--;
        }
        return true;
    }
}
