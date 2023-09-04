public class NqueensOptimized {
    public static void main(String args[]) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }
        nqueen(board, 0, new boolean[board.length], new boolean[2 * n - 1], new boolean[2 * n - 1]);
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n*n)

    private static void nqueen(char[][] board, int row, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == board.length) {
            printBoard(board);

            return;
        }
        for (int col = 0; col < board[0].length; col++) {
            // if the current postion is valid for current instance of board then add the
            // queen to given postion.
            if (cols[col] == false && d1[row + col] == false && d2[row - col + board.length - 1] == false) {
                board[row][col] = 'Q';
                // and move to next row
                cols[col] = true;
                d1[row + col] = true;
                d2[row - col + board.length - 1] = true;
                nqueen(board, row + 1, cols, d1, d2);
                // if the Q does not get proper postion values backtrack.
                board[row][col] = '.';
                cols[col] = false;
                d1[row + col] = false;
                d2[row - col + board.length - 1] = false;
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

}
