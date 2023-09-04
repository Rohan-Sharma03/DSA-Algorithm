public class RotatedSortedArraySearch {
    public static void main(String[] args) {
        int[] A = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int B = 1;
        System.out.println(findTheTargetInRotatedSortedArray(A, B));
    }

    private static int findTheTargetInRotatedSortedArray(int[] A, int B) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // if value found return the index
            if (A[mid] == B) {
                return mid;
            }
            // check for the value if the left sub-array from mid
            else if (A[left] <= A[mid]) {
                if (A[left] <= B && B < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // if value not found in left sub-array then search for the value in right
            // sub-array.
            else {
                // make sure the value is in the right sub array tehn update the value of left
                // ptr
                if (A[mid] < B && B <= A[right]) {
                    left = mid + 1;
                }
                // else update the value of right ptr
                else {
                    right = mid - 1;
                }
            }

        }
        return -1;

    }

}
