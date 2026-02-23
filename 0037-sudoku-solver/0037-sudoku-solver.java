class Solution {

    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // If empty cell found
                if (board[row][col] == '.') {

                    // Try digits 1 to 9
                    for (char digit = '1'; digit <= '9'; digit++) {

                        if (isSafe(board, row, col, digit)) {

                            board[row][col] = digit;

                            // Recurse
                            if (backtrack(board)) {
                                return true;
                            }

                            // Undo (Backtrack)
                            board[row][col] = '.';
                        }
                    }

                    // If no digit works → backtrack
                    return false;
                }
            }
        }

        // No empty cell left → Sudoku solved
        return true;
    }

    private boolean isSafe(char[][] board, int row, int col, char digit) {

        for (int i = 0; i < 9; i++) {

            // Check row
            if (board[row][i] == digit)
                return false;

            // Check column
            if (board[i][col] == digit)
                return false;

            // Check 3×3 grid
            int subRow = 3 * (row / 3) + i / 3;
            int subCol = 3 * (col / 3) + i % 3;

            if (board[subRow][subCol] == digit)
                return false;
        }

        return true;
    }
}