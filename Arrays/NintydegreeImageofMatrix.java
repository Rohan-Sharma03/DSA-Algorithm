public class NintydegreeImageofMatrix {
    public static void main(String args[]) {

        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // step 1: taking transpose of matrix.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                // swap a[i][j] with a[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        /**
         * transpose
         * 1 2 3 | 1 4 7 | 1 4 7
         * 4 5 6 | 2 5 6 | 2 5 8
         * 7 8 9 | 3 8 9 | 3 6 9
         */

        // step 2 : swaping the columns of the array.
        /**
         * 1 4 7 | 7 4 1
         * 2 5 8 | 8 5 2
         * 3 6 9 | 9 6 3
         * 
         */

        int left = 0, right = matrix[0].length - 1;
        while (left < right) {
            // change row number
            for (int i = 0; i < matrix.length; i++) {
                // swap a[i][left] with a[j][i]
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left++;
            right--;
        }
    }

}
