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

    private int[] rowRestrictedNumbers;
    private int[] columnRestrictedNumbers;
    private int[] squareRestrictedNumbers;

    //[] - row, [] - column
    public void solveSudoku(char[][] board) {
        if(board == null)
            return;

        rowRestrictedNumbers = new int[9];
        columnRestrictedNumbers = new int[9];
        squareRestrictedNumbers = new int[9];
        fillInitialRestrictions(board);
        sudokuSolverHelper(board);
    }

    private boolean sudokuSolverHelper(char[][] board) {
        int availableNumbers, ri = 0, ci = 0, count = 0;
        int minAvailableNumbers = Integer.MAX_VALUE;
        for(int row = 0 ; row < 9 ; row++) {
            for (int column = 0; column < 9; column++) {
                if(board[row][column] == '.') {
                    availableNumbers = getAvailableNumbersCountForPosition(row, column);
                    if(minAvailableNumbers > availableNumbers) {
                        minAvailableNumbers = availableNumbers;
                        ri = row;
                        ci = column;
                    }
                    count++;
                }
            }
        }

        if(count == 0)
            return false;

        int arr = getAvailableNumbersForPosition(ri, ci);
        for(int i = 0; i < 9; i++) {
            int value = 1 << i;
            if ((arr & value) != 0)
               continue;

            board[ri][ci] = (char) (i + '1');
            if(count == 1)
                return true;

            setNumberToRestrictedArrays(ri, ci, value);
            if(sudokuSolverHelper(board))
                return true;

            removeNumberFromRestrictedArrays(ri, ci, value);
            board[ri][ci] = '.';
        }
        return false;
    }

    private void fillInitialRestrictions(char[][] board){
        for(int row = 0 ; row < 9 ; row++) {
            for (int column = 0; column < 9; column++) {
                if(board[row][column] == '.')
                    continue;
                int value = (1 << (board[row][column]-'1'));
                setNumberToRestrictedArrays(row, column, value);
            }
        }
    }

    private void setNumberToRestrictedArrays(int row, int column, int value) {
        setNumberToRestricted(rowRestrictedNumbers, row, value);
        setNumberToRestricted(columnRestrictedNumbers, column, value);
        setNumberToRestricted(squareRestrictedNumbers, getSquareFromPosition(row, column), value);
    }

    private void removeNumberFromRestrictedArrays(int row, int column, int value) {
        removeNumberFromRestricted(rowRestrictedNumbers, row, value);
        removeNumberFromRestricted(columnRestrictedNumbers, column, value);
        removeNumberFromRestricted(squareRestrictedNumbers, getSquareFromPosition(row, column), value);
    }

    //if 1 then restricted;
    private void setNumberToRestricted(int[] arr, int position, int value) {
        arr[position] |= value;
    }

    private void removeNumberFromRestricted(int[] arr, int position, int value) {
        arr[position] &= ~value;
    }

    private int getAvailableNumbersForPosition(int row, int column) {
        int r = rowRestrictedNumbers[row];
        int c = columnRestrictedNumbers[column];
        int s = squareRestrictedNumbers[getSquareFromPosition(row, column)];
        return r | c | s;
    }

    private int getAvailableNumbersCountForPosition(int row, int column) {
        int x = getAvailableNumbersForPosition(row, column);
        int count = 0;
        for(int i = 0; i < 9; i++) {
            count += (~(x >> i) & 1);
        }
        return count;
    }

    private int getSquareFromPosition(int row, int column) {
        return row / 3 * 3 + column / 3;
    }
}