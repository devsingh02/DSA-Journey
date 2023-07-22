// class Solution {
//     public void solveSudoku(char[][] board) {
//         solve(board, 0, 0);
//     }
//     static boolean solve(char[][] board, int row, int col) {
//         if (row == 9) return true;
//         if (col == 9) return solve(board, row + 1, 0);
//         if (board[row][col] != '.') return solve(board, row, col + 1);
        
//         for (char num = '1'; num <= '9'; num++) {
//             if (isValid(board, num, row, col)) {
//                 board[row][col] = num;
//                 if (solve(board, row, col + 1)) return true; // if board can be solved filling this place
//             }
//         }
//         board[row][col] = '.'; // BACKTRACK
//         return false; // no number able to put
//     }
    
//     static boolean isValid(char[][] board, char num, int row, int col) {
//         // col
//         for (int i = 0; i < 9; i++) {
//             if (board[i][col] == num) return false;
//         }
//         // row
//         for (int j = 0; j < 9; j++) {
//             if (board[row][j] == num) return false;
//         }
//         // 3x3 Box
//         int sqrt = (int)Math.sqrt(9);
//         int startC = col - col%sqrt;
//         int startR = row - row%sqrt;
//         for (int i = startR; i < startR + sqrt; i++) {
//             for (int j = startC; j < startC + sqrt; j++) {
//                 if (board[i][j] == num) return false;
//             }
//         }
//         return true;
//     }
// }



class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    boolean solve(char[][] board){
        for(int i=0;i<board[0].length;i++){
            for(int j=0;j<board[0].length;j++){
                
                if(board[i][j] == '.'){
                    for(char p ='1';p <= '9';p++){
                        if(isValid(board,i,j,p)){
                            board[i][j] = p;
                            if(solve(board)) return true;
                            
                            else{
                            board[i][j] = '.';
                        }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    
    boolean isValid(char[][] board , int row , int col , char val){
        for(int m = 0 ; m < 9 ; m++){
            if(board[row][m] == val) return false;
            if(board[m][col] == val) return false;
            if(board[3*(row/3) + m/3][3*(col/3) + m%3] == val) return false;
        }
        return true;
    }
}