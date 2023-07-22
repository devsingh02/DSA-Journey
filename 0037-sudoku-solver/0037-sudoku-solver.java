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
        if (board == null || board.length != 9 || board[0].length != 9) {
            throw new IllegalArgumentException("Input is invalid");
        }

        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];
        List<int[]> blanks = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                // To Blanks List
                if (c == '.') {
                    blanks.add(new int[] { i, j });
                    continue;
                }

                // Check for Invalid Chars
                if (c < '1' || c > '9') {
                    throw new IllegalArgumentException("Invalid sudoku board");
                }

                int b = 3 * (i / 3) + (j / 3);
                int mask = 1 << (c - '1');

                // Check for unsolvable board
                if (((rows[i] & mask) != 0) || ((cols[j] & mask) != 0) || ((boxes[b] & mask) != 0)) {
                    throw new IllegalArgumentException("Invalid sudoku board");
                }

                // Add the cell to rows, cols and boxes.
                rows[i] |= mask;
                cols[j] |= mask;
                boxes[b] |= mask;
            }
        }

        if (!solveSudokuHelper(board, rows, cols, boxes, blanks, 0)) {
            throw new RuntimeException("Input sudoku does not have a valid solution");
        }
    }

    private boolean solveSudokuHelper(char[][] board, int[] rows, int[] cols, int[] boxes, List<int[]> blanks,
            int idx) {
        if (idx == blanks.size()) {
            return true;
        }

        int[] cell = blanks.get(idx);
        int i = cell[0];
        int j = cell[1];
        int b = 3 * (i / 3) + (j / 3);

        for (char c = '1'; c <= '9'; c++) {
            int mask = 1 << (c - '1');

            // Check if the number already used in row, column and sub-box.
            if (((rows[i] & mask) != 0) || ((cols[j] & mask) != 0) || ((boxes[b] & mask) != 0)) {
                continue;
            }

            // Add the cell to rows, cols and boxes.
            rows[i] |= mask;
            cols[j] |= mask;
            boxes[b] |= mask;
            board[i][j] = c;

            if (solveSudokuHelper(board, rows, cols, boxes, blanks, idx + 1)) {
                return true;
            }

            // Backtrack
            // Remove the cell to rows, cols and boxes.
            rows[i] &= ~mask;
            cols[j] &= ~mask;
            boxes[b] &= ~mask;
        }

        return false;
    }
}
