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
    
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[][] grid = new int[3][3];
    
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            rows[i] |= (1<<(board[i][j]-48));
            cols[j] |= (1<<board[i][j]-48);
            grid[i/3][j/3] |= (1<<board[i][j]-48);
        }
    }
    SudokuSolver(board,0,0,rows,cols,grid);
}

public boolean SudokuSolver(char[][] board,int i,int j,int[] rows,int[] cols,int[][] grid){
    
    if(i == board.length){
        return true;
    }
    
    int ni = 0;
    int nj = 0;
    
    if(j == board[0].length-1){
        ni = i+1;
        nj = 0;
    }else{
        ni = i;
        nj = j+1;
    }
    
    if(board[i][j]!='.'){
        boolean ans = SudokuSolver(board,ni,nj,rows,cols,grid);
        if(ans)
            return true;
    }else{
        for(int pos=1;pos<=9;pos++){
            int mask = 1<<pos;
            if((rows[i] & mask) == 0 && (cols[j] & mask) == 0 && (grid[i/3][j/3] & mask) == 0){
                board[i][j] = (char) (pos+48);
                rows[i]^=mask;
                cols[j]^=mask;
                grid[i/3][j/3]^=mask;
                boolean ans = SudokuSolver(board,ni,nj,rows,cols,grid);
                if(ans)
                    return true;
                board[i][j] = '.';
                rows[i]^=mask;
                cols[j]^=mask;
                grid[i/3][j/3]^=mask;
            }
        }
    }
        
    return false;
}
}