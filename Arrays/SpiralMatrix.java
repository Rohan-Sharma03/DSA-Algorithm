import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public void main(String args[][]) {
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int srow = 0, erow = n - 1, scol = 0, ecol = matrix[0].length - 1;
        while (srow <= erow && scol <= ecol) {
            // top boundary
            for (int i = scol; i <= ecol; i++) {
                list.add(matrix[srow][i]);
            }
            // after adding values from the current frame incerement the row number
            srow++;
            // right boundary
            for (int i = srow; i <= erow; i++) {
                list.add(matrix[i][ecol]);
            }
            // after adding values from the current frame decrement the max col number
            ecol--;
            // bottom boundary
            for (int i = ecol; i >= scol; i--) {
                if (srow <= erow) {
                    list.add(matrix[erow][i]);
                }
            }
            // after adding values from the current frame decrement the max row number
            erow--;
            // left boundary
            for (int i = erow; i >= srow; i--) {
                if (scol <= ecol) {
                    list.add(matrix[i][scol]);
                }
            }
            // after adding values from the current frame incerement the min col number
            scol++;
        }
        // return list;
        System.out.println(list);
    }

}
