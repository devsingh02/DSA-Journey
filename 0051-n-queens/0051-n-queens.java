// class Solution {
//     List<List<String>>l=new ArrayList<>();
//     void solve(  char board[][],int row,boolean[]cols,boolean[]ndiag,boolean[]rdiag){
//         if(row==board.length){
//              List<String> res=new ArrayList<>();
//             for (char p[]:board)
//               res.add(new String(p));
//             l.add(res);
//             return;
//         }
//         for(int col=0;col<board.length;col++){
//             if(cols[col]==false&&ndiag[row+col]==false&&rdiag[row-col+board.length-1]==false){
//                board[row][col]='Q';
//                cols[col]=true;
//                ndiag[row+col]=true;
//                rdiag[row-col+board.length-1]=true;
//               solve(board,row+1,cols,ndiag,rdiag);
//               board[row][col]='.';
//                cols[col]=false;
//                ndiag[row+col]=false;
//                rdiag[row-col+board.length-1]=false;
//             }
//         }
//     }
//     public List<List<String>> solveNQueens(int n) {
//         boolean cols[]=new boolean[n];//this will check the column we can put or not
//         boolean ndiag[]=new boolean[2*n-1];//this will check diagonal
//         boolean rdiag[]=new boolean[2*n-1];//this will check reverse diagonal is it safe or not
//         char [][]board=new char[n][n];
//         for(char []temp:board)
//             Arrays.fill(temp,'.');
//         solve(board,0,cols,ndiag,rdiag);
//         return l;
//     }
// }

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
        List<String> res = new ArrayList<>();   // maybe LinkedList slightly better
        for(char[] row : board){
            res.add(new String(row));
        }
        return res;
    }
}


// // //  // METHOD 2 : Kunal's / Default

// // // class Solution {
// // //     public List<List<String>> solveNQueens(int n) {
// // //         List<List<String>> ans = new ArrayList<>();
// // //         generatePermutations(new ArrayList<>(), n, ans);
// // //         return ans;
// // //     }
// // //     static void generatePermutations(List<String> current, int n, List<List<String>> permutations) {
// // //         if (current.size() == n) {
// // //             permutations.add(new ArrayList<>(current));
// // //             return;
// // //         }
// // //         for (int i = 0; i < n; i++) {
// // //             if (isValid(current, i)) {
// // //                 StringBuilder sb = new StringBuilder();
// // //                 for (int j = 0; j < n; j++) {
// // //                     if (j == i) {
// // //                         sb.append("Q");
// // //                     } else {
// // //                         sb.append(".");
// // //                     }
// // //                 }
// // //                 current.add(sb.toString());
// // //                 generatePermutations(current, n, permutations);
// // //                 current.remove(current.size() - 1);
// // //             }
// // //         }
// // //     }
// // //      static boolean isValid(List<String> current, int col) {
// // //         int row = current.size();
// // //         for (int i = 0; i < row; i++) {
// // //             String rowStr = current.get(i);
// // //             if (rowStr.charAt(col) == 'Q') {
// // //                 return false;
// // //             }
// // //             int diff = row - i;
// // //             if (col - diff >= 0 && rowStr.charAt(col - diff) == 'Q') {
// // //                 return false;
// // //             }
// // //             if (col + diff < rowStr.length() && rowStr.charAt(col + diff) == 'Q') {
// // //                 return false;
// // //             }
// // //         }
// // //         return true;
// // //     }
// // // }


