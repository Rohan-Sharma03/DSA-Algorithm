import java.util.Arrays;

class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                { 0, 0, 0, 0, 0, 0, 2, 0, 0 },
                { 0, 8, 0, 0, 0, 7, 0, 9, 0 },
                { 6, 0, 2, 0, 0, 0, 5, 0, 0 },
                { 0, 7, 0, 0, 6, 0, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 4, 0 },
                { 0, 0, 5, 0, 0, 0, 6, 0, 3 },
                { 0, 9, 0, 4, 0, 0, 0, 7, 0 },
                { 0, 0, 6, 0, 0, 0, 0, 0, 0 }
        };
        if (sudokuSolver(board)) {
            System.out.println("Solved Sudoku:");
            printSudoku(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    private static boolean sudokuSolver(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    for (int val = 1; val < 10; val++) {
                        if (isSafe(i, j, val, board)) {
                            board[i][j] = val;
                            if (sudokuSolver(board)) {
                                return true; // If the puzzle is solved, return true
                            }
                            board[i][j] = 0; // If this placement leads to a dead end, backtrack
                        }
                    }
                    return false; // No valid number can be placed here, backtrack
                }
            }
        }
        return true; // All cells are filled, puzzle is solved
    }

    private static boolean isSafe(int row, int col, int val, int[][] board) {
        // row check
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }

        // col check
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }

        // grid check
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }

        return true; // The placement is valid
    }

    private static void printSudoku(int[][] board) {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
