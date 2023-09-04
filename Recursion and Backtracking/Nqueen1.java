public class Nqueen1 {
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }
        nqueen(board, 0);
    }

    // Time Complexity : O(n*n!)
    // Space Complexity : O(n*n)

    private static void nqueen(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);

            return;
        }
        for (int col = 0; col < board[0].length; col++) {
            // if the current postion is valid for current instance of board then add the
            // queen to given postion.
            if (isValidPosition(board, col, row)) {
                board[row][col] = 'Q';
                // and move to next row
                nqueen(board, row + 1);
                // if the Q does not get proper postion values backtrack.
                board[row][col] = '.';
            }
        }
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    private static boolean isValidPosition(char[][] board, int col, int row) {
        // check row
        for (int r = 0; r < row; r++) {
            if (board[r][col] == 'Q') {
                return false;
            }
        }

        // check diagnonal 1
        for (int r = row - 1, c = col + 1; r >= 0 && c < board[0].length; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // check diagnonal 2
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

}
